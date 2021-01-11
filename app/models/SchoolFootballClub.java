package models;

public class SchoolFootballClub extends FootballClub {
    private String schoolName;
    private int schoolId;

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public SchoolFootballClub(String nameOfClub, String city, int wins, int defeats, int draws,
                              int goalsReceived, int goalsScored, String schoolName, int schoolId) {
        super(nameOfClub, city, wins, defeats, draws, goalsReceived, goalsScored);
        this.schoolName = schoolName;
        this.schoolId = schoolId;
    }

    @Override
    public String toString() {
        return "Club Name = " + getNameOfClub() +
                ", \nCity = " + getCity() +
                ", \nSchool Name = " + schoolName +
                ", \nSchool ID = " + schoolId +
                "n \nWins = " + getWins() +
                ", \nDefeats = " + getDefeats() +
                ", \nDraws = " + getDraws() +
                ", \nGoals Received = " + getGoalsReceived() +
                ", \nGoals Scored = " + getGoalsScored() +
                ", \nPoints = " + getPoints() +
                ", \nNumber Of Matches Played = " + getNumberOfMatchesPlayed();
    }
}

