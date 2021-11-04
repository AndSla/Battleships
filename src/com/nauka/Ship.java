package com.nauka;

public class Ship {
    private ShipType shipType;
    private int length;

    public Ship(ShipType shipType) {
        this.shipType = shipType;
        this.length = shipType.getLength();
    }

    public ShipType getShipType() {
        return shipType;
    }

}
