import java.time.LocalDate;
import java.util.ArrayList;

import static java.time.temporal.ChronoUnit.DAYS;

public abstract class Residence {
    //Residence properties
    private String meal;
    private int numberOfBeds;
    private int costWithBreakfast;
    private int costWithThreeMeals;
    private int number;
    private String name;
    private ArrayList<Reservation> reservations = new ArrayList<>();

    Residence(int costWithBreakfast,
              int costWithThreeMeals,
              String name,
              int numberOfBeds,
              int number,
              String meal) {
        this.meal = meal;
        this.name = name;
        this.numberOfBeds = numberOfBeds;
        this.costWithBreakfast = costWithBreakfast;
        this.costWithThreeMeals = costWithThreeMeals;
        this.number = number;


    }
    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public int getNumber() {
        return number;
    }

    public String getMeal() { return meal; }

    public String getName() { return name; }

    // static method that return the number between rwo dates
    public static int getNumberBetweenDates(LocalDate checkIn, LocalDate checkOut) {
        long numberOfDaysBetween = DAYS.between(checkIn, checkOut);
        return (int) numberOfDaysBetween;
    }

    // return full cost for that Residence for that date
    public int getFullCost(LocalDate checkIn, LocalDate checkOut) {
        int numberOfNights = getNumberBetweenDates(checkIn, checkOut);
        if (meal.equals("Breakfast")) return numberOfNights * costWithBreakfast;
        return numberOfNights * costWithThreeMeals;
    }

    //each of its children should override it
    public abstract String toString (LocalDate checkIn, LocalDate checkOut);

    //reserves the Residence for that date by adding new Reservation
    // to the reservations list

    public void reserve(LocalDate checkIn, LocalDate checkOut,User user){
        reservations.add(new Reservation(this,checkIn,checkOut,user));

    }
    //check if the Residence is available for that date
    public boolean isAvailable(LocalDate checkIn, LocalDate checkOut){
        boolean isFree=false;
        if(reservations.size()==0) return true;
        else {
            for (int i = 0; i < reservations.size(); i++) {
                if ((checkIn.isAfter(reservations.get(i).getCheckOut()) && checkOut.isAfter(reservations.get(i).getCheckOut())) ||
                        (checkIn.isBefore(reservations.get(i).getCheckIn()) && checkOut.isBefore(reservations.get(i).getCheckIn()))){
                    isFree=true;
                }


            }
            if(isFree) return true;
            else return false;
        }

    }

}
