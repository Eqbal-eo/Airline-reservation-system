
package ucakrezervasyonsystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Utils {

    static Airport thisAirport = null;

    public static void readFile(Flight[] flights) {

        int counter = 0;
        try {
            Scanner reader = new Scanner(new File("src/ucakrezervasyonsystem/flights_date.txt"));
            while (reader.hasNext()) {
                String nextLine = reader.nextLine();
                String[] line = nextLine.replace("\n", "").split(" ");

                String[] departurre = line[0].split("_");

                String[] arrival = line[1].split("_");

                String[] departurre_date = departurre[0].split("-");
                String[] departurre_time = departurre[1].split("-");

                String[] arrival_date = arrival[0].split("-");
                String[] arrival_time = arrival[1].split("-");

                int departurre_year = Integer.parseInt(departurre_date[0]);
                int departurre_month = Integer.parseInt(departurre_date[1]);
                int departurre_day = Integer.parseInt(departurre_date[2]);
                int departurre_hour = Integer.parseInt(departurre_time[0]);
                int departurre_minute = Integer.parseInt(departurre_time[1]);

                int arrival_year = Integer.parseInt(arrival_date[0]);
                int arrival_month = Integer.parseInt(arrival_date[1]);
                int arrival_day = Integer.parseInt(arrival_date[2]);
                int arrival_hour = Integer.parseInt(arrival_time[0]);
                int arrival_minute = Integer.parseInt(arrival_time[1]);

                flights[counter].setDeparturreDate(LocalDate.of(departurre_year, departurre_month, departurre_day));
                flights[counter].setDepartureTime(LocalTime.of(departurre_hour, departurre_minute));
                flights[counter].setArrivalDate(LocalDate.of(arrival_year, arrival_month, arrival_day));
                flights[counter].setArrivalTime(LocalTime.of(arrival_hour, arrival_minute));
                flights[counter].setEconomyPrice(Double.parseDouble(line[2]));
                flights[counter].setBusinessPrice(Double.parseDouble(line[3]));
                counter++;

                if (counter == flights.length) {
                    break;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static void printFlights(Airport airport) {
        System.out.println("All Flights From " + airport + ":");
        for (Flight flight : airport.getFlights()) {
            System.out.println(flight);
        }
    }

    static void buyTicket(User user, Airport airport, int flight_number) {
        String p_name, p_gender;
        int p_age;

        airport.getFlightInfo(flight_number);
        p_name = scannerString("Enter passenger Name: ");
        p_gender = scannerString("Enter passenger gender as 'M' for Male and 'F' for Female): ");
        p_age = scannerInterger("Enter passenger age: ");
        Passenger passenger = new Passenger(p_name, p_age, p_gender);
        boolean isAvaiable = controlSeat("Choose a Seat: ", flight_number, passenger, user);
        airport.getFlightInfo(flight_number);

    }
    static void main(Airport[] airports,User user){
        while (true) {
            Airport ap = Utils.chooseAirport(airports);
            if (!Utils.start(ap, user)) {
                break;
            }
        }
    }
    static boolean start(Airport airport, User user) {
        thisAirport = airport;
        printFlights(airport);
        int flight_number = 0;
        //buyTicket(user, airport, flight_number);
        while (true) {
            System.out.println(MyColors.setGreen("0 Exit"));
            System.out.println(MyColors.setGreen("1 List my tickets"));
            System.out.println(MyColors.setGreen("2 Buy a ticket"));
            System.out.println(MyColors.setGreen("3 Choose a flight"));
            System.out.println(MyColors.setGreen("4 Choose an airport"));
            System.out.println(MyColors.setGreen("5 Show my money"));
            System.out.println(MyColors.setGreen("6 cancel ticket"));
            switch (scannerInterger("Choose operation: ")) {
                case 0:
                    if (true) {
                        return false;
                    }
                    break;
                case 1:
                    user.listMyTickets();
                    break;
                case 2:
                    buyTicket(user, airport, flight_number);
                    break;
                case 3:
                    printFlights(airport);
                    flight_number = controlFlightNumber("Choose Flight By Its Number: ", airport.getFlights().length);
                    buyTicket(user, airport, flight_number);
                    break;
                case 4:
                    if (true) {
                        return true;
                    }
                    break;
                case 5:
                    user.showMyMoney();
                    break;
                case 6:
                    user.listMyTickets();
                    int ticket_id = scannerInterger(MyColors.setGreen("Cancel ticket by entering its ID: "));
                    user.removeTicket(ticket_id, thisAirport);
                    break;

                default:
                // code block
            }
        }

    }

    static String scannerString(String msg) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print(msg);
            String s = sc.nextLine();
            if (!s.equals("")) {
                return s;
            } else {
                System.out.println(MyColors.setForground("invalid", MyColors.RED));
            }
        }
    }

    static int scannerInterger(String msg) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print(msg);
            int i = sc.nextInt();
            if (i >= 0) {
                return i;
            } else {
                System.out.println(MyColors.setForground("invalid", MyColors.RED));
            }
        }
    }

    static int controlFlightNumber(String msg, int flights_count) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print(msg);
            int flight_number = sc.nextInt();
            if (flight_number > -1 && flight_number < flights_count) {
                return flight_number;
            } else {
                System.out.println(MyColors.setForground("Choose a valid Flight Number which is in [0, " + (flights_count - 1) + "]", MyColors.RED));
            }
        }
    }

    static boolean controlSeat(String msg, int flight_number, Passenger passenger, User user) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print(msg);
            int selected_seat = sc.nextInt();
            if (selected_seat > 0 && selected_seat <= 60) {
                boolean notValid = false;
                for (Seat[] seats : thisAirport.getFlight(flight_number).getSeats()) {
                    for (Seat seat : seats) {
                        if (selected_seat == seat.getNumber()) {
                            if (seat.isFull()) {
                                System.out.println(MyColors.setForground("This is a full seat choose another one!", MyColors.RED));
                                notValid = false;
                                break;
                            }
                            boolean isAvaiable = true;
                            if (seat.getLeftSeat() != null) {
                                if (seat.getLeftSeat().isFull()) {
                                    if (!passenger.getGender().equals(seat.getLeftSeat().getGender())) {
                                        String gender = seat.getLeftSeat().getGender().equals("M") ? "Male" : "Female";
                                        System.out.println(MyColors.setForground("This  seat is avaiable only for " + gender + " passengers, choose another one!", MyColors.RED));
                                        notValid = false;
                                        isAvaiable = false;
                                        break;
                                    }
                                }

                            }
                            if (seat.getRightSeat() != null) {
                                if (seat.getRightSeat().isFull()) {

                                    if (!passenger.getGender().equals(seat.getRightSeat().getGender())) {
                                        String gender = seat.getRightSeat().getGender().equals("M") ? "Male" : "Female";
                                        System.out.println(MyColors.setForground("This  seat is avaiable only for " + gender + " passengers, choose another one!", MyColors.RED));
                                        notValid = false;
                                        isAvaiable = false;
                                        break;
                                    }
                                }

                            }

                            if (isAvaiable) {
                                Ticket ticket;
                                String type = scannerString("Choose Ticket Type use B for Business and E for Economy  : ");
                                type = type.toUpperCase();
                                if (type.equals("B")) {
                                    ticket = new Business(thisAirport.getFlight(flight_number), user.getName(), passenger, seat,thisAirport.getAirportName());
                                } else {
                                    ticket = new Economy(thisAirport.getFlight(flight_number), user.getName(), passenger, seat,thisAirport.getAirportName());
                                }
                                if (ticket.price < user.getMyMoney()) {
                                    user.setMyMoney(user.getMyMoney() - ticket.price);
                                    //seat.setStatusColor(MyColors.RED);
                                    seat.setGender(passenger.getGender());
                                    seat.setFull(true);
                                    user.addTicket(ticket);
                                    thisAirport.getFlight(flight_number).setAvailableSeats(thisAirport.getFlight(flight_number).getAvailableSeats() - 1);
                                    System.out.println(MyColors.setForground("Your ticket purchase has been successfully completed.", MyColors.GREEN));
                                    return true;
                                } else {
                                    System.out.println(MyColors.setForground("Your Money is not enough, you have " + user.getMyMoney() + " the ticket price is " + ticket.price + "!", MyColors.RED));
                                    System.out.println(MyColors.setForground("You can try other seats of flights", MyColors.YELLOW));
                                    break;
                                }

                            }

                        }
                    }
                    if (notValid) {
                        break;
                    }
                }
            } else {
                System.out.println(MyColors.setForground("Choose a valid Seat Number which is in [1, 60]", MyColors.RED));
            }

        }
    }

    static Airport[] createAirports(String[] cities_name, int number_of_Flights) {
        Airport[] airports = new Airport[cities_name.length];
        for (int i = 0; i < airports.length; i++) {
            airports[i] = new Airport(cities_name[i] + " Airport", number_of_Flights, new City(cities_name[i]));
        }
        return airports;
    }

    static Airport chooseAirport(Airport[] airports) {

        for (int i = 0; i < airports.length; i++) {
            
            System.out.println(MyColors.setGreen(i + " ")+ airports[i]);
        }
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Choose Airport by entering its id: ");
            int id = sc.nextInt();
            if (id >= 0 && id < airports.length) {
                return airports[id];
            } else {
                System.out.println(MyColors.setForground("invalid,Airport is should be in [0, " + (airports.length - 1) + "]", MyColors.RED));
            }
        }

    }

}
