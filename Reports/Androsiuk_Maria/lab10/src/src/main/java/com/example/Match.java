package com.example;

import java.sql.Date;

public final class Match {
    private Integer id;
    private String league;
    private String stadium;
    private Date date;
    private String team1;
    private String team2;

    public Match(final Integer id, final String league, final String stadium, final Date date,
                 final String team1, final String team2) {
        this.id = id;
        this.league = league;
        this.stadium = stadium;
        this.date = date;
        this.team1 = team1;
        this.team2 = team2;
    }

    public final Integer getId() {
        return this.id;
    }

    public final void setId(final Integer id) {
        this.id = id;
    }

    public final String getLeague() {
        return this.league;
    }

    public final void setLeague(final String league) {
        this.league = league;
    }

    public final String getStadium() {
        return this.stadium;
    }

    public final void setStadium(final String stadium) {
        this.stadium = stadium;
    }

    public final Date getDate() {
        return this.date;
    }

    public final void setDate(final Date date) {
        this.date = date;
    }

    public final String getTeam1() {
        return this.team1;
    }

    public final void setTeam1(final String team1) {
        this.team1 = team1;
    }

    public final String getTeam2() {
        return this.team2;
    }

    public final void setTeam2(final String team2) {
        this.team2 = team2;
    }
}
