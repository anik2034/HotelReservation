public class User {

    private String firstName;
    private String lastName;                               //user properties
    private String phoneNumber;


    User(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;                        //constructor
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }


    public String getFirstName() {
        return firstName;
    }



    public String getLastName() {
        return lastName;
    }



    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return firstName+" "+lastName;
    }
}
