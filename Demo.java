import java.time.LocalDate;
import java.time.Period;

public class Demo {

    public static void main(String[] args) {
         // just trying
        Apartment a1 = new Apartment(10000,3000,20,15000,20000,35000,"Single",1,true,false,false,4,1);
        ReservationDate d1 = new ReservationDate(LocalDate.now(),LocalDate.of(2021,04,29));
        User u1= new User("Ani","Tovmasyan","099898989","lala.lala@gmail.com");
        Reservation r1= new Reservation(d1,u1,a1);








    }

}
