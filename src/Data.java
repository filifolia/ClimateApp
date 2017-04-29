import java.util.ArrayList;
import java.util.List;

public class Data {
	private City city;
	private String cod;
	private double message;
	private int cnt;
	private List<Forecast> list;
	
	public Data(){
		this.city = new City();
		this.cod = "";
		this.message = 0;
		this.cnt = 0;
		this.list = new ArrayList<Forecast>();
	}
	public Data(City city, String cod, double message, int cnt, List<Forecast> list){
		this.city = city;
		this.cod = cod;
		this.message = message;
		this.cnt = cnt;
		this.list = list;
	}
	public void setCity(City city){
		this.city = city;
	}
	public City getCity(){
		return this.city;
	}
	public void setcod(String cod){
		this.cod = cod;
	}
	public String getcod(){
		return this.cod;
	}
	public void setmessage(double message){
		this.message = message;
	}
	public double getmessage(){
		return this.message;
	}
	public void setcnt(int cnt){
		this.cnt = cnt;
	}
	public int getcnt(){
		return cnt;
	}
	public void setlist(List<Forecast> list){
		this.list = list;
	}
	public List<Forecast> getlist(){
		return list;
	}

}
