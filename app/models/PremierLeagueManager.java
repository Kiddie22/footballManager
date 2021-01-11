package models;

import services.Validation;

import java.awt.*;
import java.io.*;
import java.net.URI;
import java.util.*;

public class PremierLeagueManager implements LeagueManager {

    Validation validation = new Validation();
    public static ArrayList<FootballClub> clubDetailsList = new ArrayList<>();
    public static ArrayList<MatchData> matchResults = new ArrayList<>();

    //Read club details from file to arraylist
    {
        try {
            FileInputStream fileInputStream = new FileInputStream("clubDetails.ser");
            ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
            clubDetailsList = (ArrayList<FootballClub>)inputStream.readObject();
            inputStream.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("File clubDetails.ser does not exist. New file created.");
        }
    }

    //Read match history from file to arraylist
    {
        try {
            FileInputStream fileInputStreamForMatches = new FileInputStream("matchHistory.ser");
            ObjectInputStream inputStreamForMatches = new ObjectInputStream(fileInputStreamForMatches);
            matchResults = (ArrayList<MatchData>)inputStreamForMatches.readObject();
            inputStreamForMatches.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("File matchHistory.ser does not exist. New file created.");
        }
    }

    //Write club details to file
    public void writeClubDetails() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("clubDetails.ser", false);
            ObjectOutputStream outputStreamForClubs = new ObjectOutputStream(fileOutputStream);
            outputStreamForClubs.writeObject(clubDetailsList);
            outputStreamForClubs.flush();
            fileOutputStream.flush();
            outputStreamForClubs.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Write match data to file
    public void writeMatchData(){
        try {
            FileOutputStream fileOutputStreamForMatches = new FileOutputStream("matchHistory.ser", false);
            ObjectOutputStream outputStreamForMatches = new ObjectOutputStream(fileOutputStreamForMatches);
            outputStreamForMatches.writeObject(matchResults);
            outputStreamForMatches.flush();
            fileOutputStreamForMatches.flush();
            outputStreamForMatches.close();
            fileOutputStreamForMatches.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //add a new club
    @Override
    public void addClub() {
        int choice = validation.validateChoice("Enter type of club" +
                "\n1. University Club" +
                "\n2. School Club" +
                "\nEnter your selection: ");
        String nameOfClub = validation.validateString("Enter name of club: ");
        String city = validation.validateString("Enter city: ");
        int wins = validation.validateInt("Enter number of wins: ");
        int defeats = validation.validateInt("Enter number of defeats: ");
        int draws = validation.validateInt("Enter number of draws: ");
        int goalsScored = validation.validateInt("Enter number of goals scored: ");
        int goalsReceived = validation.validateInt("Enter number of goals received: ");
        switch (choice) {
            //university club
            case 1:
                String universityName = validation.validateString("Enter University Name: ");
                Integer universityId = validation.validateInt("Enter University ID: ");
                UniversityFootballClub universityFootballClub = new UniversityFootballClub(nameOfClub, city, wins, defeats,
                        draws, goalsReceived, goalsScored, universityName, universityId);
                clubDetailsList.add(universityFootballClub);
                break;
            //school club
            case 2:
                String schoolName = validation.validateString("Enter School Name: ");
                Integer schoolId = validation.validateInt("Enter School ID: ");
                SchoolFootballClub schoolFootballClub = new SchoolFootballClub(nameOfClub, city, wins, defeats,
                        draws, goalsReceived, goalsScored, schoolName, schoolId);
                clubDetailsList.add(schoolFootballClub);
                break;
            default:
                System.out.println("Please enter a valid option");
        }
        System.out.println("Club added successfully.");
        writeClubDetails();
    }

    //remove an existing club
    @Override
    public void relegateClub() {
        System.out.println("Enter number of club to relegate");
        int i = 1;
        for (SportsClub club : clubDetailsList){
            System.out.println(i + ". " + club.getNameOfClub());
            i++;
        }
        System.out.println("--------------");
        System.out.println(i + ". Cancel");
        int relegation = validation.validateInt("") - 1;
        try {
            clubDetailsList.remove(relegation);
            System.out.println("Club relegated successfully");
            writeClubDetails();
        } catch (Exception e){
            System.out.println("No clubs were relegated");
        }
    }

    //display stats of a club
    @Override
    public void displayStats() {
        if (clubDetailsList.size() == 0){
            System.out.println("No sports clubs currently stored.");
        }
        else {
            int i = 1;
            for (SportsClub club : clubDetailsList) {
                System.out.println(i + ". " + club.getNameOfClub());
                i++;
            }
            int clubName = validation.validateInt("Select club to display stats of");
            try {
                System.out.println(clubDetailsList.get(clubName - 1));
            } catch (Exception e){
                System.out.println("Club with that number does not exist");
            }
        }
    }

    //display table on console
    @Override
    public void displayLeagueTable() {
        Comparator<FootballClub> sortByPoints = Comparator.comparing(FootballClub::getPoints)
                .thenComparing(FootballClub::getGoalDifference);
        clubDetailsList.sort(sortByPoints);
        Collections.reverse(clubDetailsList);

        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.printf("%-18s %7s %7s %8s %15s %17s %5s",
                "Club Name", "| Wins | ", "Defeats | ", "Draws | ", "Goals Scored | ", "Goals Received | ", "Points");
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------------");
        for(FootballClub club: clubDetailsList){
            System.out.printf("%-21s %-9d %-7d %-11d %-16s %-15s %-5d",
                    club.getNameOfClub(), club.getWins(), club.getDefeats(), club.getDraws(),
                    club.getGoalsScored(), club.getGoalsReceived(), club.getPoints());
            System.out.println();
        }
        System.out.println("-------------------------------------------------------------------------------------------");
    }

    //add a new match
    @Override
    public void addMatch() {

        int teamOne;
        int teamTwo;

        if (clubDetailsList.size() <= 1){
            System.out.println("Not enough teams to add a match");
        } else {
            int i = 1;

            //list of clubs
            for (SportsClub club : clubDetailsList) {
                System.out.println(i + ". " + club.getNameOfClub());
                i++;
            }

            while (true){
                teamOne = validation.validateInt("Select team 1") - 1;
                if (teamOne <= (clubDetailsList.size() - 1)){
                    break;
                } else {
                    System.out.println("Selection out of range");
                }
            }
            while (true){
                teamTwo = validation.validateInt("Select team 2") - 1;
                if (teamTwo == teamOne){
                    System.out.println("Same team cannot be selected twice");
                } else if (teamTwo <= (clubDetailsList.size() - 1)){
                    break;
                } else {
                    System.out.println("Selection out of range");
                }
            }

            //Setting goals scored
            int goalsByTeamOne = validation.validateInt("Enter goals scored by " + clubDetailsList.get(teamOne).getNameOfClub());
            clubDetailsList.get(teamOne).setGoalsScored(clubDetailsList.get(teamOne).getGoalsScored() + goalsByTeamOne);

            int goalsByTeamTwo = validation.validateInt("Enter goals scored by " + clubDetailsList.get(teamTwo).getNameOfClub());
            clubDetailsList.get(teamTwo).setGoalsScored(clubDetailsList.get(teamTwo).getGoalsScored() + goalsByTeamTwo);

            //Setting date
            int day = validation.validateDay("Enter day of match");
            int month = validation.validateMonth("Enter month of match");
            int year = validation.validateYear("Enter year of match");
            Date date = new Date(day, month, year);

            //Setting goals received
            clubDetailsList.get(teamOne).setGoalsReceived(clubDetailsList.get(teamOne).getGoalsReceived() + goalsByTeamTwo);
            clubDetailsList.get(teamTwo).setGoalsReceived(clubDetailsList.get(teamTwo).getGoalsReceived() + goalsByTeamOne);

            //if match is a draw
            if (goalsByTeamOne == goalsByTeamTwo) {
                clubDetailsList.get(teamOne).setDraws(clubDetailsList.get(teamOne).getDraws() + 1);
                clubDetailsList.get(teamTwo).setDraws(clubDetailsList.get(teamTwo).getDraws() + 1);
                //if team one wins
            } else if (goalsByTeamOne > goalsByTeamTwo) {
                clubDetailsList.get(teamOne).setWins(clubDetailsList.get(teamOne).getWins() + 1);
                clubDetailsList.get(teamTwo).setDefeats(clubDetailsList.get(teamTwo).getDefeats() + 1);
                //if team two wins
            } else {
                clubDetailsList.get(teamOne).setDefeats(clubDetailsList.get(teamOne).getDefeats() + 1);
                clubDetailsList.get(teamTwo).setWins(clubDetailsList.get(teamTwo).getWins() + 1);
            }

            MatchData matchData = new MatchData(clubDetailsList.get(teamOne).getNameOfClub(), clubDetailsList.get(teamTwo).getNameOfClub(), goalsByTeamOne, goalsByTeamTwo, date);
            matchResults.add(matchData);

            writeClubDetails();
            writeMatchData();
        }
    }

    //generate a random match
    //called from GUI via MatchDataController
    @Override
    public MatchData generateMatch(ArrayList<FootballClub> footballClubs) {

        if (footballClubs.size() <= 1){
            System.out.println("Not enough teams to generate random match");
        } else {
            Random random = new Random();
            int teamOne = random.nextInt(footballClubs.size());
            int teamTwo;
            do {
                teamTwo = random.nextInt(footballClubs.size());
            }
            while (teamOne == teamTwo);

            //Setting goals scored

            int goalsByTeamOne = random.nextInt(9);
            footballClubs.get(teamOne).setGoalsScored(footballClubs.get(teamOne).getGoalsScored() + goalsByTeamOne);

            int goalsByTeamTwo = random.nextInt(9);
            footballClubs.get(teamTwo).setGoalsScored(footballClubs.get(teamTwo).getGoalsScored() + goalsByTeamTwo);

            //Setting date
            int day = random.nextInt(29) + 1;
            int month = random.nextInt(11) + 1;
            int year = random.nextInt(5) + 2015;
            Date date = new Date(day, month, year);

            //Setting goals received
            footballClubs.get(teamOne).setGoalsReceived(footballClubs.get(teamOne).getGoalsReceived() + goalsByTeamTwo);
            footballClubs.get(teamTwo).setGoalsReceived(footballClubs.get(teamTwo).getGoalsReceived() + goalsByTeamOne);

            //if match is a draw
            if (goalsByTeamOne == goalsByTeamTwo) {
                footballClubs.get(teamOne).setDraws(footballClubs.get(teamOne).getDraws() + 1);
                footballClubs.get(teamTwo).setDraws(footballClubs.get(teamTwo).getDraws() + 1);
                //if team one wins
            } else if (goalsByTeamOne > goalsByTeamTwo) {
                footballClubs.get(teamOne).setWins(footballClubs.get(teamOne).getWins() + 1);
                footballClubs.get(teamTwo).setDefeats(footballClubs.get(teamTwo).getDefeats() + 1);
                //if team two wins
            } else {
                footballClubs.get(teamOne).setDefeats(footballClubs.get(teamOne).getDefeats() + 1);
                footballClubs.get(teamTwo).setWins(footballClubs.get(teamTwo).getWins() + 1);
            }

            return new MatchData(footballClubs.get(teamOne).getNameOfClub(), footballClubs.get(teamTwo).getNameOfClub(), goalsByTeamOne, goalsByTeamTwo, date);
        }
        return null;
    }

    //Open angular app
    @Override
    public void openGUI() {
        {
            try {
                Desktop desktop = java.awt.Desktop.getDesktop();
                URI oURL = new URI("http://localhost:4200/");
                desktop.browse(oURL);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
