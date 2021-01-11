package models;

public class FootballClub extends SportsClub {
    private int wins;
    private int defeats;
    private int draws;
    private int goalsReceived;
    private int goalsScored;
    private int points = (wins * 3) + draws;
    private int numberOfMatchesPlayed = wins + defeats + draws;
    private int goalDifference = goalsScored - goalsReceived;

    public FootballClub(){}

    public FootballClub(String nameOfClub, String city, int wins, int defeats, int draws,
                        int goalsReceived, int goalsScored) {
        super(nameOfClub, city);
        this.wins = wins;
        this.defeats = defeats;
        this.draws = draws;
        this.goalsReceived = goalsReceived;
        this.goalsScored = goalsScored;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getDefeats() {
        return defeats;
    }

    public void setDefeats(int defeats) {
        this.defeats = defeats;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getGoalsReceived() {
        return goalsReceived;
    }

    public void setGoalsReceived(int goalsReceived) {
        this.goalsReceived = goalsReceived;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public int getPoints() {
        return (wins * 3) + draws;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getNumberOfMatchesPlayed() {
        return wins + defeats + draws;
    }

    public void setNumberOfMatchesPlayed(int numberOfMatchesPlayed) {
        this.numberOfMatchesPlayed = numberOfMatchesPlayed;
    }

    public int getGoalDifference() {
        return goalsScored - goalsReceived;
    }

    public void setGoalDifference(int goalDifference) {
        this.goalDifference = goalDifference;
    }

    @Override
    public String toString() {
        return "Wins = " + wins +
                ", \nDefeats = " + defeats +
                ", \nDraws = " + draws +
                ", \nGoals Received = " + goalsReceived +
                ", \nGoals Scored = " + goalsScored +
                ", \nPoints = " + points +
                ", \nNumber Of Matches Played = " + numberOfMatchesPlayed;
    }
}

