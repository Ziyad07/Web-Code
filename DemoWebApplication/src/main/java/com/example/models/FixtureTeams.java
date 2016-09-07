package com.example.models;

import javax.persistence.*;

@Entity(name = "FixtureTeams")
@Table
public class FixtureTeams {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @ManyToOne
    private TeamEntry team1;
    @ManyToOne
    private TeamEntry team2;
    @Column
    private String leagueNight;
    @Column
    private boolean alreadyPlayed;

    public FixtureTeams(TeamEntry team1, TeamEntry team2, String leagueNight) {
        this.team1 = team1;
        this.team2 = team2;
        this.leagueNight = leagueNight;
    }

    public FixtureTeams() {
    }

    public String getLeagueNight() {
        return leagueNight;
    }

    public int getId() {
        return id;
    }

    public void setAlreadyPlayed(boolean alreadyPlayed) {
        this.alreadyPlayed = alreadyPlayed;
    }

    public TeamEntry getTeam1() {
        return team1;
    }

    public TeamEntry getTeam2() {
        return team2;
    }

    public boolean isAlreadyPlayed() {
        return alreadyPlayed;
    }
}
