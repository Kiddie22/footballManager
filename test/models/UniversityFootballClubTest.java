package models;

import org.junit.Test;
import scala.Int;

import static org.junit.Assert.*;

public class UniversityFootballClubTest {

    UniversityFootballClub universityFootballClub = new UniversityFootballClub("Test Club", "Colombo", 5, 3, 1, 9,
            15, "IIT", 2314);

    @Test
    public void getUniversityName() {
        assertEquals("IIT", universityFootballClub.getUniversityName());
    }

    @Test
    public void setUniversityName() {
        String name = "New Name";
        universityFootballClub.setUniversityName(name);
        assertEquals(name, universityFootballClub.getUniversityName());
    }

    @Test
    public void getUniversityId() {
        assertEquals((Integer)2314, universityFootballClub.getUniversityId());
    }

    @Test
    public void setUniversityId() {
        Integer Id = 5231;
        universityFootballClub.setUniversityId(Id);
        assertEquals(Id, universityFootballClub.getUniversityId());
    }
}