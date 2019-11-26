package com.enigmacamp.dao;

import com.enigmacamp.model.Car;

public interface ParkingLotDao {

    public String createParkingLot();
    public String park(Car car);
    public String leave(Car car);
    public String getStatus();
}
