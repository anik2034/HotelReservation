import java.time.LocalDate;




public class Reservation {
    private Room room;
    private LocalDate checkIn;          //reservation properties
    private LocalDate checkOut;
    private User user;

    public Room getRoom() {
        return room;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }



    Reservation(Residence residence, LocalDate checkIn,LocalDate checkOut,User user){  //constructor
        this.room=room;
        this.checkIn=checkIn;
        this.checkOut=checkOut;
        this.user=user;
    }
    public  String toString(){
        return room.toString(checkIn,checkOut)+
                "by "+user.toString();
    }






}
