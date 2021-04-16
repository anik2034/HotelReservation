

public class Hotel implements Cloneable {
   private int numberOfStars;
   private String name;
   private String city;
   private  String address;
   private boolean hasParking;
   private boolean hasSwimmingPool;
   private boolean hasGYM;
   private Apartment[] typesOfApartments;
   private House[] typesOfHouses;





   public Hotel(int numberOfStars,
                String name,
                String city,
                String address,
                boolean hasParking,
                boolean hasSwimmingPool,
                boolean hasGYM,
                boolean hasApartment,
                Apartment[] typesOfApartments,
                House[] typesOfHouses) {
      this.numberOfStars = numberOfStars;
      this.name = name;
      this.city = city;
      this.address = address;
      this.hasParking = hasParking;
      this.hasSwimmingPool = hasSwimmingPool;
      this.hasGYM = hasGYM;
      this.typesOfApartments = typesOfApartments.clone();
      this.typesOfHouses=typesOfHouses.clone();
   }

   Hotel(Hotel h){   //copy constructor
      this.numberOfStars=h.numberOfStars;
      this.city=h.city;
      this.address = h.address;
      this.hasParking = h.hasParking;
      this.hasSwimmingPool = h.hasSwimmingPool;
      this.hasGYM = h.hasGYM;
      this.typesOfApartments = getTypesOfApartments();
      this.typesOfHouses=getTypesOfHouses();

   }

   public int getNumberOfStars() {
      return numberOfStars;
   }

   public void setNumberOfStars(int numberOfStars) {
      this.numberOfStars = numberOfStars;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getCity() {
      return city;
   }

   public void setCity(String city) {
      this.city = city;
   }

   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }

   public boolean isHasParking() {
      return hasParking;
   }

   public void setHasParking(boolean hasParking) {
      this.hasParking = hasParking;
   }

   public boolean isHasSwimmingPool() {
      return hasSwimmingPool;
   }

   public void setHasSwimmingPool(boolean hasSwimmingPool) {
      this.hasSwimmingPool = hasSwimmingPool;
   }

   public boolean isHasGYM() {
      return hasGYM;
   }

   public void setHasGYM(boolean hasGYM) {
      this.hasGYM = hasGYM;
   }

   public Apartment[] getTypesOfApartments() {
      return typesOfApartments;
   }

   public void setTypesOfApartments(Apartment[] typesOfApartments) {
      this.typesOfApartments = typesOfApartments;
   }

   public House[] getTypesOfHouses() {     // trying to do a deep copy
      House[] typesOfHousesCopy = new House[this.typesOfHouses.length];
      for(int i=0; i<this.typesOfHouses.length; i++){
         typesOfHousesCopy[i]= this.typesOfHouses[i];
      }
      return typesOfHouses;

   }

   public void setTypesOfHouses(House[] typesOfHouses) {  // trying to do a deep copy
      House[] typesOfHousesCopy = new House[typesOfHouses.length];
      for(int i=0; i<typesOfHouses.length; i++){
         typesOfHousesCopy[i]= typesOfHouses[i];
      }
   }































}
