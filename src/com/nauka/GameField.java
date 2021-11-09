package com.nauka;

import java.util.ArrayList;
import java.util.List;

public class GameField {
    String[][] fields = new String[11][11];
    String[] columnSymbols = new String[]{" ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    String[] rowSymbols = new String[]{" ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
    String fogOfWarSymbol = "~";
    String shipSymbol = "O";
    String bannedFieldSymbol = ".";
    String hitSymbol = "X";
    String missSymbol = "M";
    String message;
    List<Ship> spawnedShips = new ArrayList<>();

    public GameField() {
        for (int i = 0; i < fields.length; i++) {

            for (int j = 0; j < fields[i].length; j++) {

                if (i == 0) {
                    fields[i][j] = columnSymbols[j];
                } else if (j == 0) {
                    fields[i][j] = rowSymbols[i];
                } else {
                    fields[i][j] = fogOfWarSymbol;
                }

            }

        }
    }

    void draw() {
        System.out.println();
        for (String[] row : fields) {
            for (String field : row) {
                if (field.equals(bannedFieldSymbol)) {
                    System.out.print(fogOfWarSymbol + " ");
                } else {
                    System.out.print(field + " ");
                }
            }
            System.out.println();
        }
    }

    void drawHidden() {
        System.out.println();
        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields[i].length; j++) {
                if (i == 0 || j == 0) {
                    System.out.print(fields[i][j] + " ");
                } else if (fields[i][j].equals(hitSymbol) || fields[i][j].equals(missSymbol)) {
                    System.out.print(fields[i][j] + " ");
                } else {
                    System.out.print(fogOfWarSymbol + " ");
                }
            }
            System.out.println();
        }
    }

    boolean isLocationEmpty(ShipCoordinates shipCoordinates) {
        List<Coordinates> shipFields = shipCoordinates.getFields();

        for (Coordinates shipField : shipFields) {
            if (fields[shipField.getRow()][shipField.getCol()].equals(bannedFieldSymbol)) {
                message = "Error! You placed it too close to another one. Try again:";
                return false;
            }
        }

        return true;
    }

    void markSpawnArea(List<Coordinates> shipFields) {
        int firstField = 0;
        int lastField = shipFields.size() - 1;

        int startRow = shipFields.get(firstField).getRow();
        int endRow = shipFields.get(lastField).getRow();
        int startCol = shipFields.get(firstField).getCol();
        int endCol = shipFields.get(lastField).getCol();

        int fromRow = Math.max(1, startRow - 1);
        int toRow = Math.min(10, endRow + 1);
        int fromCol = Math.max(1, startCol - 1);
        int toCol = Math.min(10, endCol + 1);

        for (int i = fromRow; i <= toRow; i++) {
            for (int j = fromCol; j <= toCol; j++) {
                fields[i][j] = bannedFieldSymbol;
            }
        }
    }

    void spawnShip(Ship ship) {
        List<Coordinates> shipFields = ship.getFields();
        markSpawnArea(shipFields);
        for (Coordinates shipField : shipFields) {
            fields[shipField.getRow()][shipField.getCol()] = shipSymbol;
        }
        spawnedShips.add(ship);

    }

    void checkIfShotHitsTheShip(Coordinates shotCoordinates) {

        if (fields[shotCoordinates.getRow()][shotCoordinates.getCol()].equals(shipSymbol)) {

            fields[shotCoordinates.getRow()][shotCoordinates.getCol()] = hitSymbol;
            message = "You hit a ship! Try again:";

            if (checkIfShipSank(shotCoordinates)) {
                message = "You sank a ship! Specify a new target:";
            }

            if (checkIfAllShipsSank()) {
                message = "You sank the last ship. You won. Congratulations!";
            }

        } else if (fields[shotCoordinates.getRow()][shotCoordinates.getCol()].equals(hitSymbol)) {
            message = "You hit a ship! Try again:";

        } else {

            fields[shotCoordinates.getRow()][shotCoordinates.getCol()] = missSymbol;
            message = "You missed. Try again:";

        }

    }

    boolean checkIfShipSank(Coordinates shotCoordinates) {
        for (Ship spawnedShip : spawnedShips) {
            List<Coordinates> shipFields = spawnedShip.getFields();
            shipFields.removeIf(shipField -> shipField.equals(shotCoordinates));
            if (shipFields.size() == 0) {
                return true;
            }
        }
        return false;
    }

    boolean checkIfAllShipsSank() {
        spawnedShips.removeIf(spawnedShip -> spawnedShip.getFields().size() == 0);
        return spawnedShips.size() == 0;
    }

    public String getMessage() {
        return message;
    }

}
