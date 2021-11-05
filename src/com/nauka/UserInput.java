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

}
