package br.edu.ifsp.dsw1.model.entity;

public class FlightDataSingleton {
	
	private static FlightDataCollection instance;
	
	private FlightDataSingleton() {}
	
	public static synchronized FlightDataCollection getInstance() {
		if(instance == null) {
			instance = new FlightDataCollection();
		}
		
		return instance;
	}
}
