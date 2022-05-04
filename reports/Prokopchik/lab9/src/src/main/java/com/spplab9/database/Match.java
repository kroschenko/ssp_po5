package com.spplab9.database;

import java.sql.Date;

public class Match {

    private int match_id;
    private String league_name;
    private String stadium_name;
    private String team1_name;
    private String team2_name;
    private Date match_date;

    public Match(){

    }

    public Match(String league_name, String stadium_name, String team1_name, String team2_name, Date match_date){

        this.league_name = league_name;
        this.stadium_name = stadium_name;
        this.team1_name = team1_name;
        this.team2_name = team2_name;
        this.match_date = match_date;
    }

    public Match(int match_id, String league_name, String stadium_name, String team1_name, String team2_name, Date match_date ){

        this.match_id = match_id;
        this.league_name = league_name;
        this.stadium_name = stadium_name;
        this.team1_name = team1_name;
        this.team2_name = team2_name;
        this.match_date = match_date;
    }

    public int getMatch_id() {return match_id;}
    public void setMatch_id(int match_id) {this.match_id = match_id;}

    public String getLeague_name() {return league_name;}
    public void setLeague_name(String league_name) {this.league_name = league_name;}

    public String getStadium_name() {return stadium_name;}
    public void setStadium_name(String stadium_name) {this.stadium_name = stadium_name;}

    public String getTeam1_name() {return team1_name;}
    public void setTeam1_name(String team1_name) {this.team1_name = team1_name;}

    public String getTeam2_name() {return team2_name;}
    public void setTeam2_name(String team2_name) {this.team2_name = team2_name;}

    public Date getMatch_date() {return match_date;}
    public void setMatch_date(Date match_date) {this.match_date = match_date;}

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{id: " + match_id
                + ", league_name: " + league_name
                + ", stadium_name: " + stadium_name
                + ", team1_name: " + team1_name
                + ", team2_name: " + team2_name
                + ", match_date: " + match_date
                + "}";
    }
}

