package br.edu.ifsp.dsw1.model.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FlightFinishedSingleton {
	private final List<FlightData> finishedFlights = new ArrayList<FlightData>();

    private static FlightFinishedSingleton instance;

    private FlightFinishedSingleton() {}

    public static synchronized FlightFinishedSingleton getInstance() {
        if (instance == null) {
            instance = new FlightFinishedSingleton();
        }
        return instance;
    }

    public void addFinishedFlight(FlightData flight) {
        if (!finishedFlights.contains(flight)) {
            finishedFlights.add(flight);
        }
    }

    public List<FlightData> getAllFinishedFlights() {
        return Collections.unmodifiableList(finishedFlights);
    }
}
