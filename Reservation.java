import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class Reservation {

    private ReservationDate date;
    private User user;
    private Apartment apartment;




    public Reservation(ReservationDate date, User user,Apartment apartment) {
        setDate(date);
        setUser(user);
        setApartment(apartment);

    }

    public ReservationDate getDate() {
        return new ReservationDate(date);
    }

    public void setDate(ReservationDate date) {
        this.date = new ReservationDate(date);
    }

    public User getUser() {
        return new User(user);
    }

    public void setUser(User user) {
        this.user = new User(user);
    }

    public Apartment getApartment() {
        return new Apartment(apartment);
    }

    public void setApartment(Apartment apartment) {
        this.apartment = new Apartment(apartment);
    }



  // does not work properly
//    public int reserveApartment(){
//        int numberOfAvailableApartments=apartment.getNumberOfResidenceInHotel();
//        numberOfAvailableApartments--;
//
//        if(numberOfAvailableApartments<=0) return 0;
//        return  numberOfAvailableApartments;
//
//
//    }










    }










