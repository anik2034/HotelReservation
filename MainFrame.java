import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;

import static java.lang.Integer.parseInt;

public class MainFrame implements ActionListener {
    JButton search = new JButton();
    JTextField inDate = new JTextField();
    JTextField outDate = new JTextField();
    JTextField firstName = new JTextField();
    JTextField lastName = new JTextField();
    JTextField phone = new JTextField();
    JComboBox numberOfPeople;
    JComboBox mealPlan;
    JButton reserve = new JButton();
    JTextArea roomsInfo;
    JTextField number = new JTextField();
    JButton clear = new JButton();
    Hotel h = new Hotel();

    MainFrame() {

        clear.setBounds(730, 20, 71, 20);
        clear.setText("Clear");


        JLabel name = new JLabel();
        name.setText("Welcome to White Season Resort");

        name.setFont(new Font("Serif", Font.BOLD, 18));
        name.setHorizontalAlignment(SwingConstants.CENTER);
        name.setVerticalAlignment(SwingConstants.TOP);

        JFrame f = new JFrame();
        search.setText("Search");
        search.addActionListener(this);
        search.setBounds(340, 240, 75, 20);

        JLabel inInfo = new JLabel();
        inInfo.setText("Enter the start date");
        inInfo.setBounds(50, 50, 200, 20);
        inDate.setBounds(250, 50, 100, 20);


        JLabel outInfo = new JLabel();
        outInfo.setText("Enter the end date");
        outInfo.setBounds(50, 100, 200, 20);
        outDate.setBounds(250, 100, 100, 20);


        JLabel numInfo = new JLabel();
        numInfo.setText("Choose the number of people");
        numInfo.setBounds(50, 150, 200, 20);

        Integer[] nums = {1, 2, 3, 4};
        numberOfPeople = new JComboBox(nums);
        numberOfPeople.setBounds(250, 150, 40, 30);

        JLabel mealInfo = new JLabel();
        mealInfo.setText("Room should be with");
        mealInfo.setBounds(50, 200, 200, 20);

        String[] meals = {"Breakfast", "Three Meal Plan"};
        mealPlan = new JComboBox(meals);
        mealPlan.setBounds(250, 200, 100, 30);

        JLabel user = new JLabel();
        user.setText("Fill the personal information");
        user.setFont(new Font("Serif", Font.BOLD, 18));
        user.setBounds(50, 250, 270, 20);

        JLabel first = new JLabel();
        first.setText("Enter your first name");
        first.setBounds(50, 300, 200, 20);
        firstName.setBounds(250, 300, 200, 20);

        JLabel last = new JLabel();
        last.setText("Enter your last name");
        last.setBounds(50, 350, 200, 20);
        lastName.setBounds(250, 350, 200, 20);

        JLabel ph = new JLabel();
        ph.setText("Enter your phone number");
        ph.setBounds(50, 400, 200, 20);
        phone.setBounds(250, 400, 200, 20);

        roomsInfo = new JTextArea();
        roomsInfo.setBounds(460, 50, 400, 400);

        JLabel num = new JLabel();
        num.setText("Enter the Room Number from above");
        num.setBounds(460, 470, 300, 20);

        number.setBounds(680, 470, 20, 20);


        reserve.addActionListener(this);
        reserve.setBounds(680, 500, 90, 20);
        reserve.setText("Reserve");

        f.add(clear);
        f.add(reserve);
        f.add(number);
        f.add(num);
        f.add(roomsInfo);
        f.add(phone);
        f.add(ph);
        f.add(lastName);
        f.add(last);
        f.add(firstName);
        f.add(first);
        f.add(user);
        f.add(mealPlan);
        f.add(mealInfo);
        f.add(numInfo);
        f.add(numberOfPeople);
        f.add(outDate);
        f.add(outInfo);
        f.add(inInfo);
        f.add(inDate);
        f.add(search);

        f.add(name);

        f.setSize(900, 600);
        f.setTitle("White Season Resort");


        f.setVisible(true);
    }

    public boolean x(JComboBox e) {
        if (e.getSelectedIndex() == 0) return true;
        else return false;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == search) {
//
//            f.setSize(600,600);
//            JTextArea roomsInfo = new JTextArea();
//            JLabel num = new JLabel();
//            num.setText("Choose Room Number from above");
//            num.setBounds(50,400,200,20);
//            newFrame.add(num);
//            JTextField number = new JTextField();
//            number.setBounds(250,400,20,20);
//            newFrame.add(number);
//
//            reserve.setBounds(250,450,70,20);
//            reserve.addActionListener(this);


//
//            roomsInfo.setText((h.search(LocalDate.parse(inDate.getText()),LocalDate.parse(outDate.getText()),x(mealPlan),!x(mealPlan),numberOfPeople.getSelectedIndex()+1)));
            roomsInfo.setText((h.searchResultToString(h.search(LocalDate.parse(inDate.getText()),
                    LocalDate.parse(outDate.getText()), x(mealPlan), !x(mealPlan), numberOfPeople.getSelectedIndex() + 1), LocalDate.parse(inDate.getText()),
                    LocalDate.parse(outDate.getText()))));


        }
        if (e.getSource() == reserve) {
            List<Room> availableRooms = h.search(LocalDate.parse(inDate.getText()),
                    LocalDate.parse(outDate.getText()), x(mealPlan), !x(mealPlan),
                    numberOfPeople.getSelectedIndex() + 1);
            boolean isSame = false;
            if (availableRooms.size() > 0) {
                for (int i = 0; i < availableRooms.size(); i++) {
                    if (availableRooms.get(i).getNumber() == parseInt(number.getText())) {
                        availableRooms.get(i).reserve(LocalDate.parse(inDate.getText()),
                                LocalDate.parse(outDate.getText()),
                                new User(firstName.getText(), lastName.getText(), phone.getText()));
                        JOptionPane.showConfirmDialog(null, "Succesful Reservation", "Reservation", JOptionPane.PLAIN_MESSAGE);
                        break;
                    } else {
                        isSame = true;
                        break;
                    }
                }

                if (isSame) {
                    JOptionPane.showConfirmDialog(null, "Wrong room number as input", "Error", JOptionPane.PLAIN_MESSAGE);
                }
            }

        }

        if (e.getSource() == clear) {
            inDate.setText("");
            outDate.setText("");
            firstName.setText("");
            lastName.setText("");
            phone.setText("");
            roomsInfo.setText("");
            number.setText("");

        }

    }
}
