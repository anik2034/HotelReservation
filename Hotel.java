import java.time.LocalDate;
import java.util.ArrayList;

public class Hotel {


   private int numberOfStars;
   private String name;
   private  String address;
   private boolean hasParking;
   private boolean hasSwimmingPool;
   private boolean hasGYM;
   private Room[] allRooms;






   public Hotel(int numberOfStars,
                String name,
                String address,
                boolean hasParking,
                boolean hasSwimmingPool,
                boolean hasGYM,
               Room[]allRooms) {
      this.numberOfStars = numberOfStars;
      this.name = name;

      this.address = address;
      this.hasParking = hasParking;
      this.hasSwimmingPool = hasSwimmingPool;
      this.hasGYM = hasGYM;
      this.setAllRooms(allRooms);



   }
   public Room[] getAllRooms(){

      return allRooms;
   }


   public void setAllRooms(Room[] allRooms) {
     this.allRooms= new Room[41];
      for(int i=0; i<allRooms.length; i++){
         this.allRooms[i]=allRooms[i];
      }
   }

   public String search(LocalDate checkIn, LocalDate checkOut,boolean breakfast, boolean threeMeals, int numberOfPeople){
      String s="";
         for(int i=1; i<allRooms.length; i++){
            if(allRooms[i].getNumberOfBeds()==numberOfPeople && (allRooms[i].isBreakfast()==breakfast || allRooms[i].isThreeMeals()==threeMeals) &&
             allRooms[i].isAvailable(checkIn,checkOut)==true){
                 s+=allRooms[i].toString(checkIn,checkOut);
            }
            else continue;
         }
         return s;
   }































}
