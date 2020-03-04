package pl.flightssearcher;

public class Flight {
    private String departure;
    private String arrival;
    private int price;

    public Flight(String departure, String arrival, int price) {
        this.departure = departure;
        this.arrival = arrival;
        this.price = price;
    }

    public String getDeparture() {
        return departure;
    }

    public String getArrival() {
        return arrival;
    }

    public int getPrice() {
        return price;
    }

    public String getDetails() {
        return "Flight from " + departure + " to " + arrival + " costs " + price;
    }
}
