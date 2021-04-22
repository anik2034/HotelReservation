public class Room implements Cloneable {
    private String name;
    private int priceLateReservation;
    private int periodOfLateReservation;
    private int costWithBreakfast;
    private int costWithThreeMeals;
    private int numberOfBeds;
    private boolean includesBreakfast;
    private boolean includesThreeMeals;
    private int numberOfRoomsInHotel;
    private int numberOfBathrooms;


    public Room(
                     int priceLateReservation,
                     int periodOfLateReservation,
                     int costWithBreakfast,
                     int costWithThreeMeals,
                     String name,
                     int numberOfBeds,
                     boolean includesBreakfast,
                     boolean includesThreeMeals,
                     int numberOfRoomsInHotel,
                     int numberOfBathrooms){


        this.priceLateReservation = priceLateReservation;
        this.periodOfLateReservation=periodOfLateReservation;
        this.costWithBreakfast = costWithBreakfast;
        this.costWithThreeMeals = costWithThreeMeals;
        this.name = name;
        this.numberOfBeds = numberOfBeds;
        this.includesBreakfast = includesBreakfast;
        this.includesThreeMeals = includesThreeMeals;
        this.numberOfRoomsInHotel = numberOfRoomsInHotel;
        this.numberOfBathrooms=numberOfBathrooms;

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

    public boolean isIncludesThreeMeals() {
        return includesThreeMeals;
    }

    public void setIncludesThreeMeals(boolean includesThreeMeals) {
        this.includesThreeMeals = includesThreeMeals;
    }

    public int getNumberOfRoomsInHotel() {
        return numberOfRoomsInHotel;
    }

    public void setNumberOfRoomsInHotel(int numberOfApartmentsInHotel) {
        this.numberOfRoomsInHotel = numberOfApartmentsInHotel;
    }

    public int getNumberOfBathrooms() {
        return numberOfBathrooms;
    }

    public void setNumberOfBathrooms(int numberOfBathrooms) {
        this.numberOfBathrooms = numberOfBathrooms;
    }









    public int getCostPerNight() {

        if(this.isIncludesThreeMeals()) return this.getCostWithThreeMeals();
        return this.getCostWithBreakfast();

    }


    public int getFullCost(ReservationDate date) {
        int numberOfNights = date.getNumberBetweenDates();
        int costPerNight = this.getCostPerNight();
            if (numberOfNights <= this.getPeriodOfLateReservation()) {
                return (numberOfNights * costPerNight) + this.getPriceLateReservation();
            }
            return numberOfNights *costPerNight;
    }


    public Room clone() {
        Room copy = null;
        try {
            copy = (Room) super.clone();

        }
        catch (Exception e){
            System.out.println("Something went wrong in Room");
        }
        return copy;
    }
    public String mealPlan(){
        if(this.includesBreakfast)return "Breakfast";
        else if(this.includesThreeMeals) return "Three Meals";
        return "No Meal";
    }

    public String toString(ReservationDate date){
        return "Room " +
                "\nName: "+this.name+
                "\nNumber of beds: "+this.numberOfBeds+
                "\nNumber of bathrooms "+this.numberOfBathrooms+
                "\nMeal Plan: "+this.mealPlan()+
                "\nPrice for the stay "+this.getFullCost(date);
    }



}
