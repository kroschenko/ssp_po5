package com.spplab9.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        DBWorker worker = new DBWorker();

        String querySSelect = "select * from teams";
        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(querySSelect);

            while(resultSet.next()) {
                Team team = new Team();
                team.setTeam_id(resultSet.getInt("team_id"));
                team.setLeague_id(resultSet.getInt("league_id"));
                team.setTeam_name(resultSet.getString("team_name"));
                team.setCountry(resultSet.getString("country"));

                System.out.println(team);
            }
            System.out.println("------------------------------------------------------------");

        }catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            Statement statement = worker.getConnection().createStatement();
            statement.execute("INSERT INTO matches(league_name, stadium_name, team1_name, team2_name, match_date) VALUES('Belarusian Premier League', 'Barysaŭ-Arena', 'BATE', 'Dynamo Minsk', '2022.03.01')");
            statement.execute("INSERT INTO matches(league_name, stadium_name, team1_name, team2_name, match_date) VALUES('Belarusian Premier League', 'Barysaŭ-Arena', 'BATE', 'Dynamo Minsk', '2018.01.01')");
        }catch (SQLException e) {
            e.printStackTrace();
        }

        String querySelectSort = "select * from matches order by match_date";
        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(querySelectSort);

            while(resultSet.next()) {
                Match match = new Match();
                match.setMatch_id(resultSet.getInt("match_id"));
                match.setLeague_name(resultSet.getString("league_name"));
                match.setStadium_name(resultSet.getString("stadium_name"));
                match.setTeam1_name(resultSet.getString("team1_name"));
                match.setTeam2_name(resultSet.getString("team2_name"));
                match.setMatch_date(resultSet.getDate("match_date"));

                System.out.println(match);
            }
            System.out.println("------------------------------------------------------------");

        }catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            Statement statement = worker.getConnection().createStatement();
            statement.execute("DELETE FROM matches WHERE match_date = '2018.01.01'");
            statement.execute("UPDATE matches SET match_date = '2022.07.01' WHERE match_date = '2022.03.01'");

            ResultSet resultSet = statement.executeQuery(querySelectSort);

            while(resultSet.next()) {
                Match match = new Match();
                match.setMatch_id(resultSet.getInt("match_id"));
                match.setLeague_name(resultSet.getString("league_name"));
                match.setStadium_name(resultSet.getString("stadium_name"));
                match.setTeam1_name(resultSet.getString("team1_name"));
                match.setTeam2_name(resultSet.getString("team2_name"));
                match.setMatch_date(resultSet.getDate("match_date"));

                System.out.println(match);
            }
            System.out.println("------------------------------------------------------------");

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

