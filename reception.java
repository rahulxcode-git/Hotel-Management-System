package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class reception extends JFrame implements ActionListener{

    JButton back,logout;
    reception(){

        super("Elegance suites");

//        For custome panel
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(280,5,1238,820);
        panel.setBackground(new Color(41,54,36));
        add(panel);

        JPanel panel1=new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5,5,270,820);
        panel1.setBackground(new Color(41,54,36));
        add(panel1);

//        For logo
        ImageIcon reception=new ImageIcon( ClassLoader.getSystemResource("icons/logo.jpg") );
        Image i3= reception.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1r=new ImageIcon(i3);
        JLabel labelr=new JLabel(imageIcon1r);
        labelr.setBounds(300,20,800,800);
        panel.add(labelr);

        ImageIcon reception1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i5= reception1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1t=new ImageIcon(i5);
        JLabel labelt=new JLabel(imageIcon1t);
        labelt.setBounds(30,550,200,200);
        panel1.add(labelt);

//        Button for new customer info
        JButton btnNCF =new JButton("NEW CUSTOMER FORM");
        btnNCF.setBounds(30,30,200,30);
        btnNCF.setBackground(Color.BLACK);
        btnNCF.setForeground(Color.WHITE);
        panel1.add(btnNCF);
        btnNCF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new newcustomer();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

//        Button for ROOMS
        JButton btnroom =new JButton("ROOMS");
        btnroom.setBounds(30,70,200,30);
        btnroom.setBackground(Color.BLACK);
        btnroom.setForeground(Color.WHITE);
        panel1.add(btnroom);
        btnroom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new room();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        //        Button for Department
        JButton btndepartment =new JButton("DEPARTMENT");
        btndepartment.setBounds(30,110,200,30);
        btndepartment.setBackground(Color.BLACK);
        btndepartment.setForeground(Color.WHITE);
        panel1.add(btndepartment);
        btndepartment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new department();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

//        button for All Employee Info
        JButton btnAEI =new JButton("ALL EMPLOYEE INFO");
        btnAEI.setBounds(30,150,200,30);
        btnAEI.setBackground(Color.BLACK);
        btnAEI.setForeground(Color.WHITE);
        panel1.add(btnAEI);
        btnAEI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new allemployee();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        //        Button for  customer info
        JButton btnCI =new JButton("CUSTOMER INFO");
        btnCI.setBounds(30,190,200,30);
        btnCI.setBackground(Color.BLACK);
        btnCI.setForeground(Color.WHITE);
        panel1.add(btnCI);
        btnCI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new customerinfo();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        //        Button for manager info
        JButton btnMI =new JButton("MANAGER INFO");
        btnMI.setBounds(30,230,200,30);
        btnMI.setBackground(Color.BLACK);
        btnMI.setForeground(Color.WHITE);
        panel1.add(btnMI);
        btnMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new managerinfo();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        //        Button for check out
        JButton btnCO =new JButton("CHECK OUT");
        btnCO.setBounds(30,350,200,30);
        btnCO.setBackground(Color.BLACK);
        btnCO.setForeground(Color.WHITE);
        panel1.add(btnCO);
        btnCO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new checkout();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        //        Button for Update check in detailes
        JButton btnUCI =new JButton("UPDATE CHECK-IN DETAILES");
        btnUCI.setBounds(30,310,200,30);
        btnUCI.setBackground(Color.BLACK);
        btnUCI.setForeground(Color.WHITE);
        panel1.add(btnUCI);
        btnUCI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new updatecheckin();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        //        Button for update room status
        JButton btnURS =new JButton("UPDATE ROOM STATUS");
        btnURS.setBounds(30,270,200,30);
        btnURS.setBackground(Color.BLACK);
        btnURS.setForeground(Color.WHITE);
        panel1.add(btnURS);
        btnURS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new updateroom();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        //        Button for pickup service
        JButton btnPS =new JButton("PICK-UP SERVICE");
        btnPS.setBounds(30,390,200,30);
        btnPS.setBackground(Color.BLACK);
        btnPS.setForeground(Color.WHITE);
        panel1.add(btnPS);
        btnPS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new pickup();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

//        Button for search rooms
        JButton btnSR =new JButton("SEARCH ROOMS");
        btnSR.setBounds(30,430,200,30);
        btnSR.setBackground(Color.BLACK);
        btnSR.setForeground(Color.WHITE);
        panel1.add(btnSR);
        btnSR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new searchrooms();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        back = new JButton("Back");
        back.setBounds(135,470,95,33);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        panel1.add(back);

        logout = new JButton("Logout");
        logout.setBounds(30,470,95,33);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.addActionListener(this);
        panel1.add(logout);
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == logout){
                    System.exit(102);
                }
            }
        });


        setBounds(0,0,1950,1080);
//        Background colour
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            new Dashboard();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new reception();
    }
}
