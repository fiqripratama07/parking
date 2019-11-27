package com.enigmacamp.dao;

import com.enigmacamp.constant.MessageConstant;
import com.enigmacamp.model.Car;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ParkingLotDaoImpl implements ParkingLotDao {

    private Map<Integer, Car> parkingSlots = new HashMap<>();
    private Integer capacity;
    public static final Integer firstHour = 2;
    public static final BigDecimal feeFirstHour = new BigDecimal(10);
    public static final BigDecimal feeNextHour = new BigDecimal(10);

    public ParkingLotDaoImpl(Integer capacity) {
        this.capacity = capacity;
    }

    public ParkingLotDaoImpl(){}


    @Override
    public String createParkingLot() {
        if (this.capacity <= 0){
            return MessageConstant.CREATE_PARKING_LOT_FAILED;
        }
        for (int slot = 1; slot < this.capacity; slot++) {
            parkingSlots.put(slot, null);
        }
        return String.format(MessageConstant.CREATE_PARKING_LOT_SUCCESS, this.capacity);
    }

    @Override
    public String park(Car car) {
        if (!parkingSlots.containsValue(car)) {
            for (int slot = 1; slot <= this.capacity; slot++) {
                if (parkingSlots.get(slot) == null) {
                    parkingSlots.put(slot, car);
                    return String.format(MessageConstant.PARKING_SUCCESS, slot);
                }
            }
            return MessageConstant.PARKING_LOT_FULL;
        }
        return MessageConstant.PARKING_FAILED;
    }

    @Override
    public String leave(Car car) {
        for (Map.Entry<Integer, Car> slot : parkingSlots.entrySet()) {
            if (slot.getValue() != null) {
                if (slot.getValue().getPlateNumber().equals(car.getPlateNumber())) {
                    String fee = calculation(car.getHours()).toString();
                    parkingSlots.put(slot.getKey(),null);
                    return String.format(MessageConstant.LEAVE_SUCCESS, car.getPlateNumber(), slot.getKey(), fee);
                }
            }
        }
        return String.format(MessageConstant.LEAVE_FAILED, car.getPlateNumber());
    }

    @Override
    public String getStatus() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(MessageConstant.HEADER_STATUS);
        for (Map.Entry<Integer, Car> entry : parkingSlots.entrySet()) {
            if (entry.getValue() != null)
                stringBuilder.append(String.format(MessageConstant.STATUS, entry.getKey(), entry.getValue().getPlateNumber()));
        }
        return stringBuilder.toString();
    }


    public BigDecimal calculation(Integer duration) {
        if (duration <= firstHour) {
            return feeFirstHour;
        } else {
            return feeFirstHour.add(new BigDecimal(duration-firstHour).multiply(feeNextHour));
        }
    }
}
