package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class newcustomer extends JFrame implements ActionListener {

    JTextField notext,nametext,countrytext,depositetext;
    JLabel id,no,name,gender,country,ARN,checkin,deposite,date;
    JComboBox lid,lgender;
    Choice c1;
    JButton back,submit;

    newcustomer(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,840,590);
        panel.setBackground(new Color(41,54,36));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/customer.png"));
        Image image= imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageicon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageicon1);
        label.setBounds(550,150,200,200);
        panel.add(label);

        JLabel name = new JLabel("NEW CUSTOMER FORM");
        name.setBounds(260,11,260,53);
        name.setFont(new Font("Couture",Font.BOLD,20));
        name.setForeground(Color.WHITE);
        panel.add(name);

        id = new JLabel("ID:");
        id.setBounds(35,76,200,14);
        id.setFont(new Font("Couture",Font.BOLD,15));
        id.setForeground(Color.WHITE);
        panel.add(id);
        lid = new JComboBox(new String[] {"Passport","Aadhar-Card","Voter-ID","Driving-Licence"});
        lid.setBounds(271,76,150,20);
        lid.setFont(new Font("Couture",Font.BOLD,15));
        lid.setBackground(new Color(63, 82, 55, 255));
        lid.setForeground(Color.WHITE);
        panel.add(lid);


        no = new JLabel("Number:");
        no.setBounds(35,126,200,14);
        no.setFont(new Font("Couture",Font.BOLD,15));
        no.setForeground(Color.WHITE);
        panel.add(no);
        notext = new JTextField();
        notext.setBounds(271,126,150,20);
        notext.setFont(new Font("Couture",Font.BOLD,15));
        notext.setBackground(new Color(63, 82, 55, 255));
        notext.setForeground(Color.WHITE);
        panel.add(notext);

        name = new JLabel("Name:");
        name.setBounds(35,176,200,14);
        name.setFont(new Font("Couture",Font.BOLD,15));
        name.setForeground(Color.WHITE);
        panel.add(name);
        nametext = new JTextField();
        nametext.setBounds(271,176,150,20);
        nametext.setFont(new Font("Couture",Font.BOLD,15));
        nametext.setBackground(new Color(63, 82, 55, 255));
        nametext.setForeground(Color.WHITE);
        panel.add(nametext);

        gender = new JLabel("Gender:");
        gender.setBounds(35,227,200,14);
        gender.setFont(new Font("Couture",Font.BOLD,15));
        gender.setForeground(Color.WHITE);
        panel.add(gender);
        lgender = new JComboBox(new String[] {"Male","Female","Other"});
        lgender.setBounds(271,227,150,20);
        lgender.setFont(new Font("Couture",Font.BOLD,15));
        lgender.setBackground(new Color(63, 82, 55, 255));
        lgender.setForeground(Color.WHITE);
        panel.add(lgender);

        country = new JLabel("Country:");
        country.setBounds(35,277,200,18);
        country.setFont(new Font("Couture",Font.BOLD,15));
        country.setForeground(Color.WHITE);
        panel.add(country);
        countrytext = new JTextField();
        countrytext.setBounds(271,277,150,20);
        countrytext.setFont(new Font("Couture",Font.BOLD,15));
        countrytext.setBackground(new Color(63, 82, 55, 255));
        countrytext.setForeground(Color.WHITE);
        panel.add(countrytext);

        ARN = new JLabel("Allocated Room Number:");
        ARN.setBounds(35,327,200,14);
        ARN.setFont(new Font("Couture",Font.BOLD,15));
        ARN.setForeground(Color.WHITE);
        panel.add(ARN);

        c1 = new Choice();
        try{

            conndb c = new conndb();
            ResultSet resultSet = c.statement.executeQuery("select * from room");
            while (resultSet.next()){
                c1.add(resultSet.getString("roomno"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        c1.setBounds(271,327,150,20);
        c1.setFont(new Font("Couture",Font.BOLD,15));
        c1.setForeground(Color.WHITE);
        c1.setBackground(new Color(63, 82, 55, 255));
        panel.add(c1);

        checkin = new JLabel("Checked-IN:");
        checkin.setBounds(35,376,200,14);
        checkin.setFont(new Font("Couture",Font.BOLD,15));
        checkin.setForeground(Color.WHITE);
        panel.add(checkin);
        Date date1 = new Date();
        date = new JLabel(""+date1);
        date.setBounds(271,376,150,19);
        date.setFont(new Font("Couture",Font.BOLD,15));
        date.setForeground(Color.WHITE);
        panel.add(date);

        deposite = new JLabel("Deposite:");
        deposite.setBounds(35,426,200,14);
        deposite.setFont(new Font("Couture",Font.BOLD,15));
        deposite.setForeground(Color.WHITE);
        panel.add(deposite);
        depositetext = new JTextField();
        depositetext.setBounds(271,426,150,20);
        depositetext.setFont(new Font("Couture",Font.BOLD,15));
        depositetext.setBackground(new Color(63, 82, 55, 255));
        depositetext.setForeground(Color.WHITE);
        panel.add(depositetext);

        back = new JButton("Back");
        back.setBounds(64,495,111,33);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        panel.add(back);

        submit = new JButton("Submit");
        submit.setBounds(200,495,111,33);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        panel.add(submit);

        setUndecorated(true);
        setBounds(500,150,850,600);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit ){

                conndb c=new conndb();

                String gid= (String) lid.getSelectedItem();
                String num= notext.getText();
                String name= nametext.getText();
                String gender= (String) lgender.getSelectedItem();
                String country = countrytext.getText();
                String arn = c1.getSelectedItem();
                String date1 = date.getText();
                String deposite = depositetext.getText();

            try{

                String q = "insert into customer (id, number, name, gender, arn, country, checkin, deposit) values ('" + gid + "','" + num + "','" + name + "','" + gender + "','" + arn + "','" + country + "','" + date1 + "','" + deposite + "')";
                String q1 = "update room set availability = 'Occupied' where roomno = "+arn;
                c.statement.executeUpdate(q);
                c.statement.executeUpdate(q1);
                JOptionPane.showMessageDialog(null,"Customer Added");
                this.setVisible(false);

            }catch (Exception E){
                E.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new newcustomer();
    }
}
