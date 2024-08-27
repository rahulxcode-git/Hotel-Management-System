package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class admin extends JFrame implements ActionListener {

//    Globaly Declared Button
    JButton add_emp/*addemployee*/,add_room/*addroom*/,add_driver/*adddriver*/,logout,back;
    admin(){

        super("Elegance suites");

//        Amployee button and its Action
        add_emp=new JButton("ADD EMPLOYEE");
        add_emp.setBounds(250,230,200,30);
        add_emp.setBackground(Color.WHITE);
        add_emp.setForeground(Color.BLACK);
        add_emp.setFont(new Font("Couture",Font.BOLD,15));
        add_emp.addActionListener(this);
        add(add_emp);

//        Room button and its Action
        add_room=new JButton("ADD ROOM");
        add_room.setBounds(250,380,200,30);
        add_room.setBackground(Color.WHITE);
        add_room.setForeground(Color.BLACK);
        add_room.setFont(new Font("Couture",Font.BOLD,15));
        add_room.addActionListener(this);
        add(add_room);

//        Driver button and its Action
        add_driver=new JButton("ADD DRIVERS");
        add_driver.setBounds(250,530,200,30);
        add_driver.setBackground(Color.WHITE);
        add_driver.setForeground(Color.BLACK);
        add_driver.setFont(new Font("Couture",Font.BOLD,15));
        add_driver.addActionListener(this);
        add(add_driver);

//        logout button and its Action
        logout=new JButton("Logout");
        logout.setBounds(10,750,95,30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.setFont(new Font("Couture",Font.BOLD,15));
        logout.addActionListener(this);
        add(logout);

//        Back button and its Action
        back=new JButton("Back");
        back.setBounds(110,750,95,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Couture",Font.BOLD,15));
        back.addActionListener(this);
        add(back);

//      Employee PNG
        ImageIcon l1=new ImageIcon(ClassLoader.getSystemResource("icons/employees.png"));
        Image l11 = l1.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        ImageIcon imageIcon=new ImageIcon(l11);
        JLabel label= new JLabel(imageIcon);
        label.setBounds(70,180,120,120);
        add(label);

//      Room PNG
        ImageIcon l2=new ImageIcon(ClassLoader.getSystemResource("icons/room.png"));
        Image l12 = l2.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(l12);
        JLabel label2= new JLabel(imageIcon1);
        label2.setBounds(70,340,120,120);
        add(label2);

//      Driver PNG
        ImageIcon l3=new ImageIcon(ClassLoader.getSystemResource("icons/driver.png"));
        Image l13 = l3.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        ImageIcon imageIcon2=new ImageIcon(l13);
        JLabel label3= new JLabel(imageIcon2);
        label3.setBounds(70,500,120,120);
        add(label3);

//      Logo PNG
        ImageIcon l4=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image l14 = l4.getImage().getScaledInstance(700,700,Image.SCALE_DEFAULT);
        ImageIcon imageIcon3=new ImageIcon(l14);
        JLabel label4= new JLabel(imageIcon3);
        label4.setBounds(800,150,450,450);
        add(label4);

        setBounds(0,0,1950,1080);
        setLayout(null);
        setVisible(true);

        getContentPane().setBackground(new Color(41,54,36));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        all buttons actions
        if (e.getSource() == add_emp) {
            new addemp();
        } else if (e.getSource() == add_room) {
            new addroom();
        } else if (e.getSource() == add_driver) {
            new adddriver();
        } else if (e.getSource() == logout) {
            System.exit(102);
        } else if (e.getSource() == back) {
            new Dashboard();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new admin();
    }
}
