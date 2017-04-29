import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class ClimateUI extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClimateUI frame = new ClimateUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClimateUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 725, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblClimateApplication = new JLabel("Climate Application");
		lblClimateApplication.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblClimateApplication.setBounds(175, 13, 363, 53);
		contentPane.add(lblClimateApplication);
		
		String[] cities = {"Jakarta", "Tokyo", "London"};
		JComboBox comboBox = new JComboBox(cities);
		comboBox.setSelectedIndex(0);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		comboBox.setBounds(189, 92, 232, 22);
		contentPane.add(comboBox);
		
		String cityName = (String)comboBox.getSelectedItem();
		Object columnNames[] = {cityName, "Temperature", "Variance"};
		Object data[][] = {{"", "", ""}};
		table = new JTable(data, columnNames);
		table.setBounds(192, 395, 329, -152);
		contentPane.add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(157, 197, 381, 185);
		contentPane.add(scrollPane);
		
		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cityNameUpdate = (String)comboBox.getSelectedItem();
				table.getColumnModel().getColumn(0).setHeaderValue(cityNameUpdate);
				table.getTableHeader().repaint();
				
				String url = "http://api.openweathermap.org/data/2.5/forecast/daily?q=Jakarta&mode=json&units=metric&cnt=5&APPID=481e3bc28e5264e5607c2b65b449bfc1";
				ObjectMapper mapper = new ObjectMapper();
				//mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
				try{
					Data data = mapper.readValue(new URL(url), Data.class);
					List<Forecast> listData = data.getlist();
					double averageTemp = 0, averageVar = 0;
					for(Forecast f : listData){
						Date date = new Date(f.getdt()*1000);
				        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				        format.setTimeZone(TimeZone.getTimeZone("PST"));
				        String formatted = format.format(date);
						System.out.println("Date: " + formatted);
						System.out.println("Temp: " + f.gettemp().getday());
						System.out.println("Variance: " + (f.gettemp().getmax()- f.gettemp().getmin()) + "\n");
						averageTemp += f.gettemp().getday();
						averageVar += (f.gettemp().getmax()- f.gettemp().getmin());
					}
					averageTemp /= 5;
					System.out.println("Average Temperature for 5 days: " + Math.floor(averageTemp * 100)/100);
					averageVar /= 5;
					System.out.println("Average Variance for 5 days: " + Math.floor(averageVar * 100)/100);
				}
				catch(JsonParseException ex){
					System.out.print(ex.getMessage()+ "\nJson Parse error");
				}
				catch(JsonMappingException ex){
					System.out.print(ex.getMessage()+ "\nJson mapping error");
				}
				catch(IOException ex){
					System.out.print(ex.getMessage()+ "\nIOException error");
				}
			}
		});
		btnSelect.setBounds(433, 91, 88, 25);
		contentPane.add(btnSelect);
		
		
	}
}
