package com.nauka;

import java.util.Scanner;

public class UserInterface {

    public String getShipCoordinates(Ship ship) {
        String shipName = ship.getType().getName();
        int shipLength = ship.getType().getLength();
        String message = "Enter the coordinates of the " + shipName + " (" + shipLength + " cells):";
        return getCoordinatesFromCmdLine("\n" + message);
    }

    public String getShipCoordinates(String message) {
        return getCoordinatesFromCmdLine("\n" + message);
    }

    public String getShotCoordinates() {
        String message = "";
        return getCoordinatesFromCmdLine(message);
    }

    public String getCoordinatesFromCmdLine(String message) {

        String regex;
        System.out.print(message);
        System.out.print("\n\n" + "> ");


        if (message.contains("shot") || message.equals("")) {
            regex = "\\s*[a-jA-J]([1-9]|10)\\s*";
        } else {
            regex = "\\s*[a-jA-J]([1-9]|10)\\s+[a-jA-J]([1-9]|10)\\s*";
        }

        while (true) {
            Scanner sc = new Scanner(System.in);
            String cmdLine = sc.nextLine();
            if (cmdLine.matches(regex)) {
                return cmdLine;
            } else {
                System.out.print("\n" + "Error! You entered the wrong coordinates! Try again:" + "\n\n" + "> ");
            }
        }

    }

    public void startPlacingShips(String playerName) {
        System.out.print(playerName + ", place your ships on the game field" + "\n\n");
    }

    public void startOfTheGame(String activePlayerName) {
        System.out.print("\n" + activePlayerName + ", it's your turn:");
    }

    public void printMessage(String message) {
        System.out.print("\n" + message);
    }

    public void pause() {
        System.out.print("\n" + "Press Enter and pass the move to another player" + "\n" + "...");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        System.out.println();
    }

}
