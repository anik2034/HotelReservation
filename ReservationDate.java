import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class ReservationDate {

    private LocalDate checkIn;
    private LocalDate checkOut;


     ReservationDate(LocalDate checkIn, LocalDate checkOut) {
         setCheckIn(checkIn);
         setCheckOut(checkOut);
    }
     ReservationDate(ReservationDate d){
        setCheckIn(d.checkIn);
        setCheckOut(d.checkOut);
     }

    public LocalDate getCheckIn() {
        return LocalDate.from(checkIn);
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = LocalDate.from(checkIn);
    }

    public LocalDate getCheckOut() {
        return LocalDate.from(checkOut);
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = LocalDate.from(checkOut);
    }

    public int getNumberBetweenDates(){
        long numberOfDaysBetween = DAYS.between(this.checkIn, this.checkOut);
        return (int)numberOfDaysBetween;
    }




}
