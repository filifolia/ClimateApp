public class Weather{
	private int id;
	private String main;
	private String description;
	private String icon;
	
	public Weather(){
		id = 0;
		main = "";
		description = "";
		icon = "";
	}
	public void setid(int id){
		this.id = id;
	}
	public int getid(){
		return id;
	}
	public void setmain(String main){
		this.main = main;
	}
	public String getmain(){
		return main;
	}
	public void setdescription(String description){
		this.description = description;
	}
	public String getdescription(){
		return description;
	}
	public void seticon(String icon){
		this.icon = icon;
	}
	public String geticon(){
		return icon;
	}
}