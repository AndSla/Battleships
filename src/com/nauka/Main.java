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

            Coordinates potentialCoordinates = new Coordinates(ui.getShipCoordinates(ship));

            while (true) {

                if (potentialCoordinates.areValid(ship)) {

                    if (gameField.isLocationEmpty(ship, potentialCoordinates)) {
                        gameField.spawnShip(ship, potentialCoordinates);
                        gameField.draw();
                        break;
                    } else {
                        String shipNewCoordinates = ui.getShipCoordinates(gameField.getErrorMsg());
                        potentialCoordinates = new Coordinates(shipNewCoordinates);
                    }

                } else {
                    String shipNewCoordinates = ui.getShipCoordinates(potentialCoordinates.getErrorMsg());
                    potentialCoordinates = new Coordinates(shipNewCoordinates);
                }

            }

        }

        ui.startOfTheGame();
        gameField.draw();

        Coordinates shotCoordinates = new Coordinates(ui.getShotCoordinates());
        String message = gameField.checkIfShotHits(shotCoordinates);

        gameField.drawHidden();
        ui.printMessage(message);
        gameField.draw();

    }

}
