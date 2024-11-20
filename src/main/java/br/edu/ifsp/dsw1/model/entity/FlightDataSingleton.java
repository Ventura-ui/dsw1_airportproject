package br.edu.ifsp.dsw1.model.entity;

public class FlightDataSingleton {
	
	private static FlightDataCollection instance;
	
	private FlightDataSingleton() {}
	
	// retorna a instancia do colection para que possamos utilizar a mesma lista de voos em nossos commands/servlets
	public static synchronized FlightDataCollection getInstance() {
		if(instance == null) {
			instance = new FlightDataCollection();
		}
		
		return instance;
	}
}
