package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class FootballClubTest {

    FootballClub footballClub = new FootballClub("Galle Gladiators", "Galle", 6, 3, 7, 9, 2 );

    @Test
    public void getWins() {
        assertEquals(6, footballClub.getWins());
    }

    @Test
    public void setWins() {
        int wins = 10;
        footballClub.setWins(wins);
        assertEquals(wins, footballClub.getWins());
    }

    @Test
    public void getDefeats() {
        assertEquals(3, footballClub.getDefeats());
    }

    @Test
    public void setDefeats() {
        int defeats = 3;
        footballClub.setDefeats(defeats);
        assertEquals(defeats, footballClub.getDefeats());
    }

    @Test
    public void getDraws() {
        assertEquals(7, footballClub.getDraws());
    }

    @Test
    public void setDraws() {
        int draws = 7;
        footballClub.setDraws(draws);
        assertEquals(draws, footballClub.getDraws());
    }

    @Test
    public void getGoalsReceived() {
        assertEquals(9, footballClub.getGoalsReceived());
    }

    @Test
    public void setGoalsReceived() {
        int goalsReceived = 3;
        footballClub.setGoalsReceived(goalsReceived);
        assertEquals(goalsReceived, footballClub.getGoalsReceived());
    }

    @Test
    public void getGoalsScored() {
        assertEquals(2, footballClub.getGoalsScored());
    }

    @Test
    public void setGoalsScored() {
        int goalsScored = 1;
        footballClub.setGoalsScored(goalsScored);
        assertEquals(goalsScored, footballClub.getGoalsScored());
    }

    @Test
    public void getPoints() {
        assertEquals((footballClub.getWins() * 3) + footballClub.getDraws(), footballClub.getPoints());
    }

    @Test
    public void getGoalDifference() {
        assertEquals(footballClub.getGoalsScored() - footballClub.getGoalsReceived(), footballClub.getGoalDifference());
    }

}