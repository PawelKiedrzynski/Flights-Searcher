package pl.flightssearcher;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        System.out.println("--- Flights Searcher ---");
        FlightDatabase flightDatabase = new FlightDatabase();
        flightDatabase.checkIfFlightExists("Lodz", "Madrid");
        flightDatabase.displayFlightsFromCity("Warsaw");
        flightDatabase.displayFlightsToCity("Madrid");
        System.out.println("Flight list: ");
        ArrayList<String> cities = flightDatabase.getCities();
        System.out.println(cities);
        Flight cheapestFlight = flightDatabase.getCheapestFlight();
        System.out.println("Cheapest flight: " + cheapestFlight.getDetails());
        Flight cheapestFlightFromCity = flightDatabase.getCheapestFlightFromCity("Paris");
        System.out.println("Cheapest flight from city: " + cheapestFlightFromCity.getDetails());
        ArrayList<Journey> journeys = flightDatabase.getFlights("Paris", "Porto");
        System.out.println(journeys);

    }
}

