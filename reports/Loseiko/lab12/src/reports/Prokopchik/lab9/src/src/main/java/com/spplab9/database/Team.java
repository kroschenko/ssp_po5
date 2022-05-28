package com.spplab9.database;

public class Team {

    private int team_id;
    private int league_id;
    private String team_name;
    private String country;

    public Team() {
    }

    public Team(int league_id, String team_name, String country) {
        this.league_id = league_id;
        this.team_name = team_name;
        this.country = country;
    }

    public Team(int team_id, int league_id, String team_name, String country) {
        this.team_id = team_id;
        this.league_id = league_id;
        this.team_name = team_name;
        this.country = country;
    }

    public int getTeam_id() {return team_id;}
    public void setTeam_id(int team_id) {this.team_id = team_id;}

    public int getLeague_id() {return league_id;}
    public void setLeague_id(int league_id) {this.league_id = league_id;}

    public String getTeam_name() {return team_name;}
    public void setTeam_name(String team_name) {this.team_name = team_name;}

    public String getCountry() {return country;}
    public void setCountry(String country) {this.country = country;}

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{id: " + team_id
                + ", league_id: " + league_id
                + ", team_name: " + team_name
                + ", country: " + country
                + "}";
    }
}
