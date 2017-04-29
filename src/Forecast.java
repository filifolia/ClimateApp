import java.util.*;
public class Forecast{
		private int dt;
		private Temperature temp;
		private double pressure;
		private int humidity;
		private List<Weather> weather;
		private double speed;
		private int deg;
		private int clouds;
		private double rain;
		
		public Forecast(){
			dt = 0;
			temp = new Temperature();
			pressure = 0;
			humidity = 0;
			weather = new ArrayList<Weather>();
			speed = 0;
			deg = 0;
			clouds = 0;
			rain = 0;
		}
		public void setdt(int dt){
			this.dt = dt;
		}
		public int getdt(){
			return dt;
		}
		public void settemp(Temperature temp){
			this.temp = temp;
		}
		public Temperature gettemp(){
			return temp;
		}
		public void setpressure(double pressure){
			this.pressure = pressure;
		}
		public double getpressure(){
			return pressure;
		}
		public void sethumidity(int humidity){
			this.humidity = humidity;
		}
		public int gethumidity(){
			return humidity;
		}
		public void setweather(List<Weather> weather){
			this.weather = weather;
		}
		public List<Weather> getweather(){
			return weather;
		}
		public void setspeed(double speed){
			this.speed = speed;
		}
		public double getspeed(){
			return speed;
		}
		public void setdeg(int deg){
			this.deg = deg;
		}
		public int getdeg(){
			return deg;
		}
		public void setclouds(int clouds){
			this.clouds = clouds;
		}
		public int getclouds(){
			return clouds;
		}
		public void setrain(double rain){
			this.rain = rain;
		}
		public double getrain(){
			return rain;
		}
		

	}
