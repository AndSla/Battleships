package com.nauka;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        GameField gameField = new GameField();
        UserInput ui = new UserInput();
        Fleet fleet = new Fleet();
        List<Ship> shipList = fleet.getShipList();

        gameField.draw();

        for (Ship ship : shipList) {
            ui.typeCoordinatesInCmdLine(ship);
            while (true) {
                ShipCoordinates potentialCoordinates = new ShipCoordinates(ui.getCoordinatesFromCmdLine());
                if (potentialCoordinates.areValid()) {
                    // place ship onboard
                    // draw board
                    break;
                } else {
                    ui.typeCoordinatesInCmdLine();
                }
            }
        }

    }

}
