package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Dashboard extends JFrame implements ActionListener{
    
//    globally declare buttons
      JButton add/*Admin*/,rec/*Reception*/;
    Dashboard(){
        
        super("Elegance suites");
//      Screen Size
        setBounds(0,0,1950,1090);
        setLayout(null);



//        Reception Button
        rec=new JButton("RECEPTION");
        rec.setBounds(425,510,140,30);
        rec.setFont(new Font("Couture",Font.BOLD, 15 ));
        rec.setBackground(Color.decode("#293624"));
        rec.setForeground(Color.WHITE);
        rec.addActionListener(this);
        add(rec);

//        Admin Button
        add=new JButton("ADMIN");
        add.setBounds(880,510,140,30);
        add.setFont(new Font("Couture",Font.BOLD, 15 ));
        add.setBackground(Color.decode("#293624"));
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

//        admin PNG
        ImageIcon boss=new ImageIcon( ClassLoader.getSystemResource("icons/boss.png") );
        Image i2= boss.getImage().getScaledInstance(200,195,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1b=new ImageIcon(i2);
        JLabel labelb=new JLabel(imageIcon1b);
        labelb.setBounds(850,300,200,195);
        add(labelb);

//        Reception PNG
        ImageIcon reception=new ImageIcon( ClassLoader.getSystemResource("icons/Reception.png") );
        Image i3= reception.getImage().getScaledInstance(200,195,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1r=new ImageIcon(i3);
        JLabel labelr=new JLabel(imageIcon1r);
        labelr.setBounds(400,300,200,195);
        add(labelr);

//        For BackGround Video
        ImageIcon imageicon=new ImageIcon( ClassLoader.getSystemResource("icons/drone.gif") );
        Image i1= imageicon.getImage().getScaledInstance(1950,1090,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(i1);
        JLabel label=new JLabel(imageIcon1);
        label.setBounds(0,0,1950,1090);
        add(label);
        

        setVisible(true);
    }
//    Reception Button Actions

            @Override
        public void actionPerformed(ActionEvent e) {
                setVisible(false);
                if (e.getSource() == rec) {
            setVisible(false);
                    new reception();
                }else {
                    new login2();
                    setVisible(false);
                }
       }
        
    public static void main(String[] args) {
        new Dashboard();
    }
}

