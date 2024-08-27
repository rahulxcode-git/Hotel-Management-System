package hotel.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

//41,54,36
//63, 82, 55, 255
//5,5,890,490
//Couture

public class room extends JFrame {

    JTable table;
    JButton back;
    room(){
//        for white patti
        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,590);
        panel.setBackground(new Color(41,54,36));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/roomm.png"));
        Image image= imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageicon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageicon1);
        label.setBounds(600,200,200,200);
        panel.add(label);

        table = new JTable();
        table.setBounds(10,40,500,400);
        table.setBackground(new Color(41,54,36));
        table.setForeground(Color.WHITE);
        panel.add(table);



        try{
            conndb c =new conndb();
            String roominfo = "select * from room";
            ResultSet resultSet = c.statement.executeQuery(roominfo);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e){
            e.printStackTrace();
        }

        back = new JButton("Back");
        back.setBounds(200,500,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        JLabel rno = new JLabel("Room No.");
        rno.setBounds(15,15,150,19);
        rno.setForeground(Color.WHITE);
        rno.setFont(new Font("Couture",Font.BOLD,14));
        panel.add(rno);

        JLabel availability = new JLabel("Availability");
        availability.setBounds(119,15,80,19);
        availability.setForeground(Color.WHITE);
        availability.setFont(new Font("Couture",Font.BOLD,14));
        panel.add(availability);

        JLabel clean = new JLabel("Clean Status");
        clean.setBounds(216,15,150,19);
        clean.setForeground(Color.WHITE);
        clean.setFont(new Font("Couture",Font.BOLD,14));
        panel.add(clean);

        JLabel price = new JLabel("Price");
        price.setBounds(330,15,80,19);
        price.setForeground(Color.WHITE);
        price.setFont(new Font("Couture",Font.BOLD,14));
        panel.add(price);

        JLabel type = new JLabel("Bed Type");
        type.setBounds(417,15,150,19);
        type.setForeground(Color.WHITE);
        type.setFont(new Font("Couture",Font.BOLD,14));
        panel.add(type);



        setUndecorated(true);
        setBounds(500,100,900,600);
        setLayout(null);
        setVisible(true);
    }


    public static void main(String[] args) {
        new room();
    }
}
