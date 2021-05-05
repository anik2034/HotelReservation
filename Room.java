import java.time.LocalDate;
import java.util.ArrayList;

import static java.time.temporal.ChronoUnit.DAYS;

public class Room  {
    private String name;
    private boolean breakfast;
    private boolean threeMeals;
    private int numberOfBeds;                   //room properties
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

    public int getNumber() {
        return number;
    }


    public static int getNumberBetweenDates(LocalDate checkIn, LocalDate checkOut){
        long numberOfDaysBetween = DAYS.between(checkIn, checkOut);                 // static method that return the number between rwo dates
        return (int)numberOfDaysBetween;
    }
    public int getFullCost(LocalDate checkIn, LocalDate checkOut) {
        int numberOfNights = getNumberBetweenDates(checkIn,checkOut);               // return full cost for that room for that date
        if(breakfast) return numberOfNights*costWithBreakfast;
        return numberOfNights*costWithThreeMeals;


    }
    public String mealPlan(){
        if(this.breakfast) return "Breakfast";          // return the chosen meal plan as a string
        return "Three Meals";

    }



    public String toString(LocalDate checkIn, LocalDate checkOut){   //returns Room's description
        return "Room " + number+
                "\nName: "+this.name+
                "\nNumber of beds: "+this.numberOfBeds+
                "\nMeal Plan: "+this.mealPlan()+
                "\nPrice for the stay from "+checkIn.toString()+" to "+checkOut.toString()+": "+this.getFullCost(checkIn,checkOut)+"AMD\n";
    }

    public void reserve(LocalDate checkIn, LocalDate checkOut,User user){          //reserves the room for that date by adding new Reservation
        reservations.add(new Reservation(this,checkIn,checkOut,user));       // to the reservations list
    }

    public boolean isAvailable(LocalDate checkIn, LocalDate checkOut){   //check if the Room is available for that date
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
