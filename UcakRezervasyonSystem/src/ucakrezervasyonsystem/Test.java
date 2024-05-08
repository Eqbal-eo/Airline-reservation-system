
package ucakrezervasyonsystem;


public class Test {
    //{"Istanbul", "Gaziantep", "Bursa", "Mersin", "Düzce"};

    public static void main(String[] args) {
        String userName, userPhone;
        int userAge,money;
        userName = Utils.scannerString("Enter your Name: ");
        userPhone = Utils.scannerString("Enter your phone number: ");
        userAge = Utils.scannerInterger("Enter your age: ");
        money = Utils.scannerInterger("Enter your money: ");
        User user = new User(userName, userAge, userPhone,money/1.0);
        
        String[] cities_name = {"Istanbul", "Gaziantep", "Bursa", "Mersin", "Düzce"};
        Airport[] airports = Utils.createAirports(cities_name, 4);
        Utils.main(airports, user);

    }
}
