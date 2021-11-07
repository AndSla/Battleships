package com.nauka;

public class Coordinates {
    private int startRow;
    private int endRow;
    private int startCol;
    private int endCol;
    private String errorMsg;

    public Coordinates(String coordinatesFromCmdLine) {
        if (coordinatesFromCmdLine.matches("\\s*[a-jA-J]([1-9]|10)\\s+[a-jA-J]([1-9]|10)\\s*")) {
            convertToShipCoordinates(coordinatesFromCmdLine);
        } else {
            convertToShotCoordinates(coordinatesFromCmdLine);
        }

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

    public String getErrorMsg() {
        return errorMsg;
    }

    public boolean areValid(Ship ship) {
        int shipLength = ship.getShipType().getLength();
        String shipName = ship.getShipType().getName();

        if (startRow == endRow || startCol == endCol) {
            if (endRow - startRow + 1 == shipLength || endCol - startCol + 1 == shipLength) {
                return true;
            } else {
                errorMsg = "Error! Wrong length of the " + shipName + "! Try again:";
                return false;
            }
        } else {
            errorMsg = "Error! Wrong ship location! Try again:";
            return false;
        }

    }

    private void convertToShipCoordinates(String cmdLine) {
        cmdLine = cmdLine.trim();
        String[] shipEndsCoordinates = cmdLine.split("\\s+");
        String ship1stEndCoordinates = shipEndsCoordinates[0];
        String ship2ndEndCoordinates = shipEndsCoordinates[1];
        String startRowString = ship1stEndCoordinates.replaceAll("\\d+", "");
        String endRowString = ship2ndEndCoordinates.replaceAll("\\d+", "");
        String startColString = ship1stEndCoordinates.replaceAll("\\D+", "");
        String endColString = ship2ndEndCoordinates.replaceAll("\\D+", "");

        int[] row = new int[]{getNumberFromString(startRowString), getNumberFromString(endRowString)};
        int[] col = new int[]{getNumberFromString(startColString), getNumberFromString(endColString)};

        startRow = Math.min(row[0], row[1]);
        endRow = Math.max(row[0], row[1]);
        startCol = Math.min(col[0], col[1]);
        endCol = Math.max(col[0], col[1]);

    }

    private void convertToShotCoordinates(String cmdLine) {
        cmdLine = cmdLine.trim();
        String rowStr = cmdLine.replaceAll("\\d+", "");
        String colStr = cmdLine.replaceAll("\\D+", "");

        startRow = getNumberFromString(rowStr);
        startCol = getNumberFromString(colStr);

        endRow = -1;
        endCol = -1;

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
