package services;

import java.util.Scanner;

public class Validation {
    Scanner scanner = new Scanner(System.in);

    public Integer validateInt(String message){
        System.out.println(message);
        while (true) {
            try {
                int integer = scanner.nextInt();
                scanner.nextLine();
                return integer;
            } catch (Exception e) {
                System.out.println("Please enter a number");
                scanner.nextLine();
            }
        }
    }

    public String validateString(String message){
        System.out.println(message);
        while (true) {
            try {
                return scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Please enter a string");
                scanner.nextLine();
            }
        }
    }

    public Integer validateChoice(String message){
        System.out.println(message);
        int choice = scanner.nextInt();
        while (true) {
            try {
                scanner.nextLine();
                if (choice == 1 || choice == 2) {
                    return choice;
                } else {
                    System.out.println("Please enter 1 or 2");
                    choice = scanner.nextInt();
                }
            } catch (Exception e) {
                System.out.println("Please enter a number");
                scanner.nextLine();
            }
        }
    }

    public int validateDay(String message){
        System.out.println(message);
        while (true) {
            try {
                int integer = scanner.nextInt();
                scanner.nextLine();
                if (integer > 0 && integer <= 31){
                    return integer;
                } else {
                    System.out.println("Day entered is not a valid date. Enter a number between 1 and 31");
                }
            } catch (Exception e) {
                System.out.println("Please enter a number");
                scanner.nextLine();
            }
        }
    }

    public int validateMonth(String message){
        System.out.println(message);
        while (true) {
            try {
                int integer = scanner.nextInt();
                scanner.nextLine();
                if (integer > 0 && integer <= 12){
                    return integer;
                } else {
                    System.out.println("Month entered is not a valid date. Enter a number between 1 and 12");
                }
            } catch (Exception e) {
                System.out.println("Please enter a number");
                scanner.nextLine();
            }
        }
    }

    public int validateYear(String message){
        System.out.println(message);
        while (true) {
            try {
                int integer = scanner.nextInt();
                scanner.nextLine();
                if (integer > 2014 && integer <= 2025){
                    return integer;
                } else {
                    System.out.println("Year entered is not a valid date. Enter a number between 2015 and 2025");
                }
            } catch (Exception e) {
                System.out.println("Please enter a number");
                scanner.nextLine();
            }
        }
    }

}
