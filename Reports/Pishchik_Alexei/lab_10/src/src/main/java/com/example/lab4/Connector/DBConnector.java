package com.example.lab4.Connector;

import com.example.lab4.Controllers.HelloController;
import com.example.lab4.Controllers.InfoController;
import com.example.lab4.Model.Partments;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnector {
    public static HelloController hellContr;
    public DBConnector(HelloController helloController) throws SQLException, ClassNotFoundException {
        hellContr = helloController;
    }

    public List<Partments> connection() throws ClassNotFoundException, SQLException {
        String  url = "jdbc:mysql://localhost:3306/java", user = "root", passwd  = "root";
        Class.forName("com.mysql.cj.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(url, user, passwd)) {
            System.out.println("Completed!");
            Statement statement = connection.createStatement();
            try {
                List<Partments> list = new ArrayList<>();
                ResultSet result;
                result = statement.executeQuery("SELECT Partments.id, Partments.name, Company.name as COMPANY, Branches.lname as Last, countcomp.count as Count, Adress.adress as ADRESS FROM Partments INNER JOIN " +
                        "Company ON Partments.company = Company.id INNER JOIN " +
                        "Branches ON Partments.branches = Branches.id INNER JOIN " +
                        "countcomp ON Partments.countcomp = countcomp.id INNER JOIN " +
                        "Adress ON Partments.adress = Adress.id");

                while (result.next()) {
                    list.add(new Partments(
                            result.getInt("Partments.id"),
                            result.getString("COMPANY"),
                            result.getString("Partments.name"),
                            result.getString("Last"),
                            result.getString("Count"),
                            result.getString("ADRESS")));
                }
                return list;
            }
            catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
        return null;
    }

    public static List<String> getCompany() throws ClassNotFoundException {
        List<String> list = new ArrayList<>();
        String  url = "jdbc:mysql://localhost:3306/java", user = "root", passwd  = "root";
        Class.forName("com.mysql.cj.jdbc.Driver");
        String sql = "SELECT * FROM Company";
            try(Connection connection = DriverManager.getConnection(url, user, passwd)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){

                list.add(resultSet.getString("name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public static List<String> getAdress() throws ClassNotFoundException {
        List<String> list = new ArrayList<>();
        String  url = "jdbc:mysql://localhost:3306/java", user = "root", passwd  = "root";
        Class.forName("com.mysql.cj.jdbc.Driver");
        String sql = "SELECT * FROM Adress";
        try(Connection connection = DriverManager.getConnection(url, user, passwd)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){

                list.add(resultSet.getString("adress"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public static List<String> getLastName() throws ClassNotFoundException {
        List<String> list = new ArrayList<>();
        String  url = "jdbc:mysql://localhost:3306/java", user = "root", passwd  = "root";
        Class.forName("com.mysql.cj.jdbc.Driver");
        String sql = "SELECT * FROM Branches";
        try(Connection connection = DriverManager.getConnection(url, user, passwd)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){

                list.add(resultSet.getString("lname"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public static List<String> getNumbers() throws ClassNotFoundException {
        List<String> list = new ArrayList<>();
        String  url = "jdbc:mysql://localhost:3306/java", user = "root", passwd  = "root";
        Class.forName("com.mysql.cj.jdbc.Driver");
        String sql = "SELECT * FROM countcomp";
        try(Connection connection = DriverManager.getConnection(url, user, passwd)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                list.add(resultSet.getString("count"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public static void insertPartments(Partments partments) throws ClassNotFoundException {
        String  url = "jdbc:mysql://localhost:3306/java", user = "root", passwd  = "root";
        Class.forName("com.mysql.cj.jdbc.Driver");

        String sql = "insert into Partments (company, name, branches, countcomp, adress) " +
                "values (" +
                "(SELECT id FROM Company where name = ?)" +
                ",(?)," +
                "(SELECT id FROM Branches where lname = ?)," +
                "(SELECT id FROM countcomp where count = ?)," +
                "(SELECT id FROM Adress where adress = ?))";

        try(Connection connection = DriverManager.getConnection(url, user, passwd)) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, partments.getCompanyName());
            preparedStatement.setString(2, partments.getName());
            preparedStatement.setString(3, partments.getLName());
            preparedStatement.setString(4, partments.getNumber());
            preparedStatement.setString(5, partments.getAdress());
            preparedStatement.executeUpdate();
            hellContr.onClickRefresh();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void updatePartments(Partments partments) throws ClassNotFoundException {
        String  url = "jdbc:mysql://localhost:3306/java", user = "root", passwd  = "root";
        Class.forName("com.mysql.cj.jdbc.Driver");
        String sql = "UPDATE Partments SET company = (SELECT id FROM Company where name = ?), " +
                "name = ?, " +
                "branches = (SELECT id FROM Branches where lname = ?), " +
                "countcomp = (SELECT id FROM countcomp where count = ?), " +
                "adress = (SELECT id FROM Adress where adress = ?) " +
                "WHERE id = ?";

        try(Connection connection = DriverManager.getConnection(url, user, passwd)) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, partments.getCompanyName());
            preparedStatement.setString(2, partments.getName());
            preparedStatement.setString(3, partments.getLName());
            preparedStatement.setString(4, partments.getNumber());
            preparedStatement.setString(5, partments.getAdress());
            preparedStatement.setInt(6, partments.getId());
            preparedStatement.executeUpdate();
            hellContr.onClickRefresh();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void getAllInfo(int ID) throws ClassNotFoundException, SQLException {
        String  url = "jdbc:mysql://localhost:3306/java", user = "root", passwd  = "root";
        Class.forName("com.mysql.cj.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(url, user, passwd)) {
            System.out.println("Completed!");
            try {
                ResultSet result;

                String sql = "SELECT Partments.id, Partments.name, Company.name as COMPANY, Branches.nameoffice as nameoffice, Branches.lname as Last, Branches.fname as First, countcomp.count as Count, Adress.adress as ADRESS FROM Partments INNER JOIN " +
                        "Company ON Partments.company = Company.id INNER JOIN " +
                        "Branches ON Partments.branches = Branches.id INNER JOIN " +
                        "countcomp ON Partments.countcomp = countcomp.id INNER JOIN " +
                        "Adress ON Partments.adress = Adress.id WHERE Partments.id = ?";

                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, String.valueOf(ID));
                result = preparedStatement.executeQuery();
                while (result.next()) {
                    InfoController.getData(
                            result.getInt("Partments.id"),
                            result.getString("COMPANY"),
                            result.getString("Partments.name"),
                            result.getString("Last"),
                            result.getString("Count"),
                            result.getString("ADRESS"),
                            result.getString("nameoffice"),
                            result.getString("First"));
                }
            }
            catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public static void deletePartments(int ID) throws ClassNotFoundException {
        String  url = "jdbc:mysql://localhost:3306/java", user = "root", passwd  = "root";
        Class.forName("com.mysql.cj.jdbc.Driver");

        String sql = "DELETE FROM `Partments` WHERE id = ?";

        try(Connection connection = DriverManager.getConnection(url, user, passwd)) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, ID);
            preparedStatement.executeUpdate();
            hellContr.onClickRefresh();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
