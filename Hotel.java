import java.time.LocalDate;
import java.util.ArrayList;


public class Hotel {
    private int numberOfStars;
    private String name;
    private String address;                        // our hotel properties
    private boolean hasSwimmingPool;
    private boolean hasGYM;
    private Room[] allRooms;


    public Hotel() {
        this.numberOfStars = 5;
        this.name = "White Season Resort";
        this.hasGYM=true;                                               // constructor that, directly builds our hotel
        this.hasSwimmingPool=true;


        this.address = "Amiryan 45, Yerevan";
        Room[] rooms = new Room[41];
        for (int i = 1; i < 6; i++) {
            rooms[i] = new Room(35000, 40000, "Single", 1, true, false, i);
        }
        for (int i = 6; i < 11; i++) {
            rooms[i] = new Room(35000, 40000, "Single+", 1, false, true, i);
        }
        for (int i = 11; i < 16; i++) {
            rooms[i] = new Room(40000, 45000, "Double", 2, true, false, i);
        }
        for (int i = 16; i < 21; i++) {
            rooms[i] = new Room(40000, 45000, "Double+", 2, false, true, i);
        }
        for (int i = 21; i < 26; i++) {
            rooms[i] = new Room(60000, 65000, "Triple", 3, true, false, i);
        }
        for (int i = 26; i < 31; i++) {
            rooms[i] = new Room(60000, 65000, "Triple+", 3, false, true, i);
        }
        for (int i = 31; i < 36; i++) {
            rooms[i] = new Room(70000, 75000, "Family Size", 4, true, false, i);
        }
        for (int i = 36; i < 41; i++) {
            rooms[i] = new Room(70000, 75000, "Family Size+", 4, false, true, i);
        }
        this.setAllRooms(rooms);


    }

    public Room[] getAllRooms() {
        return allRooms;
    }


    private void setAllRooms(Room[] allRooms) {
        this.allRooms = new Room[41];
        for (int i = 0; i < allRooms.length; i++) {
            this.allRooms[i] = allRooms[i];
        }
    }



    public ArrayList<Room> search(LocalDate checkIn,           // search method that goes through  all rooms find the rooms
                             LocalDate checkOut,               // that are available on that date and have certain filters and return them in ArrayList
                             boolean breakfast,
                             boolean threeMeals,
                             int numberOfPeople) {
        ArrayList<Room> roomList = new ArrayList<>();

        for (int i = 1; i < allRooms.length; i++) {
            if (allRooms[i].getNumberOfBeds() == numberOfPeople &&
                    (allRooms[i].isBreakfast() == breakfast ||
                            allRooms[i].isThreeMeals() == threeMeals) &&
                    allRooms[i].isAvailable(checkIn, checkOut)) {

                roomList.add(allRooms[i]);
            }
        }
        return roomList;
    }

    public String searchResultToString(ArrayList<Room> roomList, LocalDate checkIn, LocalDate checkOut) { //prints the ArrayList
        String s = "";
        for (int i = 0; i < roomList.size(); i++) {
            s += roomList.get(i).toString(checkIn, checkOut);
        }

        return s;
    }
    public String booleanToString(){
        if(this.hasSwimmingPool && this.hasGYM) return "has the best GYM and Swimming Pool in the city";  //according to the boolean return right string
        if(this.hasSwimmingPool) return "has the best Swimming Pool in the city";
        if(this.hasGYM)  return "has the best GYM in the city";
        return "";
    }

    public String toString(){             //return Hotel description
       return  this.name+" is a "+this.numberOfStars+" hotel located on "+this.address+".\nThe resort "+booleanToString()+". At the "+this.name+
                ",\n you will be hosted in bright and spacious guest rooms. " +
                "\nLet our chef's exceptional Armenian and exotic cuisine " +
                "surprise you with their unique design and taste.";
    }
}
