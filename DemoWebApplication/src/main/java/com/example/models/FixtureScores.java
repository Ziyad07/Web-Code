package com.example.models;

import javax.persistence.*;

@Entity(name = "FixtureScores")
@Table
public class FixtureScores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @ManyToOne
    private TeamEntry team1;
    @Column
    private int scoreTeam1;
    @ManyToOne
    private TeamEntry team2;
    @Column
    private int scoreTeam2;
    @Column
    private String leagueNight;

    public FixtureScores(TeamEntry team1, int scoreTeam1, TeamEntry team2, int scoreTeam2, String leagueNight) {
        this.scoreTeam1 = scoreTeam1;
        this.scoreTeam2 = scoreTeam2;
        this.team1 = team1;
        this.team2 = team2;
        this.leagueNight = leagueNight;
    }

    public String getLeagueNight() {
        return leagueNight;
    }

    public int getId() {
        return id;
    }

    public int getScoreTeam1() {
        return scoreTeam1;
    }

    public int getScoreTeam2() {
        return scoreTeam2;
    }

    public TeamEntry getTeam1() {
        return team1;
    }

    public TeamEntry getTeam2() {
        return team2;
    }
}
