package pl.flightssearcher;

public class Journey {
    private Flight first;
    private Flight second;

    public Journey(Flight first, Flight second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "Flight from " + first.getDeparture() + " to "
                + second.getArrival() + " with stop at " + first.getArrival() +
                " costs " + (first.getPrice() + second.getPrice());
    }
}
