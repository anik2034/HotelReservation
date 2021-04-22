public class Reservation {
    // still not ready, idk how to do reservations and count the free rooms on the date.
    private User user;
    private ReservationDate date;
    private Room room;

    public Reservation(User user, ReservationDate date, Room room) {
        this.user = new User(user);
        this.date = new ReservationDate(date);
        this.room = room.clone();

    }





}
