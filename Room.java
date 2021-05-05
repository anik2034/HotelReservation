import java.time.LocalDate;
import java.util.ArrayList;

import static java.time.temporal.ChronoUnit.DAYS;

public class Room  {
    private String name;
    private boolean breakfast;
    private boolean threeMeals;
    private int numberOfBeds;
    private int costWithBreakfast;
    private int costWithThreeMeals;
    private int number;
    public ArrayList<Reservation> reservations = new ArrayList<>();


    Room( int costWithBreakfast,
          int costWithThreeMeals,
          String name,
          int numberOfBeds,
          boolean breakfast,
          boolean threeMeals,
          int number){
        this.breakfast=breakfast;
        this.threeMeals=threeMeals;
        this.name=name;
        this.numberOfBeds=numberOfBeds;
        this.costWithBreakfast=costWithBreakfast;
        this.costWithThreeMeals=costWithThreeMeals;
        this.number=number;


    }
    public boolean isBreakfast() {
        return breakfast;
    }

    public boolean isThreeMeals() {
        return threeMeals;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }
    public static int getNumberBetweenDates(LocalDate checkIn, LocalDate checkOut){
        long numberOfDaysBetween = DAYS.between(checkIn, checkOut);
        return (int)numberOfDaysBetween;
    }
    public int getFullCost(LocalDate checkIn, LocalDate checkOut) {
        int numberOfNights = getNumberBetweenDates(checkIn,checkOut);
        if(breakfast) return numberOfNights*costWithBreakfast;
        return numberOfNights*costWithThreeMeals;


    }
    public String mealPlan(){
        if(this.breakfast) return "Breakfast";
        return "Three Meals";

    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String toString(LocalDate checkIn, LocalDate checkOut){
        return "Room " + number+
                "\nName: "+this.name+
                "\nNumber of beds: "+this.numberOfBeds+
                "\nMeal Plan: "+this.mealPlan()+
                "\nPrice for the stay from "+checkIn.toString()+" to "+checkOut.toString()+": "+this.getFullCost(checkIn,checkOut)+"AMD\n";
    }

    public void reserve(LocalDate checkIn, LocalDate checkOut,User user){
        reservations.add(new Reservation(this,checkIn,checkOut,user));
    }
    public boolean isAvailable(LocalDate checkIn, LocalDate checkOut){
        int x=0;
        if(reservations.size()==0) return true;
         else {
            for (int i = 0; i < reservations.size(); i++) {
                if ((checkIn.isAfter(reservations.get(i).getCheckOut()) && checkOut.isAfter(reservations.get(i).getCheckOut())) ||
                        (checkIn.isBefore(reservations.get(i).getCheckIn()) && checkOut.isBefore(reservations.get(i).getCheckIn()))){
                    x = 1;
                }

                 else x = -1;
            }
            if(x==1) return true;
            else return false;
        }

    }

}
