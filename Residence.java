

import java.time.LocalDate;

public abstract class Residence {
    // abstract class
    // the base for apartment and house classes
    // needs getCost and reserve methods
    protected int standardCost;
    protected int priceLateReservation;
    protected int periodOfLateReservation;
    protected int costWithBreakfast;
    protected int costWithDinner;
    protected int costWithThreeMeals;
    protected String name;
    protected int numberOfBeds;
    protected boolean includesBreakfast;
    protected boolean includesDinner;
    protected boolean includesThreeMeals;
    protected int numberOfResidenceInHotelTotal;
    protected int numberOfResidenceAvailable;
    protected int numberOfBathrooms;


    public Residence(int standardCost,
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
                     int numberOfApartmentsInHotel,
                     int numberOfResidenceAvailable,
                     int numberOfBathrooms){
                  //   CalendarDate date) {
        this.standardCost = standardCost;
        this.priceLateReservation = priceLateReservation;
        this.periodOfLateReservation=periodOfLateReservation;
        this.costWithBreakfast = costWithBreakfast;
        this.costWithDinner = costWithDinner;
        this.costWithThreeMeals = costWithThreeMeals;
        this.name = name;
        this.numberOfBeds = numberOfBeds;
        this.includesBreakfast = includesBreakfast;
        this.includesDinner = includesDinner;
        this.includesThreeMeals = includesThreeMeals;
        this.numberOfResidenceInHotelTotal = numberOfApartmentsInHotel;
        this.numberOfResidenceAvailable=numberOfResidenceAvailable;
        this.numberOfBathrooms=numberOfBathrooms;
        //this.date= new CalendarDate(date);
    }

    public int getStandardCost() {
        return standardCost;
    }

    public void setStandardCost(int standardCost) {
        this.standardCost = standardCost;
    }

    public int getPriceLateReservation() {
        return priceLateReservation;
    }

    public void setPriceLateReservation(int priceLateReservation) {
        this.priceLateReservation = priceLateReservation;
    }

    public int getCostWithBreakfast() {
        return costWithBreakfast;
    }

    public void setCostWithBreakfast(int costWithBreakfast) {
        this.costWithBreakfast = costWithBreakfast;
    }

    public int getCostWithDinner() {
        return costWithDinner;
    }

    public void setCostWithDinner(int costWithDinner) {
        this.costWithDinner = costWithDinner;
    }

    public int getCostWithThreeMeals() {
        return costWithThreeMeals;
    }

    public void setCostWithThreeMeals(int costWithThreeMeals) {
        this.costWithThreeMeals = costWithThreeMeals;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public boolean isIncludesBreakfast() {
        return includesBreakfast;
    }

    public void setIncludesBreakfast(boolean includesBreakfast) {
        this.includesBreakfast = includesBreakfast;
    }

    public boolean isIncludesDinner() {
        return includesDinner;
    }

    public void setIncludesDinner(boolean includesDinner) {
        this.includesDinner = includesDinner;
    }

    public boolean isIncludesThreeMeals() {
        return includesThreeMeals;
    }

    public void setIncludesThreeMeals(boolean includesThreeMeals) {
        this.includesThreeMeals = includesThreeMeals;
    }

    public int getNumberOfApartmentsInHotel() {
        return numberOfResidenceInHotelTotal;
    }

    public void setNumberOfApartmentsInHotel(int numberOfApartmentsInHotel) {
        this.numberOfResidenceInHotelTotal = numberOfApartmentsInHotel;
    }
    public int getNumberOfResidenceAvailable() {
        if(this.numberOfResidenceAvailable<=0) return 0;
        else return this.numberOfResidenceAvailable;
    }

    public void setNumberOfResidenceAvailable(int numberOfResidenceAvailable) {
        this.numberOfResidenceAvailable = numberOfResidenceAvailable;
    }


    public int getNumberOfBathrooms() {
        return numberOfBathrooms;
    }

    public void setNumberOfBathrooms(int numberOfBathrooms) {
        this.numberOfBathrooms = numberOfBathrooms;
    }





    public abstract int getCost();
    public abstract int reserve (LocalDate checkIn, LocalDate checkOut);
}
