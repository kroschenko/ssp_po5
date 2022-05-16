
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Program {
    public static void main(String[] args) {
        Connection dbConnection = null;
        Statement statement = null;
        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();
            insertInTable(statement);
            selectFromTable(statement);
            editOfTable(statement);
            deleteFromTable(statement);
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (dbConnection != null) {
                    dbConnection.close();
                }
            } catch (SQLException e) {
                e.getMessage();
            }
        }
    }

    private static Connection getDBConnection() {
        final String DB_DRIVER, DB_CONNECTION, DB_USER, DB_PASSWORD;
        DB_DRIVER = "com.mysql.cj.jdbc.Driver";
        DB_CONNECTION = "jdbc:mysql://127.0.0.1:3306/java";
        DB_USER = "root";
        DB_PASSWORD = "";
        Connection dbconnection = null;

        try {
            Class.forName(DB_DRIVER);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            dbconnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbconnection;
    }

    private static void selectFromTable(Statement statement) throws SQLException {
        String selectTableSQL = "SELECT * FROM `manufacturers`";
        ResultSet rs = statement.executeQuery(selectTableSQL);   
        while (rs.next()) {
            int man_id = rs.getInt(1);
            String name = rs.getString("name");
            String date = rs.getString(3);
            System.out.println(man_id + ". " + name + " " + date);
        }
    }

    private static void insertInTable(Statement statement) throws SQLException {
        String insertTableSQL = "INSERT `manufacturers`(man_id, name, establish_date) VALUES (1, 'Bosh', CURRENT_DATE())";
        statement.executeUpdate(insertTableSQL);
    }

    private static void editOfTable(Statement statement) throws SQLException {
        String updateTableSQL = "UPDATE `manufacturers` SET name = 'Stihl' WHERE man_id = 1";
        statement.execute(updateTableSQL);
    }

    private static void deleteFromTable(Statement statement) throws SQLException {
        String deleteTableSQL = "DELETE FROM `manufacturers` WHERE man_id = 1";
        statement.execute(deleteTableSQL);
    }

}