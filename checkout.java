package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class checkout extends JFrame implements ActionListener {
    JLabel cname, roomnumber, checkintime, checkouttime;
    Choice customer;
    JTextField roomnotext, checkindatetext, checkoutdatetext;
    JButton check, checkoutroom, back;

    checkout() {

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 990, 590);
        panel.setBackground(new Color(41, 54, 36));
        panel.setLayout(null);
        add(panel);

        JLabel CO = new JLabel("Check Out");
        CO.setBounds(420, 13, 300, 31);
        CO.setForeground(Color.WHITE);
        CO.setFont(new Font("Couture", Font.BOLD, 25));
        CO.setLayout(null);
        panel.add(CO);

        cname = new JLabel("Customer Name:");
        cname.setBounds(35, 105, 150, 18);
        cname.setForeground(Color.WHITE);
        cname.setFont(new Font("Couture", Font.BOLD, 15));
        cname.setLayout(null);
        panel.add(cname);

        customer = new Choice();
        customer.setBounds(230, 105, 200, 25);
        customer.setFont(new Font("Couture", Font.BOLD, 14));
        customer.setForeground(Color.WHITE);
        customer.setBackground(new Color(63, 82, 55, 255));
        panel.add(customer);

        try {
            conndb c = new conndb();
            String q = "select * from customer";
            ResultSet resultSet = c.statement.executeQuery(q);
            while (resultSet.next()) {
                customer.add(resultSet.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        roomnumber = new JLabel("Room Number:");
        roomnumber.setBounds(35, 155, 150, 18);
        roomnumber.setForeground(Color.WHITE);
        roomnumber.setFont(new Font("Couture", Font.BOLD, 15));
        roomnumber.setLayout(null);
        panel.add(roomnumber);

        roomnotext = new JTextField();
        roomnotext.setBounds(230, 155, 200, 25);
        roomnotext.setBackground(new Color(63, 82, 55, 255));
        roomnotext.setFont(new Font("Couture", Font.BOLD, 14));
        roomnotext.setForeground(Color.WHITE);
        panel.add(roomnotext);

        checkintime = new JLabel("Check-In Date:");
        checkintime.setBounds(35, 205, 150, 18);
        checkintime.setForeground(Color.WHITE);
        checkintime.setFont(new Font("Couture", Font.BOLD, 15));
        checkintime.setLayout(null);
        panel.add(checkintime);

        checkindatetext = new JTextField();
        checkindatetext.setBounds(230, 205, 200, 25);
        checkindatetext.setBackground(new Color(63, 82, 55, 255));
        checkindatetext.setFont(new Font("Couture", Font.BOLD, 14));
        checkindatetext.setForeground(Color.WHITE);
        panel.add(checkindatetext);

        checkouttime = new JLabel("Check-Out Date:");
        checkouttime.setBounds(35, 255, 150, 18);
        checkouttime.setForeground(Color.WHITE);
        checkouttime.setFont(new Font("Couture", Font.BOLD, 15));
        checkouttime.setLayout(null);
        panel.add(checkouttime);

        checkoutdatetext = new JTextField();
        checkoutdatetext.setBounds(230, 255, 200, 25);
        checkoutdatetext.setBackground(new Color(63, 82, 55, 255));
        checkoutdatetext.setFont(new Font("Couture", Font.BOLD, 14));
        checkoutdatetext.setForeground(Color.WHITE);
        panel.add(checkoutdatetext);

        check = new JButton("Check");
        check.setBounds(300, 500, 120, 30);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = customer.getSelectedItem();
                String q1 = "select * from customer where name = '" + name + "' ";

                try {

                    conndb c = new conndb();
                    ResultSet resultSet = c.statement.executeQuery(q1);
                    while (resultSet.next()) {
                        roomnotext.setText(resultSet.getString("arn"));
                        checkindatetext.setText(resultSet.getString("checkin"));
                    }

                    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                    Date date = new Date();
                    checkoutdatetext.setText(formatter.format(date));

                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        checkoutroom = new JButton("Check-Out");
        checkoutroom.setBounds(440, 500, 120, 30);
        checkoutroom.setBackground(Color.BLACK);
        checkoutroom.setForeground(Color.WHITE);
        checkoutroom.addActionListener(this);
        panel.add(checkoutroom);

        back = new JButton("Back");
        back.setBounds(580, 500, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        panel.add(back);

        setUndecorated(true);
        setBounds(500, 100, 1000, 600);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == checkoutroom) {
            // Implement checkout logic here
            String roomno = roomnotext.getText();

            try {
                conndb c = new conndb();
                // Update the room status to available and checkout the customer
                String q1 = "update room set availability = 'Available' where roomno = '" + roomno + "'";
                String q2 = "delete from customer where arn = '" + roomno + "'";
                c.statement.executeUpdate(q1);
                c.statement.executeUpdate(q2);

                JOptionPane.showMessageDialog(null, "Check-Out Successful");

            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (e.getSource() == back) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new checkout();
    }
}
