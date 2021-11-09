package com.nauka;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        GameField gameField = new GameField();
        UserInterface ui = new UserInterface();
        Fleet fleet = new Fleet();
        List<Ship> shipList = fleet.getShipList();

        gameField.draw();

        for (Ship ship : shipList) {

            ShipCoordinates potentialCoordinates = new ShipCoordinates(ui.getShipCoordinates(ship));

            while (true) {

                if (potentialCoordinates.areValid(ship)) {

                    if (gameField.isLocationEmpty(potentialCoordinates)) {
                        ship.setFields(potentialCoordinates);
                        gameField.spawnShip(ship);
                        gameField.draw();
                        break;
                    } else {
                        String shipNewCoordinates = ui.getShipCoordinates(gameField.getMessage());
                        potentialCoordinates = new ShipCoordinates(shipNewCoordinates);
                    }

                } else {
                    String shipNewCoordinates = ui.getShipCoordinates(potentialCoordinates.getErrorMsg());
                    potentialCoordinates = new ShipCoordinates(shipNewCoordinates);
                }

            }

        }

        ui.startOfTheGame();
        gameField.drawHidden();
        Coordinates shotCoordinates = new Coordinates(ui.getShotCoordinates(true));

        while (true) {
            gameField.checkIfShotHitsTheShip(shotCoordinates);
            gameField.drawHidden();
            ui.printMessage(gameField.getMessage());
            if (gameField.checkIfAllShipsSank()) break;
            shotCoordinates = new Coordinates(ui.getShotCoordinates(false));
        }

    }

}
