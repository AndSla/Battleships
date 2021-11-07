package com.nauka;

//get rid of this class maybe? - use ShipType enum instead
public class Ship {
    private final ShipType shipType;

    public Ship(ShipType shipType) {
        this.shipType = shipType;
    }

    public ShipType getShipType() {
        return shipType;
    }

}
