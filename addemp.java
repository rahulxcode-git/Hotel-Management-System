package hotel.management.system;
//41,54,36
//63, 82, 55, 255
//5,5,890,490
//Couture

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addemp extends JFrame implements ActionListener {

    JTextField nameText,ageText,salText,phoneText,aaText,emailText;
//    JRadioButton radioButtonm,radioButtonf;
    JComboBox jobbutton,genderbutton;
    JButton back,add;
    addemp(){


        JPanel panel=new JPanel();
        panel.setBackground(new Color(41,54,36));
        panel.setBounds(5,5,875,490);
        panel.setLayout(null);
        add(panel);

        JLabel name=new JLabel("Name");
        name.setBounds(60,30,150,27);
        name.setFont(new Font("Couture",Font.BOLD,17));
        name.setForeground(Color.WHITE);
        panel.add(name);
        nameText = new JTextField();
        nameText.setBounds(200,30,150,27);
        nameText.setBackground(new Color(63, 82, 55, 255));
        nameText.setFont(new Font("Couture",Font.PLAIN,14));
        nameText.setForeground(Color.WHITE);
        panel.add(nameText);

        JLabel Age=new JLabel("Age");
        Age.setBounds(60,80,150,27);
        Age.setFont(new Font("Couture",Font.BOLD,17));
        Age.setForeground(Color.WHITE);
        panel.add(Age);
        ageText = new JTextField();
        ageText.setBounds(200,80,150,27);
        ageText.setBackground(new Color(63, 82, 55, 255));
        ageText.setFont(new Font("Couture",Font.PLAIN,14));
        ageText.setForeground(Color.WHITE);
        panel.add(ageText);


        JLabel Gender=new JLabel("Gender");
        Gender.setBounds(60,120,150,27);
        Gender.setFont(new Font("Couture",Font.BOLD,17));
        Gender.setForeground(Color.WHITE);
        panel.add(Gender);
        genderbutton = new JComboBox(new String[] {"male","Female"});
        genderbutton.setBounds(200,120,150,27);
        genderbutton.setBackground(new Color(63, 82, 55, 255));
        genderbutton.setFont(new Font("Couture",Font.PLAIN,14));
        genderbutton.setForeground(Color.WHITE);
        panel.add(genderbutton);

//        radioButtonm =new JRadioButton("Male");
//        radioButtonm.setBounds(200,120,70,27);
//        radioButtonm.setBackground(new Color(41,54,36));
//        radioButtonm.setFont(new Font("Couture",Font.BOLD,14));
//        radioButtonm.setForeground(Color.WHITE);
//        panel.add(radioButtonm);

//        radioButtonf =new JRadioButton("Female");
//        radioButtonf.setBounds(280,120,100,27);
//        radioButtonf.setBackground(new Color(41,54,36));
//        radioButtonf.setFont(new Font("Couture",Font.BOLD,14));
//        radioButtonf.setForeground(Color.WHITE);
//        panel.add(radioButtonf);

        JLabel job=new JLabel("Job");
        job.setBounds(60,170,150,27);
        job.setFont(new Font("Couture",Font.BOLD,17));
        job.setForeground(Color.WHITE);
        panel.add(job);
        jobbutton = new JComboBox(new String[] {"Front Desk","Housekeeping","Kitchan Staff","Room Service","Manager","Accountant","Chef"});
        jobbutton.setBounds(200,170,150,27);
        jobbutton.setBackground(new Color(63, 82, 55, 255));
        jobbutton.setFont(new Font("Couture",Font.PLAIN,14));
        jobbutton.setForeground(Color.WHITE);
        panel.add(jobbutton);



        JLabel salary=new JLabel("Salary");
        salary.setBounds(60,220,150,27);
        salary.setFont(new Font("Couture",Font.BOLD,17));
        salary.setForeground(Color.WHITE);
        panel.add(salary);
        salText = new JTextField();
        salText.setBounds(200,220,150,27);
        salText.setBackground(new Color(63, 82, 55, 255));
        salText.setFont(new Font("Couture",Font.PLAIN,14));
        salText.setForeground(Color.WHITE);
        panel.add(salText);

        JLabel phone=new JLabel("Phone");
        phone.setBounds(60,270,150,27);
        phone.setFont(new Font("Couture",Font.BOLD,17));
        phone.setForeground(Color.WHITE);
        panel.add(phone);
        phoneText = new JTextField();
        phoneText.setBounds(200,270,150,27);
        phoneText.setBackground(new Color(63, 82, 55, 255));
        phoneText.setFont(new Font("Couture",Font.PLAIN,14));
        phoneText.setForeground(Color.WHITE);
        panel.add(phoneText);

        JLabel aadhar=new JLabel("Aadhar no.");
        aadhar.setBounds(60,320,150,27);
        aadhar.setFont(new Font("Couture",Font.BOLD,17));
        aadhar.setForeground(Color.WHITE);
        panel.add(aadhar);
        aaText = new JTextField();
        aaText.setBounds(200,320,150,27);
        aaText.setBackground(new Color(63, 82, 55, 255));
        aaText.setFont(new Font("Couture",Font.PLAIN,14));
        aaText.setForeground(Color.WHITE);
        panel.add(aaText);

        JLabel email=new JLabel("Email");
        email.setBounds(60,370,150,27);
        email.setFont(new Font("Couture",Font.BOLD,17));
        email.setForeground(Color.WHITE);
        panel.add(email);
        emailText = new JTextField();
        emailText.setBounds(200,370,150,27);
        emailText.setBackground(new Color(63, 82, 55, 255));
        emailText.setFont(new Font("Couture",Font.PLAIN,14));
        emailText.setForeground(Color.WHITE);
        panel.add(emailText);

        JLabel AED = new JLabel("ADD EMPLOYEE DETAILS");
        AED.setBounds(450,24,455,35);
        AED.setFont(new Font("Couture",Font.BOLD,31));
        AED.setForeground(Color.WHITE);
        panel.add(AED);

        ImageIcon imageIcon= new ImageIcon(ClassLoader.getSystemResource("icons/addemp.png"));
        Image image = imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500,100,300,300);
        panel.add(label);

        add=new JButton("Add");
        add.setBounds(198,420,111,33);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        panel.add(add);

        back=new JButton("Back");
        back.setBounds(64,420,111,33);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        panel.add(back);



        setUndecorated(true);
        setBounds(20,200,885,500);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == add ){


                String name = nameText.getText();
                String age= ageText.getText();
                String salary = salText.getText();
                String phone = phoneText.getText();
                String aadhar = aaText.getText();
                String email = emailText.getText();
                String job = (String) jobbutton.getSelectedItem();
                String gender = (String) genderbutton.getSelectedItem();

//                if(radioButtonm.isSelected()){
//                    gender = "Male";
//                } else if (radioButtonf.isSelected()) {
//                    gender = "Female";
//                }

                try{


                conndb c=new conndb();
                String q = "insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+aadhar+"')";
                c.statement.executeUpdate(q);

                JOptionPane.showMessageDialog(null,"Detailes Added Succesfully ");
                this.setVisible(false);

            }catch (Exception E){
                E.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new addemp();
    }
}
