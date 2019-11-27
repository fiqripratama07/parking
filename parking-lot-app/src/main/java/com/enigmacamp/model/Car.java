package com.enigmacamp.model;

import java.util.Objects;

public class Car {

    private String plateNumber;
    private String colour;
    private Integer hours;

    public Car(String plateNumber, String colour) {
        this.plateNumber = plateNumber;
        this.colour = colour;
    }

    public Car(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public Car(String plateNumber, Integer hours){
        this.plateNumber = plateNumber;
        this.hours = hours;
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

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(plateNumber, car.plateNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plateNumber);
    }
}
