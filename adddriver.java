package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//41,54,36
//63, 82, 55, 255
//5,5,890,490
//Couture

public class adddriver extends JFrame implements ActionListener {

    JTextField nameText, ageText, carclText, carnameText, locationText;
    JComboBox available, genderbutton;
    JButton back, add;

    adddriver() {


//        JPanel panel1 = new JPanel();
//        panel1.setBounds(5, 5, 850, 450);
//        panel1.setLayout(null);
//        panel1.setBackground(new Color(41, 54, 36));
//        add(panel1);

        JPanel panel1=new JPanel();
        panel1.setBackground(new Color(41,54,36));
        panel1.setBounds(5,5,875,490);
        panel1.setLayout(null);
        add(panel1);



        JLabel ADD = new JLabel("ADD DRIVER DETAILS");
        ADD.setBounds(450, 24, 455, 35);
        ADD.setFont(new Font("Couture", Font.BOLD, 31));
        ADD.setForeground(Color.WHITE);
        panel1.add(ADD);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/license.png"));
        Image image = imageIcon.getImage().getScaledInstance(280, 280, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500, 100, 280, 280);
        panel1.add(label);

        JLabel name = new JLabel("Name");
        name.setBounds(60, 30, 150, 27);
        name.setFont(new Font("Couture", Font.BOLD, 17));
        name.setForeground(Color.WHITE);
        panel1.add(name);
        nameText = new JTextField();
        nameText.setBounds(200, 30, 150, 27);
        nameText.setBackground(new Color(63, 82, 55, 255));
        nameText.setFont(new Font("Couture", Font.PLAIN, 14));
        nameText.setForeground(Color.WHITE);
        panel1.add(nameText);

        JLabel Age = new JLabel("Age");
        Age.setBounds(60, 80, 150, 27);
        Age.setFont(new Font("Couture", Font.BOLD, 17));
        Age.setForeground(Color.WHITE);
        panel1.add(Age);
        ageText = new JTextField();
        ageText.setBounds(200, 80, 150, 27);
        ageText.setBackground(new Color(63, 82, 55, 255));
        ageText.setFont(new Font("Couture", Font.PLAIN, 14));
        ageText.setForeground(Color.WHITE);
        panel1.add(ageText);

        JLabel Gender = new JLabel("Gender");
        Gender.setBounds(60, 120, 150, 27);
        Gender.setFont(new Font("Couture", Font.BOLD, 17));
        Gender.setForeground(Color.WHITE);
        panel1.add(Gender);
        genderbutton = new JComboBox(new String[]{"male", "Female"});
        genderbutton.setBounds(200, 120, 150, 27);
        genderbutton.setBackground(new Color(63, 82, 55, 255));
        genderbutton.setFont(new Font("Couture", Font.PLAIN, 14));
        genderbutton.setForeground(Color.WHITE);
        panel1.add(genderbutton);

        JLabel carc = new JLabel("Car Company");
        carc.setBounds(60, 170, 150, 27);
        carc.setFont(new Font("Couture", Font.BOLD, 17));
        carc.setForeground(Color.WHITE);
        panel1.add(carc);
        carclText = new JTextField();
        carclText.setBounds(200, 170, 150, 27);
        carclText.setBackground(new Color(63, 82, 55, 255));
        carclText.setFont(new Font("Couture", Font.PLAIN, 14));
        carclText.setForeground(Color.WHITE);
        panel1.add(carclText);

        JLabel carname = new JLabel("Car Name");
        carname.setBounds(60, 220, 150, 27);
        carname.setFont(new Font("Couture", Font.BOLD, 17));
        carname.setForeground(Color.WHITE);
        panel1.add(carname);
        carnameText = new JTextField();
        carnameText.setBounds(200, 220, 150, 27);
        carnameText.setBackground(new Color(63, 82, 55, 255));
        carnameText.setFont(new Font("Couture", Font.PLAIN, 14));
        carnameText.setForeground(Color.WHITE);
        panel1.add(carnameText);

        JLabel ava = new JLabel("Available");
        ava.setBounds(60, 270, 150, 27);
        ava.setFont(new Font("Couture", Font.BOLD, 17));
        ava.setForeground(Color.WHITE);
        panel1.add(ava);
        available = new JComboBox(new String[]{"Yes", "No"});
        available.setBounds(200, 270, 150, 27);
        available.setBackground(new Color(63, 82, 55, 255));
        available.setFont(new Font("Couture", Font.PLAIN, 14));
        available.setForeground(Color.WHITE);
        panel1.add(available);

        JLabel location = new JLabel("Pick-Up Point");
        location.setBounds(60, 320, 150, 27);
        location.setFont(new Font("Couture", Font.BOLD, 17));
        location.setForeground(Color.WHITE);
        panel1.add(location);
        locationText = new JTextField();
        locationText.setBounds(200, 320, 150, 27);
        locationText.setBackground(new Color(63, 82, 55, 255));
        locationText.setFont(new Font("Couture", Font.PLAIN, 14));
        locationText.setForeground(Color.WHITE);
        panel1.add(locationText);

        add = new JButton("Add");
        add.setBounds(198, 420, 111, 33);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        panel1.add(add);

        back = new JButton("Back");
        back.setBounds(64, 420, 111, 33);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        panel1.add(back);

//        setUndecorated(true);
//        setBounds(60, 160, 900, 500);
//        setVisible(true);
//        setLayout(null);

        setUndecorated(true);
        setBounds(20,200,885,500);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {

            String name = nameText.getText();
            String age = ageText.getText();
            String carcom = carclText.getText();
            String carname = carnameText.getText();
            String location = locationText.getText();
            String ava = (String) available.getSelectedItem();
            String gender = (String) genderbutton.getSelectedItem();

            try{

                conndb c=new conndb();
                String q = "insert into driver values( '"+name+"','"+age+"','"+carcom+"','"+carname+"','"+location+"','"+ava+"','"+gender+"' )";
                c.statement.executeUpdate(q);

                JOptionPane.showMessageDialog(null,"Detailes Added Succesfully ");
                this.setVisible(false);

            }catch (Exception E){
                E.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new adddriver();
    }
}
