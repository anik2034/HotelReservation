

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public abstract class Residence {
    // abstract class
    // the base for apartment and house classes
    // needs getCost and reserve methods
    private int standardCost;
    private int priceLateReservation;
    private int periodOfLateReservation;
    private int costWithBreakfast;
    private int costWithDinner;
    private int costWithThreeMeals;
    private String name;
    private int numberOfBeds;
    private boolean includesBreakfast;
    private boolean includesDinner;
    private boolean includesThreeMeals;
    private int numberOfResidenceInHotel;
    private int numberOfBathrooms;


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
                     int numberOfResidenceInHotel,
                     int numberOfBathrooms){

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
        this.numberOfResidenceInHotel = numberOfResidenceInHotel;
        this.numberOfBathrooms=numberOfBathrooms;

    }
    Residence(Residence r){
        this.standardCost = r.standardCost;
        this.priceLateReservation = r.priceLateReservation;
        this.periodOfLateReservation= r.periodOfLateReservation;
        this.costWithBreakfast = r.costWithBreakfast;
        this.costWithDinner = r.costWithDinner;
        this.costWithThreeMeals = r.costWithThreeMeals;
        this.name = r.name;
        this.numberOfBeds = r.numberOfBeds;
        this.includesBreakfast = r.includesBreakfast;
        this.includesDinner = r.includesDinner;
        this.includesThreeMeals = r.includesThreeMeals;
        this.numberOfResidenceInHotel= r.numberOfResidenceInHotel;
        this.numberOfBathrooms=r.numberOfBathrooms;

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
    public int getPeriodOfLateReservation() { return periodOfLateReservation; }

    public void setPeriodOfLateReservation(int periodOfLateReservation) { this.periodOfLateReservation = periodOfLateReservation; }

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

    public int getNumberOfResidenceInHotel() {
        return numberOfResidenceInHotel;
    }

    public void setNumberOfResidenceInHotel(int numberOfApartmentsInHotel) {
        this.numberOfResidenceInHotel = numberOfApartmentsInHotel;
    }

    public int getNumberOfBathrooms() {
        return numberOfBathrooms;
    }

    public void setNumberOfBathrooms(int numberOfBathrooms) {
        this.numberOfBathrooms = numberOfBathrooms;
    }





    public abstract int getCostPerNight();
    public abstract int getFullCost(ReservationDate date);

}
