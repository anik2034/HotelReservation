

import java.time.LocalDate;

public class House extends Residence {

    House(
            int standardCost,
            int priceLateReservation,
            int periodOfLateReservation,
            int costWithBreakfast,
            int costWithDinner,
            int costWithThreeMeals,
            String name,
            int numberOfBeds,
            boolean includesBreakfast,
            boolean includesDinner,
            boolean includesThreeMeals,
            int numberOfHousesInHotelTotal,
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
                numberOfHousesInHotelTotal,
                numberOfBathrooms);
    }

    House(House h){
        super(h);
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



}


