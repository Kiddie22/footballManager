package models;

import java.util.ArrayList;

public interface LeagueManager {
    void addClub();
    void relegateClub();
    void displayStats();
    void displayLeagueTable();
    void addMatch();
    void openGUI();
    MatchData generateMatch(ArrayList<FootballClub> footballClubs);
}
