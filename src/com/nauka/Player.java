package com.nauka;

import java.util.List;

public class Player {
    String name;
    GameField gameField;

    public Player(String name) {
        this.name = name;
        this.gameField = new GameField();
    }

    GameField placeYourShips(UserInterface ui, Fleet fleet) {
        List<Ship> shipList = fleet.getShipList();

        ui.startPlacingShips(name);
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

            ui.pause();

        }

        return gameField;

    }

    public GameField getGameField() {
        return gameField;
    }

    public void setGameField(GameField gameField) {
        this.gameField = gameField;
    }

    public String getName() {
        return name;
    }
}
