package com.enigmacamp.dao;

import com.enigmacamp.constant.MessageConstant;
import com.enigmacamp.model.Car;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotDaoImpl implements ParkingLotDao {

    private Map<Integer,Car> parkingSlot = new HashMap<>();
    private Integer capacity;

    public ParkingLotDaoImpl(Integer capacity) {
        this.capacity = capacity;
    }

    @Override
    public String createParkingLot() {
        for (int slot = 1; slot < this.capacity; slot++) {
            parkingSlot.put(slot,null);
        }
        return String.format(MessageConstant.CREATE_PARKING_LOT,this.capacity);
    }

    @Override
    public String park(Car car) {
        return null;
    }

    @Override
    public String leave(Car car) {
        return null;
    }

    @Override
    public String getStatus() {
        return null;
    }
}
