package models;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PremierLeagueManager premierLeagueManager = new PremierLeagueManager();
        outerLoop:
        while (true) {
            try {
                //opening menu
                System.out.println("\n-----Premier League Manager-----" +
                        "\nSelect an option" +
                        "\n 1. Add a club" +
                        "\n 2. Relegate a club" +
                        "\n 3. Display stats" +
                        "\n 4. Display league table" +
                        "\n 5. Add a match" +
                        "\n 6. Open GUI" +
                        "\n 7. Exit");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        premierLeagueManager.addClub();
                        break;
                    case 2:
                        premierLeagueManager.relegateClub();
                        break;
                    case 3:
                        premierLeagueManager.displayStats();
                        break;
                    case 4:
                        premierLeagueManager.displayLeagueTable();
                        break;
                    case 5:
                        premierLeagueManager.addMatch();
                        break;
                    case 6:
                        premierLeagueManager.openGUI();
                        break outerLoop;
                    case 7:
                        System.out.println("Program ended successfully.");
                        break outerLoop;
                    default:
                        System.out.println("Please select a valid option");
                        break;
                }
            } catch (InputMismatchException e){
                System.out.println("Please enter a number between 1 - 7");
                sc.nextLine();
            }
        }
    }
}
