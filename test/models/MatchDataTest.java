package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class MatchDataTest {

    Date date = new Date(11, 2, 2020);
    MatchData matchData = new MatchData("Team One", "Team Two", 3, 2, date);

    @Test
    public void getTeamOne() {
        assertEquals("Team One", matchData.getTeamOne());
    }

    @Test
    public void setTeamOne() {
        String teamOne = "Galle Gladiators";
        matchData.setTeamOne(teamOne);
        assertEquals("Galle Gladiators", matchData.getTeamOne());
    }

    @Test
    public void getTeamTwo() {
        assertEquals("Team Two", matchData.getTeamTwo());
    }

    @Test
    public void setTeamTwo() {
        String teamTwo = "Colombo Knights";
        matchData.setTeamTwo(teamTwo);
        assertEquals("Colombo Knights", matchData.getTeamTwo());
    }

    @Test
    public void getTeamOneGoals() {
        assertEquals(3, matchData.getTeamOneGoals());
    }

    @Test
    public void setTeamOneGoals() {
        int goals = 8;
        matchData.setTeamOneGoals(goals);
        assertEquals(goals, matchData.getTeamOneGoals());
    }

    @Test
    public void getTeamTwoGoals() {
        assertEquals(2, matchData.getTeamTwoGoals());
    }

    @Test
    public void setTeamTwoGoals() {
        int goals = 4;
        matchData.setTeamTwoGoals(goals);
        assertEquals(goals, matchData.getTeamTwoGoals());
    }

    @Test
    public void getDate() {
        Date date2 = date;
        assertEquals(date2, matchData.getDate());
    }

    @Test
    public void setDate() {
        Date date = new Date(2, 11, 2019);
        matchData.setDate(date);
        assertEquals(date, matchData.getDate());
    }
}