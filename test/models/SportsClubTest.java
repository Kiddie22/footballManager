package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class SportsClubTest {

    SportsClub sportsClub = new SportsClub("Test Club", "Galle");

    @Test
    public void getNameOfClub() {
        assertEquals("Test Club", sportsClub.getNameOfClub());
    }

    @Test
    public void setNameOfClub() {
        String newName = "New name";
        sportsClub.setNameOfClub(newName);
        assertEquals(newName, sportsClub.getNameOfClub());
    }

    @Test
    public void getCity() {
        assertEquals("Galle", sportsClub.getCity());
    }

    @Test
    public void setCity() {
        String newCity = "Colombo";
        sportsClub.setCity(newCity);
        assertEquals(newCity, sportsClub.getCity());
    }
}