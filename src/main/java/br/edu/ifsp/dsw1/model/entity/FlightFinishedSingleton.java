package br.edu.ifsp.dsw1.model.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FlightFinishedSingleton {
	private final List<FlightData> finishedFlights = new ArrayList<FlightData>();

    private static FlightFinishedSingleton instance;

    private FlightFinishedSingleton() {}
    
    // pega a instacia dessa classe
    public static synchronized FlightFinishedSingleton getInstance() {
        if (instance == null) {
            instance = new FlightFinishedSingleton();
        }
        return instance;
    }
    
    // adiciona voos em estado tookOff
    public void addFinishedFlight(FlightData flight) {
        if (!finishedFlights.contains(flight)) { /// verifica se ja não foi adicionado
            finishedFlights.add(flight);
        }
    }

    public List<FlightData> getAllFinishedFlights() {
        return Collections.unmodifiableList(finishedFlights); // retorna a lista de voos tookOff
    }
}
