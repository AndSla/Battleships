package com.nauka;

import java.util.ArrayList;
import java.util.List;

public class Fleet {

    List<Ship> shipList = new ArrayList<>();

    public Fleet() {

        int numOfCarriers = 1;
        int numOfBattleships = 1;
        int numOfSubmarines = 1;
        int numOfCruisers = 1;
        int numOfDestroyers = 1;

        for (int i = 0; i < numOfCarriers; i++) {
            Ship ship = new Ship(ShipType.CARRIER);
            shipList.add(ship);
        }
        for (int i = 0; i < numOfBattleships; i++) {
            Ship ship = new Ship(ShipType.BATTLESHIP);
            shipList.add(ship);
        }
        for (int i = 0; i < numOfSubmarines; i++) {
            Ship ship = new Ship(ShipType.SUBMARINE);
            shipList.add(ship);
        }
        for (int i = 0; i < numOfCruisers; i++) {
            Ship ship = new Ship(ShipType.CRUISER);
            shipList.add(ship);
        }
        for (int i = 0; i < numOfDestroyers; i++) {
            Ship ship = new Ship(ShipType.DESTROYER);
            shipList.add(ship);
        }

    }

    public List<Ship> getShipList() {
        return shipList;
    }

}
