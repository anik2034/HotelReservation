public class User {

    //info about user
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

    User(String firstName, String lastName, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    User(User u){
        this.firstName=u.firstName;
        this.lastName=u.lastName;
        this.phoneNumber=u.phoneNumber;
        this.email=u.email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


//    public Hotel[] search(ReservationDate){
//
//    }







}
