package com.nauka;

public class GameField {
    String[][] fields = new String[11][11];
    String[] columnSymbols = new String[]{" ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    String[] rowSymbols = new String[]{" ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
    String fogOfWarSymbol = "~";
    String shipSymbol = "O";

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
                System.out.print(field + " ");
            }
            System.out.println();
        }
    }

    void spawnShip(Ship ship, ShipCoordinates coordinates) {
        int shipLength = ship.getShipType().getLength();
        int row = coordinates.getStartRow();
        int col = coordinates.getStartCol();

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

}
