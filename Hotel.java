import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private int numberOfStars;
    private String name;
    private String address;
    private boolean hasParking;
    private boolean hasSwimmingPool;
    private boolean hasGYM;
    private Room[] allRooms;


    public Hotel() {
        this.numberOfStars = 5;
        this.name = "White Season Resort";

        this.address = "Amiryan 45";
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


    public void setAllRooms(Room[] allRooms) {
        this.allRooms = new Room[41];
        for (int i = 0; i < allRooms.length; i++) {
            this.allRooms[i] = allRooms[i];
        }
    }

//   public String search(LocalDate checkIn, LocalDate checkOut,boolean breakfast, boolean threeMeals, int numberOfPeople){
//      String s="";
//         for(int i=1; i<allRooms.length; i++){
//            if(allRooms[i].getNumberOfBeds()==numberOfPeople && (allRooms[i].isBreakfast()==breakfast || allRooms[i].isThreeMeals()==threeMeals) &&
//             allRooms[i].isAvailable(checkIn,checkOut)==true){
//                 s+=allRooms[i].toString(checkIn,checkOut);
//            }
//            else continue;
//         }
//         return s;
//   }

    public List<Room> search(LocalDate checkIn, LocalDate checkOut, boolean breakfast, boolean threeMeals, int numberOfPeople) {
        List<Room> roomList = new ArrayList<>();

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

    public String searchResultToString(List<Room> roomList, LocalDate checkIn, LocalDate checkOut) {
        String s = "";
        for (int i = 0; i < roomList.size(); i++) {
            s += roomList.get(i).toString(checkIn, checkOut);
        }

        return s;
    }
}
