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
		public class Temperature{
			private double day;
			private double min;
			private double max;
			private double night;
			private double eve;
			private double morn;
		}
		public class Weather{
			private int id;
			private String main;
			private String description;
			private String icon;
			
		}
	}
