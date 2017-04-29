import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.DeserializationConfig;
import java.io.*;
import java.util.*;
import java.net.URL;
import java.text.*;

public class Run {

	public static void main(String[] args) {
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
		catch(JsonParseException e){
			System.out.print(e.getMessage()+ "\nJson Parse error");
		}
		catch(JsonMappingException e){
			System.out.print(e.getMessage()+ "\nJson mapping error");
		}
		catch(IOException e){
			System.out.print(e.getMessage()+ "\nIOException error");
		}
	}

}
