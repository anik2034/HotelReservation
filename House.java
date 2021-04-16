

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
            int numberOfResidenceAvailable,
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
          numberOfResidenceAvailable,
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
    public int reserve (LocalDate checkIn, LocalDate checkOut) {  //does not work properly

        this.numberOfResidenceAvailable--;
        int numberOfNights = getNumberBetweenDates(checkIn,checkOut);
        if(numberOfNights<=this.periodOfLateReservation){
            return (numberOfNights*this.getCost())+this.priceLateReservation;
        }
        return numberOfNights*this.getCost();
    }


}


