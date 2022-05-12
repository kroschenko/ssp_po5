package com.example.lab4.Connector;

import com.example.lab4.Controllers.HelloController;
import com.example.lab4.Model.Info;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnector {
    public static HelloController hellContr;

    public DBConnector(HelloController helloController) throws SQLException, ClassNotFoundException {
        hellContr = helloController;
    }

    public List<Info> connection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/mysql", user = "root", passwd = "root";
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(url, user, passwd)) {
            System.out.println("Completed!");
            Statement statement = connection.createStatement();
            try {
                List<Info> list = new ArrayList<>();
                ResultSet result;
                result = statement.executeQuery("SELECT lab10.info.id_info, lab10.info.date, lab10.path.path as PATH, lab10.type.type as TYPE, lab10.number.number as NUM, lab10.driver.driver as DRIVER FROM lab10.info INNER JOIN " +
                        "lab10.path ON lab10.info.path = lab10.path.idpath INNER JOIN " +
                        "lab10.type ON lab10.info.type = lab10.type.idtype INNER JOIN " +
                        "lab10.number ON lab10.info.number = lab10.number.idnumber INNER JOIN " +
                        "lab10.driver ON lab10.info.driver = lab10.driver.iddriver");

                while (result.next()) {
                    list.add(new Info(
                            result.getInt("info.id_info"),
                            result.getString("PATH"),
                            result.getString("info.date"),
                            result.getString("TYPE"),
                            result.getString("NUM"),
                            result.getString("DRIVER")));
                    System.out.println(result.getInt("info.id_info"));
                    System.out.println(result.getString("PATH"));
                    System.out.println(result.getString("info.date"));
                    System.out.println(result.getString("TYPE"));
                    System.out.println(result.getString("NUM"));
                    System.out.println(result.getString("DRIVER"));
                }

                return list;
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
        return null;
    }

    public static List<String> getPath() throws ClassNotFoundException {
        List<String> list = new ArrayList<>();
        String url = "jdbc:mysql://localhost:3306/mysql", user = "root", passwd = "root";
        Class.forName("com.mysql.cj.jdbc.Driver");
        String sql = "SELECT * FROM `lab10`.`path`";
        try (Connection connection = DriverManager.getConnection(url, user, passwd)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

                list.add(resultSet.getString("path"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public static List<String> getType() throws ClassNotFoundException {
        List<String> list = new ArrayList<>();
        String url = "jdbc:mysql://localhost:3306/mysql", user = "root", passwd = "root";
        Class.forName("com.mysql.cj.jdbc.Driver");
        String sql = "SELECT * FROM `lab10`.`type`";
        try (Connection connection = DriverManager.getConnection(url, user, passwd)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

                list.add(resultSet.getString("type"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public static List<String> getNumber() throws ClassNotFoundException {
        List<String> list = new ArrayList<>();
        String url = "jdbc:mysql://localhost:3306/mysql", user = "root", passwd = "root";
        Class.forName("com.mysql.cj.jdbc.Driver");
        String sql = "SELECT * FROM `lab10`.`number`";
        try (Connection connection = DriverManager.getConnection(url, user, passwd)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

                list.add(resultSet.getString("number"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public static List<String> getDriver() throws ClassNotFoundException {
        List<String> list = new ArrayList<>();
        String url = "jdbc:mysql://localhost:3306/mysql", user = "root", passwd = "root";
        Class.forName("com.mysql.cj.jdbc.Driver");
        String sql = "SELECT * FROM `lab10`.`driver`";
        try (Connection connection = DriverManager.getConnection(url, user, passwd)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                list.add(resultSet.getString("driver"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

        public static void insertInfo(Info info) throws ClassNotFoundException {
        String  url = "jdbc:mysql://localhost:3306/mysql", user = "root", passwd  = "root";
        Class.forName("com.mysql.cj.jdbc.Driver");

        String sql = "insert into `lab10`.`info` (date, path, type, number, driver) " +
                "values ((?),"+
            "(SELECT idpath FROM `lab10`.`path` where path = ?)," +
                "(SELECT idtype FROM `lab10`.`type` where type = ?)," +
                "(SELECT idnumber FROM `lab10`.`number` where number = ?)," +
                "(SELECT iddriver FROM `lab10`.`driver` where driver = ?))";

        try(Connection connection = DriverManager.getConnection(url, user, passwd)) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, info.getDate());
            preparedStatement.setString(2, info.getPath());
            preparedStatement.setString(3, info.getType());
            preparedStatement.setString(4, info.getNumber());
            preparedStatement.setString(5, info.getDriver());
            preparedStatement.executeUpdate();
            hellContr.onClickRefresh();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void updateInfo(Info info) throws ClassNotFoundException {
        String  url = "jdbc:mysql://localhost:3306/mysql", user = "root", passwd  = "root";
        Class.forName("com.mysql.cj.jdbc.Driver");
        String sql = "UPDATE `lab10`.`info` SET `date` = (SELECT `path`.`idpath` FROM `lab10`.`path` where path = ?)," +
                "date = ?," +
                "number = (SELECT idnumber FROM `lab10`.`number` where number = ?), " +
                "type = (SELECT idtype FROM `lab10`.`type` where type = ?), " +
                "driver = (SELECT iddriver FROM `lab10`.`driver` where driver = ?) " +
                "WHERE id_info = ?";

        try(Connection connection = DriverManager.getConnection(url, user, passwd)) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, info.getPath());
            preparedStatement.setString(2, info.getDate());
            preparedStatement.setString(3, info.getNumber());
            preparedStatement.setString(4, info.getType());
            preparedStatement.setString(5, info.getDriver());
            preparedStatement.setInt(6, info.getId_info());
            preparedStatement.executeUpdate();
            hellContr.onClickRefresh();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public static void deleteInfo(int ID) throws ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/mysql", user = "root", passwd = "root";
        Class.forName("com.mysql.cj.jdbc.Driver");

        String sql = "DELETE FROM `lab10`.`info` WHERE id_info = ?";

        try (Connection connection = DriverManager.getConnection(url, user, passwd)) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, ID);
            preparedStatement.executeUpdate();
            hellContr.onClickRefresh();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
