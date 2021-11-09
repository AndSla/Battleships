package com.nauka;

import java.util.ArrayList;
import java.util.List;

public class Ship {
    private final ShipType type;
    private List<Coordinates> fields = new ArrayList<>();

    public Ship(ShipType shipType) {
        this.type = shipType;
    }

    public ShipType getType() {
        return type;
    }

    public void setFields(ShipCoordinates shipCoordinates) {
        fields = shipCoordinates.getFields();
    }

    public List<Coordinates> getFields() {
        return fields;
    }

}
