package hotel.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class searchrooms extends JFrame implements ActionListener {

    JCheckBox checkbox;
    Choice choice;
    JTable table;
    JButton search, back;

    searchrooms() {

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 990, 590);
        panel.setBackground(new Color(41, 54, 36));
        panel.setLayout(null);
        add(panel);

        JLabel searchForRoom = new JLabel("Search For Rooms");
        searchForRoom.setBounds(420, 11, 300, 31);
        searchForRoom.setForeground(Color.WHITE);
        searchForRoom.setFont(new Font("Couture", Font.BOLD, 25));
        searchForRoom.setLayout(null);
        panel.add(searchForRoom);

        JLabel rbt = new JLabel("Room-Bed Type:");
        rbt.setBounds(50, 70, 130, 25);
        rbt.setForeground(Color.WHITE);
        rbt.setFont(new Font("Couture", Font.BOLD, 15));
        rbt.setLayout(null);
        panel.add(rbt);

        checkbox = new JCheckBox("Only Display Available");
        checkbox.setBounds(700, 69, 205, 23);
        checkbox.setForeground(Color.WHITE);
        checkbox.setBackground(new Color(41, 54, 36));
        checkbox.setFont(new Font("Couture", Font.BOLD, 15));
        panel.add(checkbox);

        choice = new Choice();
        choice.add("All Rooms");
        choice.add("Single Bed");
        choice.add("Double Bed");
        choice.setForeground(Color.WHITE);
        choice.setFont(new Font("Couture", Font.BOLD, 15));
        choice.setBounds(180, 70, 165, 20);
        choice.setBackground(new Color(63, 82, 55, 255));
        panel.add(choice);

        JLabel rno = new JLabel("Room No.");
        rno.setBounds(5, 158,150,19);
        rno.setForeground(Color.WHITE);
        rno.setFont(new Font("Couture",Font.BOLD,16));
        panel.add(rno);

        JLabel availability = new JLabel("Availability");
        availability.setBounds(205,158,120,19);
        availability.setForeground(Color.WHITE);
        availability.setFont(new Font("Couture",Font.BOLD,16));
        panel.add(availability);

        JLabel clean = new JLabel("Clean Status");
        clean.setBounds(405,158,150,19);
        clean.setForeground(Color.WHITE);
        clean.setFont(new Font("Couture",Font.BOLD,16));
        panel.add(clean);

        JLabel price = new JLabel("Price");
        price.setBounds(600,158,120,19);
        price.setForeground(Color.WHITE);
        price.setFont(new Font("Couture",Font.BOLD,16));
        panel.add(price);

        JLabel type = new JLabel("Bed Type");
        type.setBounds(800,158,150,19);
        type.setForeground(Color.WHITE);
        type.setFont(new Font("Couture",Font.BOLD,16));
        panel.add(type);

        table = new JTable();
        table.setBounds(0, 187, 1000, 250);
        table.setBackground(new Color(41, 54, 36));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try {
            conndb c = new conndb();
            String q = "select * from room";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        search = new JButton("Search");
        search.setBounds(540, 500, 120, 30);
        search.setBackground(Color.BLACK);
        search.setForeground(Color.WHITE);
        search.addActionListener(this);
        panel.add(search);

        back = new JButton("Back");
        back.setBounds(400, 500, 120, 30);
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
        if (e.getSource() == search) {

            String Q;
            if (choice.getSelectedItem().equals("All Rooms")) {
                Q = "select * from room";
            } else {
                Q = "select * from room where bed_type = '" + choice.getSelectedItem() + "'";
            }

            String Q1 = Q + " and availability = 'Available'";

            try {
                conndb c = new conndb();
                ResultSet resultSet = c.statement.executeQuery(Q);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));

                if (checkbox.isSelected()) {
                    ResultSet resultSet1 = c.statement.executeQuery(Q1);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet1));
                }
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new searchrooms();
    }
}
