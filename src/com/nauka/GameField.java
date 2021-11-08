package com.nauka;

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

    void drawHidden() {
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

    boolean isLocationEmpty(Ship ship, Coordinates coordinates) {
        int shipLength = ship.getShipType().getLength();
        int row = coordinates.getStartRow();
        int col = coordinates.getStartCol();

        for (int i = 0; i < shipLength; i++) {

            if (coordinates.getStartRow() == coordinates.getEndRow()) {

                if (fields[row][col].equals(bannedFieldSymbol)) {
                    message = "Error! You placed it too close to another one. Try again:";
                    return false;
                } else {
                    col += 1;
                }

            } else {

                if (fields[row][col].equals(bannedFieldSymbol)) {
                    message = "Error! You placed it too close to another one. Try again:";
                    return false;
                } else {
                    row += 1;
                }

            }
        }

        return true;
    }

    void markSpawnArea(Coordinates coordinates) {
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

    void spawnShip(Ship ship, Coordinates coordinates) {
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

    void checkIfShotHitsTheShip(Coordinates coordinates) {
        int row = coordinates.getStartRow();
        int col = coordinates.getStartCol();

        if (fields[row][col].equals(shipSymbol)) {
            fields[row][col] = hitSymbol;
            message = "You hit a ship! Try again:";
        } else {
            fields[row][col] = missSymbol;
            message = "You missed. Try again:";
        }
    }

    boolean anyShipPartsLeftToHit() {
        for (String[] row : fields) {
            for (String field : row) {
                if (field.equals(shipSymbol)) {
                    return true;
                }

            }
        }
        message = "You sank the last ship. You won. Congratulations!";
        return false;
    }

    public String getMessage() {
        return message;
    }

}
