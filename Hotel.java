

public class Hotel implements Cloneable {
   private int numberOfStars;
   private String name;
   private String city;
   private  String address;
   private boolean hasParking;
   private boolean hasSwimmingPool;
   private boolean hasGYM;
   private Room[] typesOfRooms;






   public Hotel(int numberOfStars,
                String name,
                String city,
                String address,
                boolean hasParking,
                boolean hasSwimmingPool,
                boolean hasGYM,
                Room[] typesOfRooms) {
      this.numberOfStars = numberOfStars;
      this.name = name;
      this.city = city;
      this.address = address;
      this.hasParking = hasParking;
      this.hasSwimmingPool = hasSwimmingPool;
      this.hasGYM = hasGYM;
      this.setTypesOfRooms(typesOfRooms);

   }

   Hotel(Hotel h){   //copy constructor
      this.numberOfStars=h.numberOfStars;
      this.city=h.city;
      this.address = h.address;
      this.hasParking = h.hasParking;
      this.hasSwimmingPool = h.hasSwimmingPool;
      this.hasGYM = h.hasGYM;
      this.setTypesOfRooms(h.getTypesOfRooms());


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

   public Room[] getTypesOfRooms() {                                      // trying to do a deep copy Room[]
      Room[] typesOfApartmentsCopy= new Room[this.typesOfRooms.length];
      for(int i=0; i<this.typesOfRooms.length; i++){
         typesOfApartmentsCopy[i] = this.typesOfRooms[i].clone();
      }
      return typesOfApartmentsCopy;
   }

   public void setTypesOfRooms(Room[] typesOfRooms) {               // trying to do a deep copy Room[]
      this.typesOfRooms = new Room[typesOfRooms.length];
      for(int i=0; i<typesOfRooms.length; i++){
         this.typesOfRooms[i] = typesOfRooms[i].clone();
      }
   }

   public String booleanToString(boolean b){
      if(b==false) return "Does not have";
      return "has";
   }



   public String toString(){

      return  "Number of Stars: "+this.numberOfStars+
              "\nName: "+this.name+
              "\nCity: "+this.city+
              "\nAddress: "+this.address+
              "\n"+booleanToString(this.hasParking)+" Parking"+
              "\n"+booleanToString(this.hasSwimmingPool)+" Swimming Pool"+
              "\n"+booleanToString(this.hasGYM)+" GYM";


   }































}
