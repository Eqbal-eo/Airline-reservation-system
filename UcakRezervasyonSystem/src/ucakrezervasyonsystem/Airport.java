
package ucakrezervasyonsystem;


public class Airport {

    static int AIRPORT_ID = 0;
    private int airportID;
    private String airportName;
    private City location;
    private Flight[] flights;
    private City[] Cities;
    
    public Airport(String airportName, int flights_count, City location) {
        this.airportID = AIRPORT_ID++;
        this.airportName = airportName;
        this.flights = new Flight[flights_count];
        createCities();
        for (City city : Cities) {
            if (location.getName() == city.getName()) {
                this.location = city;
                break;
            }
        }
        createFlights();

    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public Flight[] getFlights() {
        return flights;
    }

    public Flight getFlight(int flight_number) {
        return flights[flight_number];
    }

    public void setFlights(Flight[] flights) {
        this.flights = flights;
    }

    void getFlightInfo(int flight_number) {
        System.out.println(flights[flight_number]);
        Seat[][] thisFlightSeats = flights[flight_number].getSeats();
        for (int j = 0; j < thisFlightSeats.length; j++) {
            for (int k = 0; k < thisFlightSeats[0].length; k++) {
                System.out.print(thisFlightSeats[j][k]);
                if (k == 2) {
                    System.out.print("    ");
                }
            }
            System.out.println("");
        }
    }

    void createCities() {
        String[] cities_name = {"Istanbul", "Gaziantep", "Bursa", "Mersin", "Düzce"};
        Cities = new City[cities_name.length];
        for (int i = 0; i < Cities.length; i++) {
            Cities[i] = new City(cities_name[i]);
        }
    }

    //LocalDate departurreDate, LocalTime departureTime,LocalDate arrivalDate,LocalTime arrivalTime
    void createFlights() {
        int x = 0;
        for (int i = 0; i < flights.length; i++) {
            if (this.location.getId() == Cities[i].getId()) {
                x = 1;
            }
            flights[i] = new Flight(i, this, this.location, Cities[i+x]);
            Seat[][] thisFlightSeats = flights[i].getSeats();
            int counter = 1;
            for (int j = 0; j < thisFlightSeats.length; j++) {
                for (int k = 0; k < thisFlightSeats[0].length; k++) {
                    thisFlightSeats[j][k] = new Seat(counter++);
                }
            }
            for (int j = 0; j < thisFlightSeats.length; j++) {
                for (int k = 0; k < thisFlightSeats[0].length; k++) {
                    try {
                        thisFlightSeats[j][k].leftSeat = thisFlightSeats[j][k - 1];
                    } catch (Exception e) {
                        thisFlightSeats[j][k].leftSeat = null;
                    }
                    try {
                        thisFlightSeats[j][k].rightSeat = thisFlightSeats[j][k + 1];
                    } catch (Exception e) {
                        thisFlightSeats[j][k].rightSeat = null;
                    }

                }
            }
        }
        Utils.readFile(flights);

    }
    void cancelTicket(int flight_number, Seat removed_seat){
        for (Flight flight : flights) {
            if (flight.getFlightNumber() == flight_number) {
                for (Seat[] seats : flight.getSeats()) {
                    for (Seat seat : seats) {
                        if (removed_seat.getNumber() == seat.getNumber()) {
                            seat.setFull(false);
                            seat.setGender("");
                            seat.setStatusColor(MyColors.GREEN);
                            System.out.println(MyColors.setGreen("Your ticket has been removed successfuly"));
                            return;
                        }
                    }
                }
                
                break;
            }
        }
        System.out.println(MyColors.setRED("Ticket does not exists!"));
    
    }
    void printCities() {
        for (City city : Cities) {
            System.out.println(city.getId() + ": " + city.getName());
        }

    }

    void printFlights() {
        System.out.println("******************************Flights***************************");
        for (Flight flight : flights) {
            System.out.println("---------------------------------------------------");
            System.out.println(flight);
            Seat[][] thisFlightSeats = flight.getSeats();
            for (int j = 0; j < thisFlightSeats.length; j++) {
                for (int k = 0; k < thisFlightSeats[0].length; k++) {
                    System.out.print(thisFlightSeats[j][k]);
                    if (k == 2) {
                        System.out.print("    ");
                    }
                }
                System.out.println("");
            }
            System.out.println("---------------------------------------------------");
        }
        System.out.println("******************************Flights***************************");
    }

    @Override
    public String toString() {
        return this.airportName;
    }

}
