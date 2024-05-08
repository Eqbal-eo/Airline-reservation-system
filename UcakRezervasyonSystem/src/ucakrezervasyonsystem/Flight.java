
package ucakrezervasyonsystem;

import java.time.LocalDate;
import java.time.LocalTime;


public class Flight {

    private int flightNumber;
    private Airport airport;
//    private int fromID;
//    private int toID;
    private City fromID;
    private City toID;
    private LocalDate departurreDate;
    private LocalTime departureTime;
    private LocalDate arrivalDate;
    private LocalTime arrivalTime;
    private int capacity;
    private int availableSeats;
    private double economyPrice;
    private double businessPrice;
    Seat[][] seats;

    public Flight(int flightNumber, Airport airport, City fromID, City toID) {
        this.flightNumber = flightNumber;
        this.airport = airport;
        this.fromID = fromID;
        this.toID = toID;
        this.capacity = 60;
        this.availableSeats = capacity;
        this.seats = new Seat[10][6];
    }

    public Seat[][] getSeats() {
        return seats;
    }

    public void setSeats(Seat[][] seats) {
        this.seats = seats;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    public City getFromID() {
        return fromID;
    }

    public void setFromID(City fromID) {
        this.fromID = fromID;
    }

    public City getToID() {
        return toID;
    }

    public void setToID(City toID) {
        this.toID = toID;
    }

    public LocalDate getDeparturreDate() {
        return departurreDate;
    }

    public void setDeparturreDate(LocalDate departurreDate) {
        this.departurreDate = departurreDate;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getEconomyPrice() {
        return economyPrice;
    }

    public void setEconomyPrice(double economyPrice) {
        this.economyPrice = economyPrice;
    }

    public double getBusinessPrice() {
        return businessPrice;
    }

    public void setBusinessPrice(double businessPrice) {
        this.businessPrice = businessPrice;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    String getInfoFotTicket() {
        String source_city = MyColors.setForground(this.fromID.toString(), MyColors.GREEN_BOLD);
        String dest_city = MyColors.setForground(this.toID.toString(), MyColors.GREEN_BOLD);
        String f_number = MyColors.setForground("" + this.flightNumber, MyColors.GREEN_BOLD);
        String f_departurreDate = MyColors.setForground(this.departurreDate.toString(), MyColors.GREEN_BOLD);
        String f_departureTime = MyColors.setForground(this.departureTime.toString(), MyColors.GREEN_BOLD);
        String f_arrivalDate = MyColors.setForground(this.arrivalDate.toString(), MyColors.GREEN_BOLD);
        String f_arrivalTime = MyColors.setForground(this.arrivalTime.toString(), MyColors.GREEN_BOLD);

        return "Flight Number: " + f_number + "\nFrom " + source_city + " To " + dest_city
                + "\nDeparturre Date: " + f_departurreDate + "\nDeparturre Time: " + f_departureTime
                + "\nArrival Date: " + f_arrivalDate + "\nArrival Time: " + f_arrivalTime;

    }

    @Override
    public String toString() {
        String source_city = MyColors.setForground(this.fromID.toString(), MyColors.GREEN_BOLD);
        String dest_city = MyColors.setForground(this.toID.toString(), MyColors.GREEN_BOLD);
        String f_number = MyColors.setBackgroun("Flight Number: " + this.flightNumber, MyColors.PURPLE_BACKGROUND);
        String f_capacity = MyColors.setForground(this.capacity + "", MyColors.GREEN_BOLD);
        String f_availableSeats = MyColors.setForground(this.availableSeats + "", MyColors.GREEN_BOLD);
        String f_economyPrice = MyColors.setForground(this.economyPrice + "", MyColors.GREEN_BOLD);
        String f_businessPrice = MyColors.setForground(this.businessPrice + "", MyColors.GREEN_BOLD);
        String f_departurreDate = MyColors.setForground(this.departurreDate.toString(), MyColors.GREEN_BOLD);
        String f_departureTime = MyColors.setForground(this.departureTime.toString(), MyColors.GREEN_BOLD);
        String f_arrivalDate = MyColors.setForground(this.arrivalDate.toString(), MyColors.GREEN_BOLD);
        String f_arrivalTime = MyColors.setForground(this.arrivalTime.toString(), MyColors.GREEN_BOLD);

        return f_number + "\nFrom " + source_city + " To " + dest_city + "\ncapacity: " + f_capacity
                + "\nDeparturre Date: " + f_departurreDate + "\nDeparturre Time: " + f_departureTime
                + "\nArrival Date: " + f_arrivalDate + "\nArrival Time: " + f_arrivalTime
                + "\navailable seats: " + f_availableSeats + "\nEconomy Ticket Price: "
                + f_economyPrice + "\nBusiness Ticket Price: " + f_businessPrice;
    }

}
