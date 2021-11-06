package com.nauka;

public class GameField {
    String[][] fields = new String[11][11];
    String[] columnSymbols = new String[]{" ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    String[] rowSymbols = new String[]{" ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
    String fogOfWarSymbol = "~";
    String shipSymbol = "O";
    String bannedFieldSymbol = ".";
    String errorMsg;

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

    boolean isLocationEmpty(Ship ship, ShipCoordinates coordinates) {
        int shipLength = ship.getShipType().getLength();
        int row = coordinates.getStartRow();
        int col = coordinates.getStartCol();

        for (int i = 0; i < shipLength; i++) {

            if (coordinates.getStartRow() == coordinates.getEndRow()) {

                if (fields[row][col].equals(bannedFieldSymbol)) {
                    errorMsg = "Error! You placed it too close to another one. Try again:";
                    return false;
                } else {
                    col += 1;
                }

            } else {

                if (fields[row][col].equals(bannedFieldSymbol)) {
                    errorMsg = "Error! You placed it too close to another one. Try again:";
                    return false;
                } else {
                    row += 1;
                }

            }
        }

        return true;
    }

    void markSpawnArea(ShipCoordinates coordinates) {
        int startRow = coordinates.getStartRow();
        int endRow = coordinates.getEndRow();
        int startCol = coordinates.getStartCol();
        int endCol = coordinates.getEndCol();

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

    void spawnShip(Ship ship, ShipCoordinates coordinates) {
        int shipLength = ship.getShipType().getLength();
        int row = coordinates.getStartRow();
        int col = coordinates.getStartCol();

        markSpawnArea(coordinates);

        for (int i = 0; i < shipLength; i++) {
            if (coordinates.getStartRow() == coordinates.getEndRow()) {
                fields[row][col] = shipSymbol;
                col += 1;
            } else {
                fields[row][col] = shipSymbol;
                row += 1;
            }
        }

    }

    void checkIfShotHits(String coordinates) {
        String rowStr = coordinates.replaceAll("\\d+", "");
        String colStr = coordinates.replaceAll("\\D+", "");
        int row = getNumberFromString(rowStr);
        int col = getNumberFromString(colStr);

        if (fields[row][col].equals(shipSymbol)) {
            System.out.println("\n" + "You hit a ship!");
        } else {
            System.out.println("\n" + "You missed!");
        }
    }

    public String getErrorMsg() {
        return errorMsg;
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
