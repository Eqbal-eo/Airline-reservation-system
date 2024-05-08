
package ucakrezervasyonsystem;

import java.time.LocalDate;

public class Ticket {

    private static int TICKET_ID = 0;
    private int ticket_id;
    private String airportName;
    private Flight flight;
    private String userName;
    private Passenger passenger;
    private LocalDate dateOfPurchase;
    private Seat seat;
    int max_kg;
    double price;

    public Ticket(Flight flight, String userName, Passenger passenger, Seat seat,String airportName) {
        this.ticket_id = TICKET_ID++;
        this.flight = flight;
        this.userName = userName;
        this.passenger = passenger;
        this.seat = seat;
        this.airportName = airportName;
        dateOfPurchase = LocalDate.now();
        
    }

    public static int getTICKET_ID() {
        return TICKET_ID;
    }

    public static void setTICKET_ID(int TICKET_ID) {
        Ticket.TICKET_ID = TICKET_ID;
    }

    public int getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(int ticket_id) {
        this.ticket_id = ticket_id;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public LocalDate getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(LocalDate dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public int getMax_kg() {
        return max_kg;
    }

    public void setMax_kg(int max_kg) {
        this.max_kg = max_kg;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    @Override
    public String toString() {
        String type;
        if (this instanceof Business) {
            type = "Business";
        }else{
            type = "Economy";
        }
        type = MyColors.setForground(type,MyColors.BLUE);
        String ticketID = MyColors.setBackgroun("Ticket ID: " + this.ticket_id,MyColors.GREEN_BACKGROUND);
        String passenger_name = MyColors.setForground(this.passenger.getName(),MyColors.BLUE);
        String passenger_age = MyColors.setForground(this.passenger.getAge()+"",MyColors.BLUE);
        String user_name = MyColors.setForground(this.userName,MyColors.BLUE);
        String sear_number = MyColors.setForground(this.seat.getNumber()+"",MyColors.BLUE);
        String date = MyColors.setForground(this.dateOfPurchase.toString(),MyColors.BLUE);
        return  ticketID +"\nTicket type: "+type+"\n" +flight.getInfoFotTicket() +"\nAirport Name: " + this.airportName +"\nBooked user: " + user_name
                + "\nPassenger name: " + passenger_name + "\nPassenger age: " + passenger_age+
                "\nSear Number: "+sear_number+"\nDateof purchase: "+date;
    }

}
