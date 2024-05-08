
package ucakrezervasyonsystem;


public class Economy extends Ticket{
    
    public Economy(Flight fligh, String userName, Passenger passenger, Seat seat,String airportName) {
        super(fligh, userName, passenger, seat, airportName);
        this.max_kg = 15;
        this.price = fligh.getEconomyPrice();
        
    }
    
}
