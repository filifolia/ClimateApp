public class Temperature{
	private double day;
	private double min;
	private double max;
	private double night;
	private double eve;
	private double morn;
	
	public Temperature(){
		day = 0;
		min = 0;
		max = 0;
		night = 0;
		eve = 0;
		morn = 0;
	}
	public void setday(double day){
		this.day = day;
	}
	public double getday(){
		return day;
	}
	public void setmin(double min){
		this.min = min;
	}
	public double getmin(){
		return min;
	}
	public void setmax(double max){
		this.max = max;
	}
	public double getmax(){
		return max;
	}
	public void setnight(double night){
		this.night = night;
	}
	public double getnight(){
		return night;
	}
	public void seteve(double eve){
		this.eve = eve;
	}
	public double geteve(){
		return eve;
	}
	public void setmorn(double morn){
		this.morn = morn;
	}
	public double getmorn(){
		return morn;
	}
}
