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
        for (int slot = 1; slot <= this.capacity; slot++) {
            if(parkingSlot.get(slot)==null){
                parkingSlot.put(slot,car);
                return String.format(MessageConstant.PARKING_SUCCESS,slot);
            }
        }
        return MessageConstant.PARKING_LOT_FULL;
    }

    @Override
    public String leave(Car car) {
        for (Map.Entry<Integer,Car> slot : parkingSlot.entrySet()){
            if(slot.getValue()!=null){
                if(slot.getValue().getPlateNumber().equals(car.getPlateNumber())){
                    return String.format(MessageConstant.LEAVE_SUCCESS,car.getPlateNumber(),slot.getKey());
                }
            }
        }
        return String.format(MessageConstant.LEAVE_FAILED,car.getPlateNumber());
    }

    @Override
    public String getStatus() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(MessageConstant.HEADER_STATUS);
        for(Map.Entry<Integer,Car> entry : parkingSlot.entrySet()){
                stringBuilder.append(String.format(MessageConstant.STATUS, entry.getKey(), entry.getValue()));
        }
        return null;
    }
}
