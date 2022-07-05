import Model.Bus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ManagerDB {
    final static String HOST_DB = "localhost";
    final static String USER_DB = "admin";
    final static String PASSWORD_DB = "root";
    final static String NAME_DB = "SPP";

    public static Connection connectDB() {
        Connection conn = null;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://" + HOST_DB + ":3306/" + NAME_DB, USER_DB, PASSWORD_DB);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return conn;
    }

    public static void addElement(Connection conn, Bus bus) {
        String commandSQL = "INSERT INTO `bus`(`fio`, `auto_number`, `route_number`, `brand`, `year_operation`, `mileage`, `location`) VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement statement = conn.prepareStatement(commandSQL);
            statement.setString(1, bus.getFIO());
            statement.setString(2, bus.getAutoNumber());
            statement.setString(3, bus.getRouteNumber());
            statement.setString(4, bus.getBrand());
            statement.setInt(5, bus.getYearOperation());
            statement.setLong(6, bus.getMileage());
            statement.setString(7, bus.getLocation());
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Bus> selectTable(Connection conn, String nameTable) {
            List<Bus> buses = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT * FROM " + nameTable);
            while(resultSet.next()){
                buses.add(
                    new Bus(
                    resultSet.getString(2), 
                    resultSet.getString(3), 
                    resultSet.getString(6), 
                    resultSet.getString(4),
                    resultSet.getInt(7), 
                    resultSet.getLong(5),  
                    resultSet.getString(8)));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }  
        return buses;
    }
}



