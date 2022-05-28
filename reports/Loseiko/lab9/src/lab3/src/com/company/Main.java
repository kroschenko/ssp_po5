package com.company;

import java.sql.*;

public class Main {

    public static final String userName = "root";
    public static final String password = "root";
    public static final String connectionURL = "jdbc:mysql://localhost:3306/mysql";

    public static void main(String[] args) throws SQLException {
        String query="INSERT INTO lab9.train_driver (FirstName, LastName, Patronymic) VALUES ('Павел', 'Павлов','Павлович');";
        String query2="DELETE FROM lab9.train_driver WHERE (FirstName='Павел');";
        String query3="UPDATE lab9.train_driver SET FirstName='Василий',LastName='Васильев', Patronymic='Васильевич' WHERE (FirstName='Павел');";
        String query4="SELECT * FROM lab9.train_driver;";
       // String query22="INSERT INTO lab9.route (RouteNumber, Time,idPath, idTrain, idTrain_driver,idTrain_type ) VALUES ('444','29.03.2022','1','1','1','1');";
        try(Connection connection = DriverManager.getConnection(connectionURL, userName, password)){
            if(connection.isValid(30)){
                Statement statement = connection.createStatement();
                //statement.execute(query3);
                ResultSet resultSet = statement.executeQuery(query4);
                while(resultSet.next()){
                    System.out.print("Имя: "+resultSet.getString("FirstName")+" ");
                    System.out.print("Фамилия: "+resultSet.getString("LastName")+" ");
                    System.out.println("Отчество: "+resultSet.getString("Patronymic"));
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
