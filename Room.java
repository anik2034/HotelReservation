
import java.time.LocalDate;




public class Room  extends Residence{


    Room( int costWithBreakfast,
          int costWithThreeMeals,
          String name,
          int numberOfBeds,
          int number,
          String meal){
    super(costWithBreakfast,costWithThreeMeals,name,numberOfBeds,number,meal);
    }




    public String toString(LocalDate checkIn, LocalDate checkOut){   //returns Room's description
        return "Room " + getNumber()+
                " \nName: "+this.getName()+
                " \nNumber of beds: "+this.getNumberOfBeds()+
                " \nMeal Plan: "+this.getMeal()+
                " \nPrice for the stay from "+checkIn.toString()+" to "+checkOut.toString()+": "+this.getFullCost(checkIn,checkOut)+"AMD\n";
    }










}
