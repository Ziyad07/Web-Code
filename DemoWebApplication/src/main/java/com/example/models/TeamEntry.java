package com.example.models;

import javax.persistence.*;

@Entity(name = "TeamDetails")
@Table
public class TeamEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String name;
    @Column
    private String leagueNight;
    @Column
    private int goalDiff = 0;
    @Column
    private int gamesPlayed = 0;
    @Column
    private int points = 0;
    @Column
    private int goalsFor = 0;
    @Column
    private int goalsAgainst = 0;
    @Column
    private String status;
    @Column
    private int wins;
    @Column
    private int draws;
    @Column
    private int loses;

    public void setWins(int wins) {
        this.wins = getWins() + wins;
    }

    public void setDraws(int draws) {
        this.draws = getDraws() + draws;
    }

    public void setLoses(int loses) {
        this.loses = getLoses() + loses;
    }

    public int getWins() {

        return wins;
    }

    public int getDraws() {
        return draws;
    }

    public int getLoses() {
        return loses;
    }

    public TeamEntry() {
    }

    public TeamEntry(String name, String leagueNight) {
        this.name = name;
        this.leagueNight = leagueNight;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setGoalDiff(int goalDiff) {
        this.goalDiff = getGoalDiff() + goalDiff;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = getGamesPlayed() + gamesPlayed;
    }

    public void setPoints(int points) {
        this.points = getPoints() + points;
    }

    public void setGoalsFor(int goalsFor) {
        this.goalsFor = getGoalsFor() + goalsFor;
    }

    public void setGoalsAgainst(int goalsAgainst) {
        this.goalsAgainst = getGoalsAgainst() + goalsAgainst;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLeagueNight() {
        return leagueNight;
    }

    public int getGoalDiff() {
        return goalDiff;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public int getPoints() {
        return points;
    }

    public int getGoalsFor() {
        return goalsFor;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }
}
