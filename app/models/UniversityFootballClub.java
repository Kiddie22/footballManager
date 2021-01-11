package models;

public class UniversityFootballClub extends FootballClub {
    private String universityName;
    private Integer universityId;

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public Integer getUniversityId() {
        return universityId;
    }

    public void setUniversityId(Integer universityId) {
        this.universityId = universityId;
    }

    public UniversityFootballClub(String nameOfClub, String city, int wins, int defeats, int draws,
                                  int goalsReceived, int goalsScored, String universityName,
                                  Integer universityId) {
        super(nameOfClub, city, wins, defeats, draws, goalsReceived, goalsScored);
        this.universityName = universityName;
        this.universityId = universityId;
    }

    @Override
    public String toString() {
        return "Club Name = " + getNameOfClub() +
                ", \nCity = " + getCity() +
                ", \nUniversity Name = " + getUniversityName() +
                ", \nUniversity ID = " + getUniversityId() +
                "n \nWins = " + getWins() +
                ", \nDefeats = " + getDefeats() +
                ", \nDraws = " + getDraws() +
                ", \nGoals Received = " + getGoalsReceived() +
                ", \nGoals Scored = " + getGoalsScored() +
                ", \nPoints = " + getPoints() +
                ", \nNumber Of Matches Played = " + getNumberOfMatchesPlayed();
    }
}
