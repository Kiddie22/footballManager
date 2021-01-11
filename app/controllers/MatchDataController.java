package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.FootballClub;
import models.MatchData;
import models.PremierLeagueManager;
import play.mvc.Controller;
import play.mvc.Result;

import java.io.*;
import java.util.ArrayList;

import static play.mvc.Results.ok;

public class MatchDataController extends Controller {

    ArrayList<FootballClub> footballClubArrayList = new ArrayList<>();
    ArrayList<MatchData> matchDataArrayList = new ArrayList<>();
    PremierLeagueManager premierLeagueManager = new PremierLeagueManager();

    ObjectMapper mapper = new ObjectMapper();

    public void readFiles() {
        {
            try {
                FileInputStream fileInputStream = new FileInputStream("matchHistory.ser");
                ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
                matchDataArrayList = (ArrayList<MatchData>) inputStream.readObject();
                inputStream.close();
            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            }
        }

        {
            try {
                FileInputStream fileInputStream = new FileInputStream("clubDetails.ser");
                ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
                footballClubArrayList = (ArrayList<FootballClub>) inputStream.readObject();
                inputStream.close();
            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Result createMatch() {
        readFiles();
        MatchData match = premierLeagueManager.generateMatch(footballClubArrayList);
        PremierLeagueManager.clubDetailsList = footballClubArrayList;
        premierLeagueManager.writeClubDetails();
        PremierLeagueManager.matchResults.add(match);
        premierLeagueManager.writeMatchData();
        JsonNode jsonNode = mapper.convertValue(matchDataArrayList, JsonNode.class);
        return ok(jsonNode);
    }

    public Result getMatches() {
        readFiles();
        JsonNode jsonNode = mapper.convertValue(matchDataArrayList, JsonNode.class);
        return ok(jsonNode);
    }

}