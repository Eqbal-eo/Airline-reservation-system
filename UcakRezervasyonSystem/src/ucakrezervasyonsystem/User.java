
package ucakrezervasyonsystem;

import java.util.ArrayList;

public class User {

    private static int USER_ID = 0;
    private int id;
    private String name;
    private int age;
    private String phone;
    private ArrayList<Ticket> myTickets;
    private double myMoney;

    public User(String name, int age, String phone) {
        this.id = USER_ID++;
        this.name = name;
        this.age = age;
        this.phone = phone;
        myTickets = new ArrayList<>();
    }

    public User(String name, int age, String phone, double myMoney) {
        this.id = USER_ID++;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.myMoney = myMoney;
        myTickets = new ArrayList<>();
    }
   
    public void listMyTickets() {
        for (Ticket myTicket : myTickets) {
            System.out.println(myTicket);
        }
    }
    public void removeTicket(int index, Airport airport) {
        if (index < myTickets.size() && index > -1) {
            this.myMoney += myTickets.get(index).getPrice();
            airport.cancelTicket(myTickets.get(index).getFlight().getFlightNumber(), myTickets.get(index).getSeat());
            myTickets.remove(index);
            
            
        }else{
            System.out.println(MyColors.setRED("Index does not exists!"));
        }
        
    }
    public void showMyMoney() {
        System.out.println("Your remaining money: "+MyColors.setGreen(""+this.myMoney));
    }

    public double getMyMoney() {
        return myMoney;
    }

    public void setMyMoney(double myMoney) {
        this.myMoney = myMoney;
    }

    void addTicket(Ticket ticket) {
        myTickets.add(ticket);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
