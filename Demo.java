import java.time.LocalDate;

public class Demo {

    public static void main(String[] args) {
         // just trying
        Hotel[] h= HotelLibrary.getAllHotels();
        Room[] r= h[0].getTypesOfRooms();
        System.out.println(h[0].toString());
        System.out.println(r[0].toString(new ReservationDate(LocalDate.now(), LocalDate.of(2021,04,29))));








    }

}
