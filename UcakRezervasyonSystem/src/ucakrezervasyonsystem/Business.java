
package ucakrezervasyonsystem;

public class Business extends Ticket {

    public Business(Flight fligh, String userName, Passenger passenger, Seat seat,String airportName) {
        super(fligh, userName, passenger, seat, airportName);
        this.max_kg = 30;
        this.price = fligh.getBusinessPrice();
    }

}
