
package ucakrezervasyonsystem;


public class Seat {

    private boolean Full;
    private String gender = "";//M(Male) or F(Female)
    private int number;
    private String statusColor = MyColors.GREEN;
    private String backgroundColor = "";
    Seat rightSeat;
    Seat leftSeat;

    public Seat(int number) {
        this.Full = false;
        this.number = number;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    
    
    @Override
    public String toString() {

        String s = String.valueOf(number);
        s = !gender.equals("") ? gender : s;

        if (s.length() == 1) {
            s = MyColors.setBackgroun(s + "   ", backgroundColor);
            return MyColors.setForground(s + "   ", statusColor);
        } else {
            s = MyColors.setBackgroun(s + "   ", backgroundColor);
            return MyColors.setForground(s + "  ", statusColor);
        }
    }

    public String getStatusColor() {
        return statusColor;
    }

    public void setStatusColor(String statusColor) {
        this.statusColor = statusColor;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender.toUpperCase();
        if (this.gender.equals("M")) {
            this.statusColor = MyColors.BLUE;
        }else{
            this.statusColor = MyColors.PURPLE;
        }
    }

    public Seat getRightSeat() {
        return rightSeat;
    }

    public void setRightSeat(Seat rightSeat) {
        this.rightSeat = rightSeat;
    }

    public Seat getLeftSeat() {
        return leftSeat;
    }

    public void setLeftSeat(Seat leftSeat) {
        this.leftSeat = leftSeat;
    }

    public boolean isFull() {
        return Full;
    }

    public void setFull(boolean Full) {
        this.Full = Full;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}
