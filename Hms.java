package hotel.management.system;

import java.awt.*; // For Get colour in text
import java.awt.event.*; // for buttons actions
import javax.swing.*; //for GUI



public class Hms extends JFrame implements ActionListener{
        
        Hms(){

            super("Elegance suites"); //For giving Title of the Screen

//            Creating Frame Size and splash Screens
            setBounds(0,0,1550,1000);
//            setSize(1500, 700);
//            setLocation(20, 60);
//          alternativly we use only bound function rather than setsize and loaction like
//          setBounds(100, 100, 1366, 565); like this

            setLayout(null); //this is used to Creating own Latouts
            
//            Image Import
            ImageIcon i1=new ImageIcon( ClassLoader.getSystemResource("icons/hotel 4.jpg") );
            JLabel image=new JLabel(i1);
            image.setBounds(0, 0, 1615, 990);  // it take four properties like location X and Y and last Widht, Height
            add(image);

//            Add text(Elegance Group Welcomes you) with help of Jlable
            JLabel text=new JLabel(" ELEGANCE GROUP WELCOME'S YOU ");
            text.setBounds(305, 100, 1000, 90);
            text.setForeground(Color.BLACK); //for colour correction
            text.setFont(new Font("Couture",Font.BOLD, 50 )); //for textt correction
            image.add(text);
            
            
//            For Creating a Next button
                 JButton next=new  JButton("Next");
                 next.setBounds(1350, 700, 115, 38); // Button Coadinates
                 next.setBackground(Color.BLACK);  // Button Colour
                 next.setForeground(Color.WHITE); // Button Text colour next
                 next.addActionListener(this);
                 next.setFont(new Font("Couture",Font.BOLD, 25 )); // "next" font correction
                 image.add(next);

//                 For visible the Screen
            setVisible(true);
            
        }
        //Button Actions
        @Override
        public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                 new login();
        }
          
    public static void main(String[] args) {
        
            Hms h1 = new Hms();   
    }    
}
