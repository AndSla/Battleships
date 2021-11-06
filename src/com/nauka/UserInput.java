package com.nauka;

import java.util.Scanner;

public class UserInput {

    private String coordinatesFromCmdLine;

    public String getCoordinatesFromCmdLine() {
        return coordinatesFromCmdLine;
    }

    public void typeCoordinatesInCmdLine(Ship ship) {
        String shipName = ship.getShipType().getName();
        int shipLength = ship.getShipType().getLength();

        System.out.print("\n" + "Enter the coordinates of the " + shipName + " (" + shipLength + " cells):" + "\n\n" + "> ");

        while (true) {
            Scanner sc = new Scanner(System.in);
            String cmdLine = sc.nextLine();
            if (cmdLine.matches("\\s*[a-jA-J]([1-9]|10)\\s+[a-jA-J]([1-9]|10)\\s*")) {
                this.coordinatesFromCmdLine = cmdLine;
                break;
            } else {
                System.out.print("\n" + "Error! Try again:" + "\n\n" + "> ");
            }
        }

    }

    public void typeCoordinatesInCmdLine(String message) {

        System.out.print("\n" + message + "\n\n" + "> ");

        while (true) {
            Scanner sc = new Scanner(System.in);
            String cmdLine = sc.nextLine();
            if (cmdLine.matches("\\s*[a-jA-J]([1-9]|10)\\s+[a-jA-J]([1-9]|10)\\s*")) {
                this.coordinatesFromCmdLine = cmdLine;
                break;
            } else {
                System.out.print("\n" + "Error! Try again:" + "\n\n" + "> ");
            }
        }

    }

    public void startOfTheGame(GameField gameField) {
        System.out.print("\n" + "The game starts!" + "\n\n");
        gameField.draw();
    }

    public void typeShotCoordinates() {
        System.out.print("\n" + "Take a shot!" + "\n\n" + "> ");

        while (true) {
            Scanner sc = new Scanner(System.in);
            String cmdLine = sc.nextLine();
            if (cmdLine.matches("\\s*[a-jA-J]([1-9]|10)\\s*")) {
                this.coordinatesFromCmdLine = cmdLine;
                break;
            } else {
                System.out.print("\n" + "Error! You entered the wrong coordinates! Try again:" + "\n\n" + "> ");
            }
        }
    }

}
