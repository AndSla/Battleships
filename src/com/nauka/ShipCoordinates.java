package com.nauka;

import java.util.ArrayList;
import java.util.List;

public class ShipCoordinates {
    String errorMsg;
    List<Coordinates> fields = new ArrayList<>();

    public ShipCoordinates(String coordinatesFromCmdLine) {
        String[] coordinates = coordinatesFromCmdLine.trim().split("\\s+");
        String startCoordinatesString = coordinates[0];
        String endCoordinatesString = coordinates[1];
        String startRowString = startCoordinatesString.replaceAll("\\d+", "");
        String startColString = startCoordinatesString.replaceAll("\\D+", "");
        String endRowString = endCoordinatesString.replaceAll("\\d+", "");
        String endColString = endCoordinatesString.replaceAll("\\D+", "");

        int startRow = Math.min(getNumberFromString(startRowString), getNumberFromString(endRowString));
        int startCol = Math.min(getNumberFromString(startColString), getNumberFromString(endColString));
        int endRow = Math.max(getNumberFromString(startRowString), getNumberFromString(endRowString));
        int endCol = Math.max(getNumberFromString(startColString), getNumberFromString(endColString));

        if (startRow == endRow) {
            for (int i = startCol; i <= endCol; i++) {
                fields.add(new Coordinates(startRow, i));
            }
        } else if (startCol == endCol) {
            for (int i = startRow; i <= endRow; i++) {
                fields.add(new Coordinates(i, startCol));
            }
        }

    }

    public boolean areValid(Ship ship) {
        int shipLength = ship.getType().getLength();
        String shipName = ship.getType().getName();

        if (fields.size() == 0) {
            errorMsg = "Error! Wrong ship location! Try again:";
            return false;
        }

        if (fields.size() == shipLength) {
            return true;
        } else {
            errorMsg = "Error! Wrong length of the " + shipName + "! Try again:";
            return false;
        }

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

    public List<Coordinates> getFields() {
        return fields;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
