package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.FootballClub;
import play.mvc.Controller;
import play.mvc.Result;

import java.io.*;
import java.util.ArrayList;

public class FootballClubController extends Controller {

    static ArrayList<FootballClub> list = new ArrayList<>();
    ObjectMapper mapper = new ObjectMapper();

    public Result getClubs() {
        {
            try {
                FileInputStream fileInputStream = new FileInputStream("clubDetails.ser");
                ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
                list = (ArrayList<FootballClub>)inputStream.readObject();
                inputStream.close();
            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            }
        }
        JsonNode jsonNode = mapper.convertValue(list, JsonNode.class);
        return ok(jsonNode);
    }
}
