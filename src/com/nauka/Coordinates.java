package com.nauka;

public class Coordinates {
    private final int row;
    private final int col;

    public Coordinates(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public Coordinates(String coordinatesFromCmdLine) {
        String coordinates = coordinatesFromCmdLine.trim();
        String rowStr = coordinates.replaceAll("\\d+", "");
        String colStr = coordinates.replaceAll("\\D+", "");
        this.row = getNumberFromString(rowStr);
        this.col = getNumberFromString(colStr);
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinates that = (Coordinates) o;

        if (row != that.row) return false;
        return col == that.col;
    }

    @Override
    public int hashCode() {
        int result = row;
        result = 31 * result + col;
        return result;
    }

}
