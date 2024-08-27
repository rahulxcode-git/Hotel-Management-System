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

public class pickup extends JFrame implements ActionListener {

    Choice choice;
    JTable table;
    JButton back,display;

    pickup(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,990,590);
        panel.setBackground(new Color(41,54,36));
        panel.setLayout(null);
        add(panel);

        JLabel pickup = new JLabel("Pick-Up Service");
        pickup.setBounds(420, 11, 300, 31);
        pickup.setForeground(Color.WHITE);
        pickup.setFont(new Font("Couture", Font.BOLD, 25));
        pickup.setLayout(null);
        panel.add(pickup);

        JLabel toc = new JLabel("Type of Car:");
        toc.setBounds(50, 70, 100, 25);
        toc.setForeground(Color.WHITE);
        toc.setFont(new Font("Couture", Font.BOLD, 16));
        toc.setLayout(null);
        panel.add(toc);

        choice = new Choice();
        choice.setBounds(160,72,150,25);
        choice.setFont(new Font("Couture", Font.BOLD, 14));
        choice.setForeground(Color.WHITE);
        choice.setBackground(new Color(63, 82, 55, 255));
        panel.add(choice);

        try {
            conndb c = new conndb();
            String q = "select * from driver";
            ResultSet resultSet = c.statement.executeQuery(q);
            while (resultSet.next()){
                choice.add(resultSet.getString("carname"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JTable table = new JTable();
        table.setBounds(5,233,1000,250);
        table.setBackground(new Color(41,54,36));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try{
            conndb c = new conndb();
            String q1 = "select * from driver";
            ResultSet resultSet = c.statement.executeQuery(q1);
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

        JLabel name = new JLabel("Name");
        name.setBounds(5,205,150,19);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("Couture",Font.BOLD,14));
        panel.add(name);

        JLabel age = new JLabel("Age");
        age.setBounds(132,205,80,19);
        age.setForeground(Color.WHITE);
        age.setFont(new Font("Couture",Font.BOLD,14));
        panel.add(age);

        JLabel carcom = new JLabel("Car Company");
        carcom.setBounds(230,205,150,19);
        carcom.setForeground(Color.WHITE);
        carcom.setFont(new Font("Couture",Font.BOLD,14));
        panel.add(carcom);

        JLabel carname = new JLabel("Car Name");
        carname.setBounds(420,205,80,19);
        carname.setForeground(Color.WHITE);
        carname.setFont(new Font("Couture",Font.BOLD,14));
        panel.add(carname);

        JLabel location = new JLabel("Location");
        location.setBounds(590,205,150,19);
        location.setForeground(Color.WHITE);
        location.setFont(new Font("Couture",Font.BOLD,14));
        panel.add(location);

        JLabel ava = new JLabel("Availability");
        ava.setBounds(775,205,150,19);
        ava.setForeground(Color.WHITE);
        ava.setFont(new Font("Couture",Font.BOLD,14));
        panel.add(ava);

        JLabel gender1 = new JLabel("Gender");
        gender1.setBounds(885,205,80,19);
        gender1.setForeground(Color.WHITE);
        gender1.setFont(new Font("Couture",Font.BOLD,14));
        panel.add(gender1);

        display = new JButton("Display");
        display.setBounds(400, 500, 120, 30);
        display.setBackground(Color.BLACK);
        display.setForeground(Color.WHITE);
        display.addActionListener(this);
        panel.add(display);
        display.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q = "select * from driver where carname = '"+choice.getSelectedItem()+"' ";
                try {

                    conndb c = new conndb();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));

                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });



        back = new JButton("Back");
        back.setBounds(540, 500, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setBounds(500,100,1000,600);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new pickup();
    }
}
