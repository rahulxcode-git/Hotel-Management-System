package hotel.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class allemployee extends JFrame {
    allemployee(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,990,590);
        panel.setBackground(new Color(41,54,36));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10,34,980,450);
        table.setBackground(new Color(41,54,36));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try{
            conndb c =new conndb();
            String allemp = "select * from employee";
            ResultSet resultSet = c.statement.executeQuery(allemp);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e){
            e.printStackTrace();
        }

        JButton back = new JButton("Back");
        back.setBounds(400,500,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        JLabel ename = new JLabel("EMP Name");
        ename.setBounds(15,15,150,19);
        ename.setForeground(Color.WHITE);
        ename.setFont(new Font("Couture",Font.BOLD,14));
        panel.add(ename);

        JLabel age = new JLabel("Age");
        age.setBounds(132,15,80,19);
        age.setForeground(Color.WHITE);
        age.setFont(new Font("Couture",Font.BOLD,14));
        panel.add(age);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(255,15,150,19);
        gender.setForeground(Color.WHITE);
        gender.setFont(new Font("Couture",Font.BOLD,14));
        panel.add(gender);

        JLabel position = new JLabel("Position");
        position.setBounds(380,15,80,19);
        position.setForeground(Color.WHITE);
        position.setFont(new Font("Couture",Font.BOLD,14));
        panel.add(position);

        JLabel salary = new JLabel("Salary");
        salary.setBounds(500,15,150,19);
        salary.setForeground(Color.WHITE);
        salary.setFont(new Font("Couture",Font.BOLD,14));
        panel.add(salary);

        JLabel phone = new JLabel("Contact no.");
        phone.setBounds(625,15,150,19);
        phone.setForeground(Color.WHITE);
        phone.setFont(new Font("Couture",Font.BOLD,14));
        panel.add(phone);

        JLabel gmail = new JLabel("Gmail");
        gmail.setBounds(745,15,80,19);
        gmail.setForeground(Color.WHITE);
        gmail.setFont(new Font("Couture",Font.BOLD,14));
        panel.add(gmail);

        JLabel aadhar = new JLabel("Aadhar no.");
        aadhar.setBounds(870,15,150,19);
        aadhar.setForeground(Color.WHITE);
        aadhar.setFont(new Font("Couture",Font.BOLD,14));
        panel.add(aadhar);

        setUndecorated(true);
        setBounds(500,100,1000,600);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new allemployee();
    }
}
