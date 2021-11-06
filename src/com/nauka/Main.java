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

                if (potentialCoordinates.areValid(ship)) {

                    if (gameField.isLocationEmpty(ship, potentialCoordinates)) {
                        gameField.spawnShip(ship, potentialCoordinates);
                        gameField.draw();
                        break;
                    } else {
                        ui.typeCoordinatesInCmdLine(gameField.getErrorMsg());
                    }

                } else {
                    ui.typeCoordinatesInCmdLine(potentialCoordinates.getErrorMsg());
                }

            }

        }

        ui.startOfTheGame(gameField);
        ui.typeShotCoordinates();
        gameField.checkIfShotHits(ui.getCoordinatesFromCmdLine());

    }

}
