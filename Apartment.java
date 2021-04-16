

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
            int numberOfApartmentsInHotelTotal,
            int numberOfApartmentsAvailable,
            int numberOfBathrooms)
       //     Date date){
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
            numberOfApartmentsInHotelTotal,
            numberOfApartmentsAvailable,
            numberOfBathrooms);

    }



    @Override
    public int getCost() {

        if(this.includesBreakfast) return this.costWithBreakfast;
        else if(this.includesDinner) return this.costWithDinner;
        else if(this.includesThreeMeals) return this.costWithThreeMeals;
        else return this.standardCost;
    }

    @Override
    public int reserve(LocalDate checkIn, LocalDate checkOut) {
        if (this.numberOfResidenceAvailable<= 0) {
            System.out.println("No free rooms");}

            this.numberOfResidenceAvailable--;
            int numberOfNights = CalendarDisplay.getNumberBetweenDates(checkIn, checkOut);
            if (numberOfNights <= this.periodOfLateReservation) {
                return (numberOfNights * this.getCost()) + this.priceLateReservation;
            }
            return numberOfNights * this.getCost();




    }


}
