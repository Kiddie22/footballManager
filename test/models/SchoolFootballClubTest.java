package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class SchoolFootballClubTest {

    SchoolFootballClub schoolFootballClub = new SchoolFootballClub("Club One", "Galle", 5, 3, 1, 9,
            15, "Richmond College", 2314);

    @Test
    public void getSchoolName() {
        assertEquals("Richmond College", schoolFootballClub.getSchoolName());
    }

    @Test
    public void setSchoolName() {
        String schoolName = "Mahinda College";
        schoolFootballClub.setSchoolName(schoolName);
        assertEquals(schoolName, schoolFootballClub.getSchoolName());
    }

    @Test
    public void getSchoolId() {
        assertEquals(2314, schoolFootballClub.getSchoolId());
    }

    @Test
    public void setSchoolId() {
        int newId = 1932;
        schoolFootballClub.setSchoolId(newId);
        assertEquals(newId, schoolFootballClub.getSchoolId());
    }

}