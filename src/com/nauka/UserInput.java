package com.nauka;

import java.util.Scanner;

public class UserInput {

    private String coordinatesFromCmdLine;

    public String getCoordinatesFromCmdLine() {
        return coordinatesFromCmdLine;
    }

    public void typeCoordinatesInCmdLine(Ship ship) {

        switch (ship.getShipType()) {
            case CARRIER:
                System.out.print("\n" + "Enter the coordinates of the Aircraft Carrier (5 cells):" + "\n\n" + "> ");
                break;
            case BATTLESHIP:
                System.out.print("\n" + "Enter the coordinates of the Battleship (4 cells):" + "\n\n" + "> ");
                break;
            case SUBMARINE:
                System.out.print("\n" + "Enter the coordinates of the Submarine (3 cells):" + "\n\n" + "> ");
                break;
            case CRUISER:
                System.out.print("\n" + "Enter the coordinates of the Cruiser (3 cells):" + "\n\n" + "> ");
                break;
            case DESTROYER:
                System.out.print("\n" + "Enter the coordinates of the Destroyer (2 cells):" + "\n\n" + "> ");
        }

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

}
