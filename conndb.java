package hotel.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

class conndb {
    Connection connection;
    Statement statement;

    conndb(){
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelms", "root","rahul8780");
            statement = connection.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}