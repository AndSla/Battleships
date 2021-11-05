package com.nauka;

public class Ship {
    private final ShipType shipType;

    public Ship(ShipType shipType) {
        this.shipType = shipType;
    }

    public ShipType getShipType() {
        return shipType;
    }

}
