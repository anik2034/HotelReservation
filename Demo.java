import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {
        Hotel h= buildHotel();
        h.getAllRooms()[21].reserve(LocalDate.of(2021,05,07),LocalDate.of(2021,05,21), new User("Ani","Tovmasyan","56789"));
        boolean choose =false;
        while(!choose){
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter your first name");
                String firstName = sc.nextLine();
                System.out.println("Enter your last name");
                String lastName = sc.nextLine();
                System.out.println("Enter your phone number");
                String phoneNumber = sc.nextLine();
                System.out.println("Enter the start date (yy-mm-dd)");
                LocalDate checkIn = LocalDate.parse(sc.nextLine());
                System.out.println("Enter the end date (yy-mm-dd)");
                LocalDate checkOut = LocalDate.parse(sc.nextLine());
                System.out.println("Choose the number of people (1,2,3,4)");
                int numberOfPeople = sc.nextInt();


                System.out.println("Should the room include breakfast (true/false)?");
                boolean breakfast = sc.nextBoolean();
                System.out.println("Should the room include Three Meal Plan (true/false)?");
                boolean threeMeals = sc.nextBoolean();


                System.out.println(h.search(checkIn, checkOut, breakfast, threeMeals, numberOfPeople));


                System.out.println("Choose the number above to reserve");
                int roomNumber = sc.nextInt();
                h.getAllRooms()[roomNumber].reserve(checkIn, checkOut, new User(firstName, lastName, phoneNumber));
                System.out.println("Successful Reservation");
                choose = true;
            }
            catch (Exception e){
                System.out.println("Wrong input, try again");
            }


        }








    }

    public static Hotel buildHotel(){
        Room[] rooms = new Room[41];
        for (int i = 1; i < 6; i++) {
            rooms[i]=new Room(35000, 40000, "Single", 1, true, false,i);
        }
        for (int i = 6; i < 11; i++) {
            rooms[i]=new Room(35000, 40000, "Single+", 1, false, true,i);
        }
        for (int i = 11; i < 16; i++) {
            rooms[i]=new Room(40000, 45000, "Double", 2, true, false,i);
        }
        for (int i = 16; i < 21; i++) {
            rooms[i]=new Room(40000, 45000, "Double+", 2, false, true,i);
        }
        for (int i = 21; i < 26; i++) {
            rooms[i]=new Room(60000, 65000, "Triple", 3, true, false,i);
        }
        for (int i = 26; i < 31; i++) {
            rooms[i]=new Room(60000, 65000, "Triple+", 3, false, true,i);
        }
        for (int i = 31; i < 36; i++) {
            rooms[i]=new Room(70000, 75000, "Family Size", 4, true, false,i);
        }
        for (int i = 36; i < 41; i++) {
            rooms[i]=new Room(70000, 75000, "Family Size+", 4, false, true,i);
        }


        Hotel h = new Hotel(5, "White Season Resort", "Amiryan 24", true, true, true, rooms);
        return h;
    }


}
