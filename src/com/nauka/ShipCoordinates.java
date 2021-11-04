package com.nauka;

public class ShipCoordinates {
    private int startRow;
    private int startCol;
    private int endRow;
    private int endCol;

    public ShipCoordinates(String coordinatesFromCmdLine) {
        int[] shipCoordinates = convertToCoordinates(coordinatesFromCmdLine);
        this.startRow = shipCoordinates[0];
        this.startCol = shipCoordinates[1];
        this.endRow = shipCoordinates[2];
        this.endCol = shipCoordinates[3];
    }

    public int getStartRow() {
        return startRow;
    }

    public int getStartCol() {
        return startCol;
    }

    public int getEndRow() {
        return endRow;
    }

    public int getEndCol() {
        return endCol;
    }

    public boolean areValid() {
        return true;
    }

    private int[] convertToCoordinates(String cmdLine) {
        cmdLine = cmdLine.trim();
        String[] shipEndsCoordinates = cmdLine.split("\\s+");
        String ship1stEndCoordinates = shipEndsCoordinates[0];
        String ship2ndEndCoordinates = shipEndsCoordinates[1];
        String startRowString = ship1stEndCoordinates.replaceAll("\\d+", "");
        String startColString = ship1stEndCoordinates.replaceAll("\\D+", "");
        String endRowString = ship2ndEndCoordinates.replaceAll("\\d+", "");
        String endColString = ship2ndEndCoordinates.replaceAll("\\D+", "");

        int startRow = getNumberFromString(startRowString);
        int startCol = getNumberFromString(startColString);
        int endRow = getNumberFromString(endRowString);
        int endCol = getNumberFromString(endColString);

        return new int[]{startRow, startCol, endRow, endCol};
    }

    private int getNumberFromString(String numberAsString) {
        switch (numberAsString) {
            case "A":
            case "a":
                return 1;
            case "B":
            case "b":
                return 2;
            case "C":
            case "c":
                return 3;
            case "D":
            case "d":
                return 4;
            case "E":
            case "e":
                return 5;
            case "F":
            case "f":
                return 6;
            case "G":
            case "g":
                return 7;
            case "H":
            case "h":
                return 8;
            case "I":
            case "i":
                return 9;
            case "J":
            case "j":
                return 10;
            default:
                return Integer.parseInt(numberAsString);
        }
    }

}
