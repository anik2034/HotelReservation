import java.time.LocalDate;

public class House extends Residence{

    //additional House properties
    private int numberOfBedrooms;
    private int numberOfBathrooms;

    House(int costWithBreakfast,
          int costWithThreeMeals,
          String name,
          int numberOfBeds,
          int number,
          String meal,
          int numberOfBedrooms,
          int numberOfBathrooms){
        super(costWithBreakfast,costWithThreeMeals,name,numberOfBeds,number,meal);
        this.numberOfBathrooms=numberOfBathrooms;
        this.numberOfBedrooms=numberOfBedrooms;
    }

    public String toString(LocalDate checkIn, LocalDate checkOut){   //returns Room's description
        return "House " + getNumber()+
                " \nName: "+this.getName()+
                " \nNumber of beds: "+this.getNumberOfBeds()+
                " \nMeal Plan: "+this.getMeal()+
                "\nNumber bedrooms: "+this.numberOfBedrooms+
                "\nNumber of bathrooms: "+this.numberOfBathrooms+
                " \nPrice for the stay from "+checkIn.toString()+" to "+checkOut.toString()+": "+this.getFullCost(checkIn,checkOut)+"AMD\n";
    }
}
