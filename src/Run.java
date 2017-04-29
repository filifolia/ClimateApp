import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.DeserializationConfig;
import java.io.*;
import java.util.*;
import java.net.URL;

public class Run {

	public static void main(String[] args) {
		String url = "http://api.openweathermap.org/data/2.5/forecast/daily?q=Jakarta&mode=json&units=metric&cnt=5&APPID=481e3bc28e5264e5607c2b65b449bfc1";
		ObjectMapper mapper = new ObjectMapper();
		//mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try{
			//Map<String, Object> map = mapper.readValue(new URL(url), Map.class);
			//ArrayList<Fore> lists = (ArrayList) map.get("list");
			
			//System.out.print(lists.get(0).dt);
			Data data = mapper.readValue(new URL(url), Data.class);
			System.out.print(data);
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
