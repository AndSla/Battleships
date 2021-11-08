package com.nauka;

import java.util.Scanner;

public class UserInterface {

    private String coordinates;

    public String getShipCoordinates(Ship ship) {
        String shipName = ship.getShipType().getName();
        int shipLength = ship.getShipType().getLength();
        String message = "Enter the coordinates of the " + shipName + " (" + shipLength + " cells):";
        return getCoordinatesFromCmdLine("\n" + message + "\n\n" + "> "); //message
    }

    public String getShipCoordinates(String message) {
        return getCoordinatesFromCmdLine("\n" + message + "\n\n" + "> ");
    }

    public String getShotCoordinates(boolean printMessage) {
        if (printMessage) {
            String message = "Take a shot!";
            return getCoordinatesFromCmdLine("\n" + message + "\n\n" + "> ");
        } else {
            String message = "";
            return getCoordinatesFromCmdLine(message);
        }
    }

    public String getCoordinatesFromCmdLine(String message) {
        String regex;

        System.out.print(message);

        if (message.contains("shot") || message.equals("")) {
            regex = "\\s*[a-jA-J]([1-9]|10)\\s*";
        } else {
            regex = "\\s*[a-jA-J]([1-9]|10)\\s+[a-jA-J]([1-9]|10)\\s*";
        }

        while (true) {
            Scanner sc = new Scanner(System.in);
            String cmdLine = sc.nextLine();
            if (cmdLine.matches(regex)) {
                this.coordinates = cmdLine;
                return coordinates;
            } else {
                System.out.print("\n" + "Error! You entered the wrong coordinates! Try again:" + "\n\n" + "> ");
            }
        }

    }

    public void startOfTheGame() {
        System.out.print("\n" + "The game starts!" + "\n\n");
    }

    public void printMessage(String message) {
        System.out.print("\n" + message + "\n\n" + "> ");
    }

}
