package pl.flightssearcher;

import java.util.ArrayList;

public class FlightDatabase {
    ArrayList<Flight> flightsList = new ArrayList<Flight>();

    public FlightDatabase() {
        this.flightsList.add(new Flight("Berlin", "Tokyo", 1800));
        this.flightsList.add(new Flight("Paris", "Berlin", 79));
        this.flightsList.add(new Flight("Warsaw", "Paris", 120));
        this.flightsList.add(new Flight("Madrid", "Berlin", 200));
        this.flightsList.add(new Flight("Berlin", "Warsaw", 77));
        this.flightsList.add(new Flight("Paris", "Madrid", 180));
        this.flightsList.add(new Flight("Porto", "Warsaw", 412));
        this.flightsList.add(new Flight("Madrid", "Porto", 102));
        this.flightsList.add(new Flight("Warsaw", "Madrid", 308));
        this.flightsList.add(new Flight("Warsaw", "Chicago", 2200));
    }

    public void checkIfFlightExists(String start, String end) {
        for (Flight fly : flightsList) {
            if (start.equals(fly.getDeparture()) && end.equals(fly.getArrival())) {
                System.out.println("Flight exists !!!");
                return;
            }
        }
        System.out.println("Flight from " + start + " to " + end + " not exists.");
    }

    public ArrayList<Flight> getFlightsFromCity(String city) {
        ArrayList<Flight> results = new ArrayList<Flight>();
        for (Flight fly : flightsList) {
            if (city.equals(fly.getDeparture())) {
                results.add(fly);
            }
        }
        return results;
    }

    public ArrayList<Flight> getFlightsToCity(String city) {
        ArrayList<Flight> results = new ArrayList<Flight>();
        for (Flight fly : flightsList) {
            if (city.equals(fly.getArrival())) {
                results.add(fly);
            }
        }
        return results;
    }

    public void displayFlights(ArrayList<Flight> result) {
        if (result.isEmpty()) {
            System.out.println("Flight not found");
        }
        for (Flight fly : result) {
            System.out.println(fly.getDetails());
        }
    }

    public void displayFlightsFromCity(String city) {
        ArrayList<Flight> results = getFlightsFromCity(city);
        displayFlights(results);
    }

    public void displayFlightsToCity(String city) {
        ArrayList<Flight> results = getFlightsToCity(city);
        displayFlights(results);
    }

    public ArrayList<String> getCities() {
        ArrayList<String> cities = new ArrayList<>();
        for (Flight fly : flightsList) {
            if (!cities.contains(fly.getDeparture())) {
                cities.add(fly.getDeparture());
            }
            if (!cities.contains(fly.getArrival())) {
                cities.add(fly.getArrival());
            }
        }
        return cities;
    }

    public Flight getCheapestFlight() {
        Flight cheapestFlight = null;
        for (Flight fly : flightsList) {
            if (cheapestFlight == null || fly.getPrice() < cheapestFlight.getPrice()) {
                cheapestFlight = fly;
            }
        }
        return cheapestFlight;
    }

    public Flight getCheapestFlightFromCity(String city) {
        ArrayList<Flight> fromCity = getFlightsFromCity(city);
        Flight cheapestFlight = null;
        for (Flight fly : fromCity) {
            if (cheapestFlight == null || fly.getPrice() < cheapestFlight.getPrice()) {
                cheapestFlight = fly;
            }
        }
        return cheapestFlight;
    }

    public ArrayList<Journey> getFlights(String start, String end) {
        ArrayList<Flight> starting = getFlightsFromCity(start);
        ArrayList<Flight> ending = getFlightsToCity(end);
        ArrayList<Journey> results = new ArrayList<Journey>();
        for (Flight first : starting) {
            for (Flight second : ending) {
                if (first.getArrival().equals(second.getDeparture())) {
                    results.add(new Journey(first, second));

                }
            }
        }
        return results;
    }
}
