import java.time.LocalDate;
import java.util.ArrayList;


public class Hotel {

    // our hotel properties
    private int numberOfStars;
    private String name;
    private String address;
    private boolean hasSwimmingPool;
    private boolean hasGYM;
    private static  Residence[] allResidences;


    // constructor that, directly builds our hotel
    public Hotel() {
        this.numberOfStars = 5;
        this.name = "White Season Resort";
        this.hasGYM=true;
        this.hasSwimmingPool=true;


        this.address = "Amiryan 45, Yerevan";
       allResidences = new Residence[61];
        for (int i = 1; i < 6; i++) {
            allResidences[i] = new Room(35000, 40000, "Single", 1, i,"Breakfast");
        }
        for (int i = 6; i < 11; i++) {
            allResidences[i] = new Room(35000, 40000, "Single", 1, i,"Three Meal Plan");
        }
        for (int i = 11; i < 16; i++) {
            allResidences[i] = new Room(40000, 45000, "Double", 2, i,"Breakfast");
        }
        for (int i = 16; i < 21; i++) {
            allResidences[i] = new Room(40000, 45000, "Double+", 2,  i,"Three Meal Plan");
        }
        for (int i = 21; i < 26; i++) {
            allResidences[i] = new Room(60000, 65000, "Triple", 3,i,"Breakfast");
        }
        for (int i = 26; i < 31; i++) {
            allResidences[i] = new Room(60000, 65000, "Triple+", 3,  i,"Three Meal Plan");
        }
        for (int i = 31; i < 36; i++) {
            allResidences[i] = new Room(70000, 75000, "Family Size", 4,  i,"Breakfast");
        }
        for (int i = 36; i < 41; i++) {
            allResidences[i] = new Room(70000, 75000, "Family Size+", 4,  i,"Three Meal Plan");
        }
        for (int i = 41; i < 46; i++) {
            allResidences[i] = new House(80000, 90000, "Holiday", 5,  i,"Breakfast",3,2);
        }
        for (int i = 46; i < 51; i++) {
            allResidences[i] = new House(80000, 90000, "Holiday+", 5,  i,"Three Meal Plan",3,2);
        }
        for (int i = 51; i < 56; i++) {
            allResidences[i] = new House(90000, 100000, "Max Size", 6,  i,"Breakfast",4,3);
        }
        for (int i = 56; i < 61; i++) {
            allResidences[i] = new House(90000, 100000, "Max Size+", 6,  i,"Three Meal Plan",4,3);
        }



    }

    public Residence[] getAllResidences() {
        Residence[] copy = new Residence[allResidences.length];
        for(int i=0; i<allResidences.length; i++){
            copy[i]=allResidences[i];
        }
        return allResidences;
    }





    // search method  goes through  all residences
    // and return ArrayList of Residence that are available on that date and have certain filters
    public ArrayList<Residence> search(LocalDate checkIn,
                             LocalDate checkOut,
                             String meal,
                             int numberOfPeople) {
        ArrayList<Residence> residencesList = new ArrayList<>();

        for (int i = 1; i < allResidences.length; i++) {
            if (allResidences[i].getNumberOfBeds() == numberOfPeople &&
                    allResidences[i].getMeal().equals(meal) &&
                    allResidences[i].isAvailable(checkIn, checkOut)) {

                residencesList.add(allResidences[i]);
            }
        }
        return residencesList;
    }

   //prints the ArrayList
    public String searchResultToString(ArrayList<Residence> roomList, LocalDate checkIn, LocalDate checkOut) { //prints the ArrayList
        String s = "";
        if(roomList.size()>0) {
            for (int i = 0; i < roomList.size(); i++) {
                s += roomList.get(i).toString(checkIn, checkOut);
            }

            return s;
        }
        return "NO FREE Residence";
    }

    //using the booleans instance variables return appropriate string
    public String findMealOption(){
        if(this.hasSwimmingPool && this.hasGYM) return "has the best GYM and Swimming Pool in the city";  //according to the boolean return right string
        if(this.hasSwimmingPool) return "has the best Swimming Pool in the city";
        if(this.hasGYM)  return "has the best GYM in the city";
        return "";
    }

    //return Hotel description
    public String toString(){
       return  this.name+" is a "+this.numberOfStars+" hotel located on "+this.address+".\nThe resort "+findMealOption()+
               ".\nAt the "+this.name+
                ",\n you will be hosted in bright and spacious guest rooms. " +
                "\nLet our chef's exceptional Armenian and exotic cuisine " +
                "\nsurprise you with their unique design and taste.";
    }
}
