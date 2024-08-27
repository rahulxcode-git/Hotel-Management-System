package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class updateroom extends JFrame implements ActionListener {
    JButton check, update, remove, back;
    JLabel roomno, ava, cleanstatus, price, bedtype, changeroomno;
    JComboBox<String> avaText, cleanText, bedtypeText;
    Choice choiceroomno;
    JTextField priceText, changeroomnoText;

    updateroom() {

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 990, 590);
        panel.setBackground(new Color(41, 54, 36));
        panel.setLayout(null);
        add(panel);

        JLabel URS = new JLabel("Update Room Status");
        URS.setBounds(420, 13, 300, 31);
        URS.setForeground(Color.WHITE);
        URS.setFont(new Font("Couture", Font.BOLD, 25));
        URS.setLayout(null);
        panel.add(URS);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
        Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon imageicon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageicon1);
        label.setBounds(650, 150, 200, 200);
        panel.add(label);

        roomno = new JLabel("Room Number:");
        roomno.setBounds(35, 105, 150, 18);
        roomno.setForeground(Color.WHITE);
        roomno.setFont(new Font("Couture", Font.BOLD, 15));
        roomno.setLayout(null);
        panel.add(roomno);
        choiceroomno = new Choice();
        choiceroomno.setBounds(230, 105, 200, 25);
        choiceroomno.setFont(new Font("Couture", Font.BOLD, 14));
        choiceroomno.setForeground(Color.WHITE);
        choiceroomno.setBackground(new Color(63, 82, 55, 255));
        panel.add(choiceroomno);
        try {
            conndb c = new conndb();
            ResultSet resultSet = c.statement.executeQuery("select * from room");
            while (resultSet.next()) {
                choiceroomno.add(resultSet.getString("roomno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        changeroomno = new JLabel("Change Room No.");
        changeroomno.setBounds(35, 155, 150, 18);
        changeroomno.setFont(new Font("Couture", Font.BOLD, 14));
        changeroomno.setForeground(Color.WHITE);
        panel.add(changeroomno);
        changeroomnoText = new JTextField();
        changeroomnoText.setBounds(230, 155, 200, 25);
        changeroomnoText.setBackground(new Color(63, 82, 55, 255));
        changeroomnoText.setFont(new Font("Couture", Font.BOLD, 14));
        changeroomnoText.setForeground(Color.WHITE);
        panel.add(changeroomnoText);

        ava = new JLabel("Availability:");
        ava.setBounds(35, 205, 150, 18);
        ava.setFont(new Font("Couture", Font.BOLD, 14));
        ava.setForeground(Color.WHITE);
        panel.add(ava);
        avaText = new JComboBox<>(new String[]{"Available", "Occupied"});
        avaText.setBounds(230, 205, 200, 25);
        avaText.setBackground(new Color(63, 82, 55, 255));
        avaText.setFont(new Font("Couture", Font.BOLD, 14));
        avaText.setForeground(Color.WHITE);
        panel.add(avaText);

        cleanstatus = new JLabel("Cleaning Status:");
        cleanstatus.setBounds(35, 255, 150, 18);
        cleanstatus.setFont(new Font("Couture", Font.BOLD, 14));
        cleanstatus.setForeground(Color.WHITE);
        panel.add(cleanstatus);
        cleanText = new JComboBox<>(new String[]{"Cleanned", "Dirty"});
        cleanText.setBounds(230, 255, 200, 25);
        cleanText.setBackground(new Color(63, 82, 55, 255));
        cleanText.setFont(new Font("Couture", Font.BOLD, 14));
        cleanText.setForeground(Color.WHITE);
        panel.add(cleanText);

        price = new JLabel("Price:");
        price.setBounds(35, 305, 150, 18);
        price.setFont(new Font("Couture", Font.BOLD, 14));
        price.setForeground(Color.WHITE);
        panel.add(price);
        priceText = new JTextField();
        priceText.setBounds(230, 305, 200, 25);
        priceText.setBackground(new Color(63, 82, 55, 255));
        priceText.setFont(new Font("Couture", Font.BOLD, 14));
        priceText.setForeground(Color.WHITE);
        panel.add(priceText);

        bedtype = new JLabel("Bed-Type:");
        bedtype.setBounds(35, 355, 150, 18);
        bedtype.setFont(new Font("Couture", Font.BOLD, 14));
        bedtype.setForeground(Color.WHITE);
        panel.add(bedtype);
        bedtypeText = new JComboBox<>(new String[]{"Single Bed", "Double Bed"});
        bedtypeText.setBounds(230, 355, 200, 25);
        bedtypeText.setBackground(new Color(63, 82, 55, 255));
        bedtypeText.setFont(new Font("Couture", Font.BOLD, 14));
        bedtypeText.setForeground(Color.WHITE);
        panel.add(bedtypeText);

        check = new JButton("Check");
        check.setBounds(220, 500, 120, 30);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String roomno = choiceroomno.getSelectedItem();
                String q = "select * from room where roomno = '" + roomno + "' ";

                try {
                    conndb c = new conndb();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    while (resultSet.next()) {
                        avaText.setSelectedItem(resultSet.getString("availability"));
                        cleanText.setSelectedItem(resultSet.getString("cleaning_status"));
                        priceText.setText(resultSet.getString("price"));
                        bedtypeText.setSelectedItem(resultSet.getString("bed_type"));
                    }
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        update = new JButton("Update");
        update.setBounds(360, 500, 120, 30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        panel.add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    conndb c = new conndb();
                    String q1 = choiceroomno.getSelectedItem();

                    String availability = (String) avaText.getSelectedItem();
                    String cleaningstatus = (String) cleanText.getSelectedItem();
                    String price = priceText.getText();
                    String bedtype = (String) bedtypeText.getSelectedItem();
                    String changeroomno = changeroomnoText.getText();

                    String query = "update room set roomno = '" + changeroomno + "', cleaning_status = '" + cleaningstatus + "', price = '" + price + "', bed_type = '" + bedtype + "', availability = '" + availability + "' where  roomno = '" + q1 + "'";
                    c.statement.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Updated Successfully");
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        remove = new JButton("Remove Room");
        remove.setBounds(500, 500, 120, 30);
        remove.setBackground(Color.BLACK);
        remove.setForeground(Color.WHITE);
        panel.add(remove);
        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    conndb c = new conndb();
                    String q1 = choiceroomno.getSelectedItem();
                    String query = "delete from room where roomno = '" + q1 + "'";
                    c.statement.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Room Removed Successfully");
                    choiceroomno.remove(q1);  // Remove the room from the choice dropdown
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        back = new JButton("Back");
        back.setBounds(640, 500, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setBounds(500, 100, 1000, 600);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new updateroom();
    }
}