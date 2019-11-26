package com.enigmacamp.model;

public class Car {

    private String plateNumber;
    private String colour;

    public Car(String plateNumber, String colour) {
        this.plateNumber = plateNumber;
        this.colour = colour;
    }

    public Car(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public Car setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
        return this;
    }

    public String getColour() {
        return colour;
    }

    public Car setColour(String colour) {
        this.colour = colour;
        return this;
    }
}
