import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String  url = "jdbc:mysql://localhost:3306/java", user = "root", passwd  = "root";
        Class.forName("com.mysql.cj.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(url, user, passwd)) {
            System.out.println("Completed!");
            Statement statement = connection.createStatement();
            try {
                ResultSet result;
                result = statement.executeQuery("SELECT * FROM `Company` WHERE 1");

                while (result.next()) {
                    String name = result.getString("Company.name");
                    System.out.println(
                            result.getString("Company.id") +
                                    " " + result.getString("Company.name")
                                    + " " + name);
                }
            }
            catch (Exception exception) {
                System.out.println(exception);
            }
        }
    }

    public void createSourceDB() { }
}
