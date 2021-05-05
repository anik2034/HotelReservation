import java.time.LocalDate;


public class Reservation {
    private Room room;

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    private LocalDate checkIn;
    private LocalDate checkOut;
    private User user;

    Reservation(Room room, LocalDate checkIn,LocalDate checkOut,User user){
        this.room=room;
        this.checkIn=checkIn;
        this.checkOut=checkOut;
        this.user=user;
    }


    public String toString(){
        return room.toString(checkIn,checkOut);
    }
}
