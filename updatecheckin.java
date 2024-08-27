package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class updatecheckin extends JFrame implements ActionListener {

    JButton check, update, back;
    JLabel id, roono, name, checkedin, amountpayed, pendingamount;
    Choice choice;
    JComboBox<String> lid;
    JTextField roomnotext, checkedintext, amountpayedtext, pendingamounttext;

    updatecheckin() {

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 990, 590);
        panel.setBackground(new Color(41, 54, 36));
        panel.setLayout(null);
        add(panel);

        JLabel pickup = new JLabel("Check-IN Details");
        pickup.setBounds(420, 13, 300, 31);
        pickup.setForeground(Color.WHITE);
        pickup.setFont(new Font("Couture", Font.BOLD, 25));
        pickup.setLayout(null);
        panel.add(pickup);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/updated.png"));
        Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon imageicon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageicon1);
        label.setBounds(650, 150, 200, 200);
        panel.add(label);

        name = new JLabel("Name:");
        name.setBounds(35, 88, 80, 18);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("Couture", Font.BOLD, 15));
        name.setLayout(null);
        panel.add(name);
        choice = new Choice();
        choice.setBounds(230, 88, 200, 25);
        choice.setFont(new Font("Couture", Font.BOLD, 14));
        choice.setForeground(Color.WHITE);
        choice.setBackground(new Color(63, 82, 55, 255));
        panel.add(choice);

        try {
            conndb c = new conndb();
            String q = "select * from customer";
            ResultSet resultSet = c.statement.executeQuery(q);
            while (resultSet.next()) {
                choice.add(resultSet.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        roono = new JLabel("Room Number:");
        roono.setBounds(35, 138, 150, 18);
        roono.setForeground(Color.WHITE);
        roono.setFont(new Font("Couture", Font.BOLD, 15));
        roono.setLayout(null);
        panel.add(roono);
        roomnotext = new JTextField();
        roomnotext.setBounds(230, 138, 200, 25);
        roomnotext.setBackground(new Color(63, 82, 55, 255));
        roomnotext.setFont(new Font("Couture", Font.BOLD, 14));
        roomnotext.setForeground(Color.WHITE);
        panel.add(roomnotext);

        id = new JLabel("Id:");
        id.setBounds(35, 188, 150, 18);
        id.setForeground(Color.WHITE);
        id.setFont(new Font("Couture", Font.BOLD, 15));
        id.setLayout(null);
        panel.add(id);
        lid = new JComboBox<>(new String[] {"Passport", "Aadhar-Card", "Voter-ID", "Driving-Licence"});
        lid.setBounds(230, 188, 200, 25);
        lid.setFont(new Font("Couture", Font.BOLD, 15));
        lid.setBackground(new Color(63, 82, 55, 255));
        lid.setForeground(Color.WHITE);
        panel.add(lid);

        checkedin = new JLabel("Checked-IN:");
        checkedin.setBounds(35, 238, 150, 18);
        checkedin.setForeground(Color.WHITE);
        checkedin.setFont(new Font("Couture", Font.BOLD, 15));
        checkedin.setLayout(null);
        panel.add(checkedin);
        checkedintext = new JTextField();
        checkedintext.setBounds(230, 238, 200, 25);
        checkedintext.setBackground(new Color(63, 82, 55, 255));
        checkedintext.setFont(new Font("Couture", Font.BOLD, 14));
        checkedintext.setForeground(Color.WHITE);
        panel.add(checkedintext);

        amountpayed = new JLabel("Amount Payed (Rs):");
        amountpayed.setBounds(35, 288, 150, 18);
        amountpayed.setForeground(Color.WHITE);
        amountpayed.setFont(new Font("Couture", Font.BOLD, 15));
        amountpayed.setLayout(null);
        panel.add(amountpayed);
        amountpayedtext = new JTextField();
        amountpayedtext.setBounds(230, 288, 200, 25);
        amountpayedtext.setBackground(new Color(63, 82, 55, 255));
        amountpayedtext.setFont(new Font("Couture", Font.BOLD, 14));
        amountpayedtext.setForeground(Color.WHITE);
        panel.add(amountpayedtext);

        pendingamount = new JLabel("Pending Amount (Rs):");
        pendingamount.setBounds(35, 338, 170, 18);
        pendingamount.setForeground(Color.WHITE);
        pendingamount.setFont(new Font("Couture", Font.BOLD, 15));
        pendingamount.setLayout(null);
        panel.add(pendingamount);
        pendingamounttext = new JTextField();
        pendingamounttext.setBounds(230, 338, 200, 25);
        pendingamounttext.setBackground(new Color(63, 82, 55, 255));
        pendingamounttext.setFont(new Font("Couture", Font.BOLD, 14));
        pendingamounttext.setForeground(Color.WHITE);
        panel.add(pendingamounttext);

        check = new JButton("Check");
        check.setBounds(300, 500, 120, 30);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = choice.getSelectedItem();
                String q1 = "select * from customer where name = '" + name + "' ";

                try {

                    conndb c = new conndb();
                    ResultSet resultSet = c.statement.executeQuery(q1);
                    while (resultSet.next()) {
                        roomnotext.setText(resultSet.getString("arn"));
                        lid.setSelectedItem(resultSet.getString("id"));
                        checkedintext.setText(resultSet.getString("checkin"));
                        amountpayedtext.setText(resultSet.getString("deposit"));
                    }
                    ResultSet resultSet1 = c.statement.executeQuery("select * from room where roomno = '" + roomnotext.getText() + "' ");
                    while (resultSet1.next()) {
                        String price = resultSet1.getString("price");
                        int amountPaid = Integer.parseInt(price) - Integer.parseInt(amountpayedtext.getText());
                        pendingamounttext.setText("" + amountPaid);
                    }
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });


        update = new JButton("Update");
        update.setBounds(440, 500, 120, 30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        panel.add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    conndb c = new conndb();
                    String q2 = choice.getSelectedItem();

                    String gid = (String) lid.getSelectedItem();
                    String room = roomnotext.getText();
                    String checkintime = checkedintext.getText();
                    String amountpayed = amountpayedtext.getText();
                    c.statement.executeUpdate("update customer set arn = '" + room + "', id = '" + gid + "', checkin = '" + checkintime + "', deposit = '" + amountpayed + "' where name = '" + q2 + "' ");
                    JOptionPane.showMessageDialog(null, "Updated Successfully");
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        back = new JButton("Back");
        back.setBounds(580, 500, 120, 30);
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
        // Action handling code
    }

    public static void main(String[] args) {
        new updatecheckin();
    }
}
