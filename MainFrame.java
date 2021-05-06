import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class MainFrame implements ActionListener {
    private JButton search = new JButton();
    private JTextField inDate = new JTextField();
    private JTextField outDate = new JTextField();
    private JTextField firstName = new JTextField();
    private JTextField lastName = new JTextField();
    private JTextField phone = new JTextField();
    private JTextArea hotelInfo = new JTextArea();
    private JComboBox numberOfPeople;
    private JComboBox mealPlan;
    private JButton reserve = new JButton();
    private JTextArea residencesInfo;
    private JTextField number = new JTextField();
    private JButton newRes = new JButton();
    private Hotel h = new Hotel();

    MainFrame() {
        // creating frame
        JFrame f = new JFrame();

        //Hotel name label
        JLabel name = new JLabel();
        name.setText("Welcome to White Season Resort");
        name.setForeground(Color.black);
        name.setFont(new Font("Serif", Font.BOLD, 20));
        name.setBounds(300,0,300,20);


        //Hotel description Text
        hotelInfo.setText(h.toString());
        hotelInfo.setBounds(40,30,400,110);
        hotelInfo.setEditable(false);
        hotelInfo.setFont(new Font("Serif", Font.BOLD, 13));

        //new button
        newRes.setBounds(690, 30, 140, 20);
        newRes.setText("New Reservation");
        newRes.addActionListener(this);



        //search button
        search.setText("Search");
        search.addActionListener(this);
        search.setBounds(374, 610, 75, 20);

        //reserve button
        reserve.addActionListener(this);
        reserve.setBounds(740, 670, 90, 20);
        reserve.setText("Reserve");

        //asks to input start date
        JLabel inInfo = new JLabel();
        inInfo.setText("Enter the start date (yy-mm-dd)");
        inInfo.setForeground(Color.white);
        inInfo.setBounds(50, 150, 200, 20);
        // start date input place
        inDate.setBounds(250, 150, 100, 20);


        //asks to input the end date
        JLabel outInfo = new JLabel();
        outInfo.setText("Enter the end date (yy-mm-dd)");
        outInfo.setForeground(Color.white);
        outInfo.setBounds(50, 200, 200, 20);
        // end date input place
        outDate.setBounds(250, 200, 100, 20);


        //asks to choose number of people
        JLabel peopleInfo = new JLabel();
        peopleInfo.setText("Choose the number of people");
        peopleInfo.setForeground(Color.white);
        peopleInfo.setBounds(50, 250, 200, 20);


        Integer[] nums = {1, 2, 3, 4,5,6};
        //combo box that has variants of number 1-6
        numberOfPeople = new JComboBox(nums);
        numberOfPeople.setBounds(250, 250, 40, 30);

        //asks to choose meal plan
        JLabel mealInfo = new JLabel();
        mealInfo.setText("Room should be with");
        mealInfo.setForeground(Color.white);
        mealInfo.setBounds(50, 300, 200, 20);

        String[] meals = {"Breakfast", "Three Meal Plan"};
        //combo box that has variants of meal plan breakfast and three meal
        mealPlan = new JComboBox(meals);
        mealPlan.setBounds(250, 300, 100, 30);


        // personal info label
        JLabel userLabel = new JLabel();
        userLabel.setText("Fill the personal information");
        userLabel.setForeground(Color.white);
        userLabel.setFont(new Font("Serif", Font.BOLD, 18));
        userLabel.setBounds(50, 350, 270, 20);


        //asks to input first name
        JLabel firstNameInfo = new JLabel();
        firstNameInfo.setText("Enter your first name");
        firstNameInfo.setForeground(Color.white);
        firstNameInfo.setBounds(50, 400, 200, 20);
        //place to input the first name
        firstName.setBounds(250, 400, 200, 20);


        //asks to input last name
        JLabel lastNameInfo = new JLabel();
        lastNameInfo.setText("Enter your last name");
        lastNameInfo.setForeground(Color.white);
        lastNameInfo.setBounds(50, 450, 200, 20);
        //place to input the last name
        lastName.setBounds(250, 450, 200, 20);


        //asks to input phone number
        JLabel phoneInfo = new JLabel();
        phoneInfo.setText("Enter your phone number");
        phoneInfo.setBounds(50, 500, 200, 20);
        phoneInfo.setForeground(Color.white);
        //place to input the phone number
        phone.setBounds(250, 500, 200, 20);

        //textArea for available Residence info after search
        residencesInfo = new JTextArea();
        residencesInfo.setBounds(460, 60, 370, 570);
        residencesInfo.setEditable(false);


        //asks to input the room number according to the room above
        JLabel roomNumberInfo = new JLabel();
        roomNumberInfo.setText("Enter the Room Number from above");
        roomNumberInfo.setForeground(Color.white);
        roomNumberInfo.setBounds(530, 640, 300, 20);
        // place to input the room number
        number.setBounds(810, 640, 20, 20);


        //adding photo to background
        f.setContentPane(new JLabel(new ImageIcon("hotelphoto.jpg")));


        //adding all components
        f.add(hotelInfo);
        f.add(peopleInfo);
        f.add(newRes);
        f.add(reserve);
        f.add(number);
        f.add(numberOfPeople);
        f.add(residencesInfo);
        f.add(phone);
        f.add(phoneInfo);
        f.add(lastName);
        f.add(lastNameInfo);
        f.add(firstName);
        f.add(firstNameInfo);
        f.add(userLabel);
        f.add(mealPlan);
        f.add(mealInfo);
        f.add(roomNumberInfo);
        f.add(numberOfPeople);
        f.add(outDate);
        f.add(outInfo);
        f.add(inInfo);
        f.add(inDate);
        f.add(search);
        f.add(name);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(900, 800);
        f.setTitle("White Season Resort");


        f.setVisible(true);
    }

    //according to the choice return string with the same name
    public String x(JComboBox s) {
        if (s.getSelectedIndex() == 0) return "Breakfast";
        else return "Three Meal Plan";

    }

    @Override
    public void actionPerformed(ActionEvent e) {


        try {

            LocalDate sd = LocalDate.parse(inDate.getText());
            LocalDate ed = LocalDate.parse(outDate.getText());

            //checking if the order of start date and end date is not right, throws DateMissMatchException
            if (sd.isBefore(LocalDate.now()) || sd.isAfter(ed) &&(!inDate.getText().isEmpty() ||!outDate.getText().isEmpty())) {
                throw new DateMissMatchException();
            }

            //checking if the period is > than 30 nights or <1, throws DateOutOfPeriodException
            if (Room.getNumberBetweenDates(sd, ed) > 30 || Room.getNumberBetweenDates(sd, ed) <1 ) {
                throw new DateOutOfPeriodException();
            }

            // checking if the personal info fields are empty,throws EmptyInfoException
            if (firstName.getText().isEmpty() ||
                    lastName.getText().isEmpty() ||
                    phone.getText().isEmpty()) {
                throw new EmptyInfoException();

            }
            if (e.getSource() == search) {

                //setting the tex of the Residence info from the method searchResultToString
                // that uses ArrayList from search method
                residencesInfo.setText((h.searchResultToString
                                (h.search(sd,
                                        ed,
                                        x(mealPlan),
                                        numberOfPeople.getSelectedIndex() + 1),
                                        sd,
                                        ed)));




            }
            if (e.getSource() == reserve) {
                //saves filtered arraylist of room from search to a new Arraylist
                ArrayList<Residence> availableRooms = h.search(
                        sd,
                        ed,
                        x(mealPlan),
                        numberOfPeople.getSelectedIndex() + 1);
                boolean isSame = false;
                if (availableRooms.size() > 0) {
                    for (int i = 0; i < availableRooms.size(); i++) {
                        //checks if number of available Residence is same with the inputted number, reserves the Residence
                        //and shows message of successful reservation
                        if (availableRooms.get(i).getNumber() == parseInt(number.getText())) {
                            availableRooms.get(i).reserve(sd,
                                    ed,
                                    new User(firstName.getText(), lastName.getText(), phone.getText()));
                            JOptionPane.showConfirmDialog(null,
                                    "Successful Reservation",
                                    "Reservation", JOptionPane.PLAIN_MESSAGE);
                            isSame = false;
                            break;
                        } else {
                            isSame = true;

                        }
                    }
                    //if the input is wrong then shows the wrong input message.
                    if (isSame) {
                        JOptionPane.showConfirmDialog(null,
                                "Wrong Number ",
                                "Error", JOptionPane.PLAIN_MESSAGE);
                    }
                }

            }
            //clears the textField for the new reservation
            if (e.getSource() == newRes) {

                inDate.setText("");
                outDate.setText("");
                firstName.setText("");
                lastName.setText("");
                phone.setText("");
                residencesInfo.setText("");
                number.setText("");

            }


        }
        catch (EmptyInfoException ex){
            JOptionPane.showConfirmDialog(null,
                    "Please fill the personal information ",
                    "Personal Info Error", JOptionPane.PLAIN_MESSAGE);
        }
        catch (DateOutOfPeriodException ex){
            JOptionPane.showConfirmDialog(null,
                    "Cannot make a reservation for more than 30 nights or less than 1 night ",
                    "Date Error", JOptionPane.PLAIN_MESSAGE);
        }
        catch (DateMissMatchException ex){
            JOptionPane.showConfirmDialog(null,
                    "Wrong date input",
                    "Date Error", JOptionPane.PLAIN_MESSAGE);
        }
        catch (Exception ex){
            JOptionPane.showConfirmDialog(null,
                    "Wrong date input ",
                    "Date Error", JOptionPane.PLAIN_MESSAGE);
        }






    }
}
