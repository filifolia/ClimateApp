public class City {
	private int id;
	private String name;
	private Coord coord;
	private String country;
	private int population;
	
	public City(){
		id = 0;
		name = "";
		coord = new Coord();
		country = "";
		population = 0;
	}
	
	public void setid(int id){
		this.id = id;
	}
	public int getid(){
		return id;
	}
	public void setname(String name){
		this.name = name;
	}
	public String getname(){
		return name;
	}
	public void setcoord(Coord coord){
		this.coord = coord;
	}
	public Coord getcoord(){
		return coord;
	}
	public void setcountry(String country){
		this.country = country;
	}
	public String getcountry(){
		return country;
	}
	public void setpopulation(int population){
		this.population = population;
	}
	public int getpopulation(){
		return population;
	}
	
	public class Coord{
		private double lon;
		private double lat;
		
		public Coord(){
			this.lon = 0;
			this.lat = 0;
		}
		public void setlon(double lon){
			this.lon = lon;
		}
		public double getlon(){
			return lon;
		}
		public void setlat(double lat){
			this.lat = lat;
		}
		public double getlat(){
			return lat;
		}
	}
}
