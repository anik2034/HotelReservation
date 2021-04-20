

import java.time.LocalDate;

public class Apartment extends  Residence{


    Apartment(
            int standardCost,
            int priceLateReservation, //additional
            int periodOfLateReservation,
            int costWithBreakfast,
            int costWithDinner,
            int costWithThreeMeals,
            String name,
            int numberOfBeds,
            boolean includesBreakfast,
            boolean includesDinner,
            boolean includesThreeMeals,
            int numberOfApartmentsInHotel,
            int numberOfBathrooms)

    {
        super( standardCost,
            priceLateReservation,
                periodOfLateReservation,
            costWithBreakfast,
            costWithDinner,
            costWithThreeMeals,
            name,
            numberOfBeds,
            includesBreakfast,
            includesDinner,
            includesThreeMeals,
            numberOfApartmentsInHotel,
            numberOfBathrooms);

    }
    Apartment(Apartment a){
        super(a);
    }



    @Override
    public int getCostPerNight() {
        if(this.isIncludesBreakfast()) return this.getCostWithBreakfast();
        else if(this.isIncludesDinner()) return this.getCostWithDinner();
        else if(this.isIncludesThreeMeals()) return this.getCostWithThreeMeals();
        else return this.getStandardCost();
    }

    @Override
    public int getFullCost(ReservationDate date) {
        int numberOfNights = date.getNumberBetweenDates();
        int costPerNight = this.getCostPerNight();
            if (numberOfNights <= this.getPeriodOfLateReservation()) {
                return (numberOfNights * costPerNight) + this.getPriceLateReservation();
            }
            return numberOfNights *costPerNight;
    }


    //  @Override
//    public int reserve(LocalDate checkIn, LocalDate checkOut) {
//        if (this.numberOfResidenceAvailable<= 0) {
//            System.out.println("No free rooms");}
//
//            this.numberOfResidenceAvailable--;
//            int numberOfNights = getNumberBetweenDates(checkIn, checkOut);
//            if (numberOfNights <= this.periodOfLateReservation) {
//                return (numberOfNights * this.getCost()) + this.priceLateReservation;
//            }
//            return numberOfNights * this.getCost();
//
//
//
//
//    }


}
