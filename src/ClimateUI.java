import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
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
			}
		});
		btnSelect.setBounds(433, 91, 88, 25);
		contentPane.add(btnSelect);
		
		
	}
}
