package models;

import java.io.Serializable;
public class MatchData implements Serializable {
    String teamOne;
    String teamTwo;
    int teamOneGoals;
    int teamTwoGoals;
    Date date;

    public MatchData(){};

    public MatchData(String teamOne, String teamTwo, int teamOneGoals, int teamTwoGoals, Date date) {
        this.teamOne = teamOne;
        this.teamTwo = teamTwo;
        this.teamOneGoals = teamOneGoals;
        this.teamTwoGoals = teamTwoGoals;
        this.date = date;
    }

    public String getTeamOne() {
        return teamOne;
    }

    public void setTeamOne(String teamOne) {
        this.teamOne = teamOne;
    }

    public String getTeamTwo() {
        return teamTwo;
    }

    public void setTeamTwo(String teamTwo) {
        this.teamTwo = teamTwo;
    }

    public int getTeamOneGoals() {
        return teamOneGoals;
    }

    public void setTeamOneGoals(int teamOneGoals) {
        this.teamOneGoals = teamOneGoals;
    }

    public int getTeamTwoGoals() {
        return teamTwoGoals;
    }

    public void setTeamTwoGoals(int teamTwoGoals) {
        this.teamTwoGoals = teamTwoGoals;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

