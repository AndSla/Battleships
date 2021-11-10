package com.nauka;

public class Main {

    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        Fleet fleet1 = new Fleet();
        Fleet fleet2 = new Fleet();
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");

        player1.setGameField(player1.placeYourShips(ui, fleet1));
        player2.setGameField(player2.placeYourShips(ui, fleet2));

        Player activePlayer = player1;
        Player otherPlayer = player2;

        while (true) {

            GameField playerField = activePlayer.getGameField();
            GameField enemyField = otherPlayer.getGameField();

            enemyField.drawHidden();
            playerField.draw();

            ui.startOfTheGame(activePlayer.getName());
            Coordinates shotCoordinates = new Coordinates(ui.getShotCoordinates());
            enemyField.checkIfShotHitsTheShip(shotCoordinates);
            ui.printMessage(enemyField.getMessage());

            if (enemyField.checkIfAllShipsSank()) break;

            ui.pause();

            Player tempPlayer = activePlayer;
            activePlayer = otherPlayer;
            otherPlayer = tempPlayer;

        }

    }

}
