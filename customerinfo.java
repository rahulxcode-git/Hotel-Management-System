package hotel.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class customerinfo extends JFrame implements ActionListener {

    JButton back;

    customerinfo(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,990,590);
        panel.setBackground(new Color(41,54,36));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(0,45,1000,350);
        table.setBackground(new Color(41,54,36));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try{
            conndb c = new conndb();
            String departmentinfo = "select * from customer";
            ResultSet resultSet = c.statement.executeQuery(departmentinfo);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

            // Auto resize column width based on content
            TableColumnModel columnModel = table.getColumnModel();
            for (int i = 0; i < columnModel.getColumnCount(); i++) {
                TableColumn column = columnModel.getColumn(i);
                int width = 15; // Min width
                for (int j = 0; j < table.getRowCount(); j++) {
                    TableCellRenderer renderer = table.getCellRenderer(j, i);
                    Component comp = table.prepareRenderer(renderer, j, i);
                    width = Math.max(comp.getPreferredSize().width + 1, width);
                }
                column.setPreferredWidth(width);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel ename = new JLabel("Verification ID");
        ename.setBounds(5,15,150,19);
        ename.setForeground(Color.WHITE);
        ename.setFont(new Font("Couture",Font.BOLD,14));
        panel.add(ename);

        JLabel age = new JLabel("Contact no.");
        age.setBounds(132,15,80,19);
        age.setForeground(Color.WHITE);
        age.setFont(new Font("Couture",Font.BOLD,14));
        panel.add(age);

        JLabel gender = new JLabel("Name");
        gender.setBounds(255,15,150,19);
        gender.setForeground(Color.WHITE);
        gender.setFont(new Font("Couture",Font.BOLD,14));
        panel.add(gender);

        JLabel position = new JLabel("Gender");
        position.setBounds(420,15,80,19);
        position.setForeground(Color.WHITE);
        position.setFont(new Font("Couture",Font.BOLD,14));
        panel.add(position);

        JLabel salary = new JLabel("Room no.");
        salary.setBounds(500,15,150,19);
        salary.setForeground(Color.WHITE);
        salary.setFont(new Font("Couture",Font.BOLD,14));
        panel.add(salary);

        JLabel phone = new JLabel("Country");
        phone.setBounds(580,15,150,19);
        phone.setForeground(Color.WHITE);
        phone.setFont(new Font("Couture",Font.BOLD,14));
        panel.add(phone);

        JLabel gmail = new JLabel("Date");
        gmail.setBounds(700,15,80,19);
        gmail.setForeground(Color.WHITE);
        gmail.setFont(new Font("Couture",Font.BOLD,14));
        panel.add(gmail);

        JLabel aadhar = new JLabel("Deposite");
        aadhar.setBounds(920,15,150,19);
        aadhar.setForeground(Color.WHITE);
        aadhar.setFont(new Font("Couture",Font.BOLD,14));
        panel.add(aadhar);

        back = new JButton("Back");
        back.setBounds(400, 500, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        panel.add(back);

        setUndecorated(true);
        setBounds(500,100,1000,600);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back){
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new customerinfo();
    }
}
