package hotel.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.DatagramPacket;
import java.sql.ResultSet;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class department extends JFrame implements ActionListener {

    department(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,990,590);
        panel.setBackground(new Color(41,54,36));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(0,40,1000,350);
        table.setBackground(new Color(41,54,36));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try{
            conndb c = new conndb();
            String departmentinfo = "select * from department";
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

        JButton back = new JButton("Back");
        back.setBounds(400,520,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        JLabel dep = new JLabel("Department");
        dep.setBounds(7,15,150,19);
        dep.setForeground(Color.WHITE);
        dep.setFont(new Font("Couture",Font.BOLD,14));
        panel.add(dep);

        JLabel function = new JLabel("Function");
        function.setBounds(265,15,80,19);
        function.setForeground(Color.WHITE);
        function.setFont(new Font("Couture",Font.BOLD,14));
        panel.add(function);

        JLabel budget = new JLabel("Budget");
        budget.setBounds(810,15,150,19);
        budget.setForeground(Color.WHITE);
        budget.setFont(new Font("Couture",Font.BOLD,14));
        panel.add(budget);

        setUndecorated(true);
        setBounds(500,100,1000,600);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new department();
    }
}
