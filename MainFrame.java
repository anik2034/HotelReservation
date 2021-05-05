import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class MainFrame implements ActionListener {
    JButton search = new JButton();
    JTextField inDate = new JTextField();
    JTextField outDate = new JTextField();
    JTextField firstName = new JTextField();
    JTextField lastName = new JTextField();
    JTextField phone = new JTextField();
    JTextArea hotelInfo = new JTextArea();
    JComboBox numberOfPeople;
    JComboBox mealPlan;
    JButton reserve = new JButton();
    JTextArea roomsInfo;
    JTextField number = new JTextField();
    JButton clear = new JButton();
    Hotel h = new Hotel();

    MainFrame() {
        JFrame f = new JFrame();     // creating frame



        hotelInfo.setText(h.toString());
        hotelInfo.setBounds(40,40,600,75);         //Hotel description Text
        hotelInfo.setEditable(false);
        hotelInfo.setFont(new Font("Serif", Font.BOLD, 13));


        clear.setBounds(730, 90, 71, 20);
        clear.setText("Clear");                                      //clear button
        clear.addActionListener(this);


        JLabel name = new JLabel();
        name.setText("Welcome to White Season Resort");
        name.setForeground(Color.white);                             //name label
        name.setFont(new Font("Serif", Font.BOLD, 20));
        name.setBounds(300,0,300,20);


        search.setText("Search");                                    //search button
        search.addActionListener(this);
        search.setBounds(340, 310, 75, 20);

        JLabel inInfo = new JLabel();
        inInfo.setText("Enter the start date");
        inInfo.setForeground(Color.white);
        inInfo.setBounds(50, 120, 200, 20);        //asks to input start date
        inDate.setBounds(250, 120, 100, 20);       // start date input place
        inDate.setText("yy-mm-dd");



        JLabel outInfo = new JLabel();
        outInfo.setText("Enter the end date");                       //asks to input the end date
        outInfo.setForeground(Color.white);
        outInfo.setBounds(50, 170, 200, 20);
        outDate.setBounds(250, 170, 100, 20);
        outDate.setText("yy-mm-dd");                                 // end date input place




        JLabel peopleInfo = new JLabel();
        peopleInfo.setText("Choose the number of people");           //asks to choose number of people
        peopleInfo.setForeground(Color.white);
        peopleInfo.setBounds(50, 220, 200, 20);

        Integer[] nums = {1, 2, 3, 4};
        numberOfPeople = new JComboBox(nums);
        numberOfPeople.setBounds(250, 220, 40, 30); //combo box that has variants of number 1-4

        JLabel mealInfo = new JLabel();
        mealInfo.setText("Room should be with");                      //asks to choose meal plan
        mealInfo.setForeground(Color.white);
        mealInfo.setBounds(50, 270, 200, 20);

        String[] meals = {"Breakfast", "Three Meal Plan"};
        mealPlan = new JComboBox(meals);                              //combo box that has variants of meal plan breakfast and three meal
        mealPlan.setBounds(250, 270, 100, 30);

        JLabel userLabel = new JLabel();
        userLabel.setText("Fill the personal information");           // personal info label
        userLabel.setForeground(Color.white);
        userLabel.setFont(new Font("Serif", Font.BOLD, 18));
        userLabel.setBounds(50, 320, 270, 20);

        JLabel firstNameInfo = new JLabel();
        firstNameInfo.setText("Enter your first name");             //asks to input first name
        firstNameInfo.setForeground(Color.white);
        firstNameInfo.setBounds(50, 370, 200, 20);
        firstName.setBounds(250, 370, 200, 20);   //place to input the first name

        JLabel lastNameInfo = new JLabel();
        lastNameInfo.setText("Enter your last name");               //asks to input last name
        lastNameInfo.setForeground(Color.white);
        lastNameInfo.setBounds(50, 420, 200, 20);
        lastName.setBounds(250, 420, 200, 20);    //place to input the last name

        JLabel phoneInfo = new JLabel();
        phoneInfo.setText("Enter your phone number");               //asks to input phone number
        phoneInfo.setBounds(50, 470, 200, 20);
        phoneInfo.setForeground(Color.white);
        phone.setBounds(250, 470, 200, 20);       //place to input the phone number

        roomsInfo = new JTextArea();
        roomsInfo.setBounds(460, 120, 400, 400);  //textArea for available rooms info after search
        roomsInfo.setEditable(false);

        JLabel roomNumberInfo = new JLabel();
        roomNumberInfo.setText("Enter the Room Number from above");  //asks to input the room number according to the room above
        roomNumberInfo.setForeground(Color.white);
        roomNumberInfo.setBounds(460, 540, 300, 20);
        number.setBounds(680, 540, 20, 20);        // place to input the room number


        reserve.addActionListener(this);
        reserve.setBounds(680, 570, 90, 20);    //reserve button
        reserve.setText("Reserve");
        f.setContentPane(new JLabel(new ImageIcon("hotelphoto.jpg")));  //adding photo to background

        f.add(hotelInfo);               //adding all components
        f.add(clear);
        f.add(reserve);
        f.add(number);
        f.add(numberOfPeople);
        f.add(roomsInfo);
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


        f.setSize(900, 700);
        f.setTitle("White Season Resort");


        f.setVisible(true);
    }

    public boolean x(JComboBox s) {
        if (s.getSelectedIndex() == 0) return true;
        else return false;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            LocalDate sd = LocalDate.parse(inDate.getText());
            LocalDate ed = LocalDate.parse(outDate.getText());

            if (sd.isBefore(LocalDate.now()) || sd.isAfter(ed)) { //checking if the order of start date and end date is not right, shows appropriate message
                throw new DateMissMatchException();
            }
            if (Room.getNumberBetweenDates(sd, ed) > 30) {  //checking if the period is > than 30 days, shows appropriate message
                throw new DateOutOfPeriodException();
            }
            if (firstName.getText().isEmpty() ||   // checking if the personal info fields are empty, shows appropriate message
                    lastName.getText().isEmpty() ||
                    phone.getText().isEmpty()) {
                throw new EmptyInfoException();

            }
            if (e.getSource() == search) {






                roomsInfo.setText((h.searchResultToString     //setting the tex of the rooms info from the method searchResultToString
                        // that uses ArrayList from search method
                                (h.search(sd,
                                        ed,
                                        x(mealPlan),
                                        !x(mealPlan),
                                        numberOfPeople.getSelectedIndex() + 1),
                                        sd,
                                        ed)));




            }
            if (e.getSource() == reserve) {
                ArrayList<Room> availableRooms = h.search(sd,          //saves filtered arraylist of room from search to a new Arraylist
                        ed, x(mealPlan), !x(mealPlan),
                        numberOfPeople.getSelectedIndex() + 1);
                boolean isSame = false;
                if (availableRooms.size() > 0) {
                    for (int i = 0; i < availableRooms.size(); i++) {
                        if (availableRooms.get(i).getNumber() == parseInt(number.getText())) {
                            availableRooms.get(i).reserve(sd,   //checks if number of available rooms is same with the inputted number, reserves the room
                                    ed,                         //and shows message of successful reservation
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

                    if (isSame) {
                        JOptionPane.showConfirmDialog(null,  //if the input is wrong then shows the wrong input message.
                                "Wrong room number as input",
                                "Error", JOptionPane.PLAIN_MESSAGE);
                    }
                }

            }

            if (e.getSource() == clear) {         //clears the textField for the new reservation

                inDate.setText("yy/mm/dd");
                outDate.setText("yy/mm/dd");
                firstName.setText("");
                lastName.setText("");
                phone.setText("");
                roomsInfo.setText("");
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
                    "Cannot make a reservation for more than 30 days ",
                    "Date Error", JOptionPane.PLAIN_MESSAGE);
        }
        catch (DateMissMatchException ex){
            JOptionPane.showConfirmDialog(null,
                    "Wrong date input ",
                    "Date Error", JOptionPane.PLAIN_MESSAGE);
        }
        catch (Exception ex){              // shows message wrong date input when start or end date are inputted wrong
            JOptionPane.showConfirmDialog(null,
                    "Wrong date input ",
                    "Date Error", JOptionPane.PLAIN_MESSAGE);
        }






    }
}
