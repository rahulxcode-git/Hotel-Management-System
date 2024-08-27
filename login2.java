package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class login2 extends JFrame implements ActionListener {

    JTextField textField2;
    JPasswordField passwordField2;
    JButton b1, b2;

    login2() {

        super("Elegance suites");

        getContentPane().setBackground(Color.decode("#293624"));
        setBounds(450,270,600,300);
        setLayout(null);

//        For username
        JLabel user = new JLabel("Username");
        user.setBounds(40, 55, 100, 30);
        user.setForeground(Color.WHITE);
        user.setFont(new Font("Couture", Font.BOLD, 15));
        add(user);

        textField2 = new JTextField();
        textField2.setBounds(150, 55, 150, 30);
        textField2.setFont(new Font("Couture", Font.BOLD, 15));
        add(textField2);

//        for password
        JLabel pass = new JLabel("Password");
        pass.setBounds(40, 125, 100, 30);
        pass.setForeground(Color.WHITE);
        pass.setFont(new Font("Couture", Font.BOLD, 15));
        add(pass);

        passwordField2 = new JPasswordField();
        passwordField2.setBounds(150, 125, 150, 30);
        passwordField2.setFont(new Font("Couture", Font.BOLD, 15));
        add(passwordField2);

//        Login Button
        b1 = new JButton("Login");
        b1.setBounds(40, 200, 120, 30);
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLACK);
        b1.setFont(new Font("Couture", Font.BOLD, 20));
        b1.addActionListener(this);
        add(b1);

        // Cancel Button
        b2 = new JButton("Cancel");
        b2.setBounds(180, 200, 120, 30);
        b2.setBackground(Color.WHITE);
        b2.setForeground(Color.BLACK);
        b2.setFont(new Font("Couture", Font.BOLD, 20));
        b2.addActionListener(this);
        add(b2);

//        for logo
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 10, 200, 200);
        add(image);

        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            try {
                conndb c = new conndb();
                String user = textField2.getText();
                String pass = passwordField2.getText();

                String q = "select * from login2 where username = '" + user + "' and password = '" + pass + "'";
                ResultSet resultSet = c.statement.executeQuery(q);

                if (resultSet.next()) {
                    new admin();
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
                }
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else {
            System.exit(102);
        }
    }

    public static void main(String[] args) {
        new login2();
    }
}
