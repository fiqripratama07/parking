package com.enigmacamp.dao;

import com.enigmacamp.constant.MessageConstant;
import com.enigmacamp.model.Car;
import org.junit.Assert;
import org.junit.Test;

public class ParkingLotDaoImplTest {

    @Test
    public void createParkingLot_shouldReturn_stringMessage_CREATE_PARKING_LOT() {
        Integer capacity = 1;
        String expectedString =  new ParkingLotDaoImpl(capacity).createParkingLot();
        String actualString = String.format(MessageConstant.CREATE_PARKING_LOT_SUCCESS,capacity);
        Assert.assertEquals(expectedString,actualString);
    }

    @Test
    public void createParkingLot_shouldReturn_stringMessage_CREATE_PARKING_LOT_FAILED_when_capacityIsNull() {
        Integer capacity = -10000;
        String expectedString =  new ParkingLotDaoImpl(capacity).createParkingLot();
        String actualString = MessageConstant.CREATE_PARKING_LOT_FAILED;
        Assert.assertEquals(expectedString,actualString);
    }

    @Test
    public void park_shouldReturn_stringMessage_PARKING_SUCCESS() {
        Integer capacity = 1;
        ParkingLotDaoImpl parkingLotDao = new ParkingLotDaoImpl(capacity);
        String expectedString = parkingLotDao.park(new Car("B 0239 II"));
        String actualString = String.format(MessageConstant.PARKING_SUCCESS,capacity);
        Assert.assertEquals(expectedString,actualString);
    }

    @Test
    public void park_shouldReturn_stringMessage_PARKING_FAILED_when_TheSameCarWantToPark() {
        Integer capacity = 2;
        ParkingLotDaoImpl parkingLotDao = new ParkingLotDaoImpl(capacity);
        parkingLotDao.park(new Car("B 0239 II"));
        String expectedString = parkingLotDao.park(new Car("B 0239 II"));
        String actualString = MessageConstant.PARKING_FAILED;
        Assert.assertEquals(expectedString,actualString);
    }

    @Test
    public void park_shouldReturn_stringMessage_PARKING_LOT_FULL_when_slotCapacityOne_and_carWantToParkTwo(){
        Integer capacity = 1;
        ParkingLotDaoImpl parkingLotDao = new ParkingLotDaoImpl(capacity);
        parkingLotDao.park(new Car("B 0239 II"));
        String expectedString = parkingLotDao.park(new Car("B 0291 AA"));
        String actualString = MessageConstant.PARKING_LOT_FULL;
        Assert.assertEquals(expectedString,actualString);
    }

    @Test
    public void leave_shouldReturn_LEAVE_SUCCESS_withCorrect_plateNumber_when_carIsExist() {
        Integer capacity = 1;
        Integer expectedSlot = 1;
        ParkingLotDaoImpl parkingLotDao = new ParkingLotDaoImpl(capacity);
        Car car = new Car("B 2020 PP",5);
        String expectedFee = parkingLotDao.calculation(car.getHours()).toString();
        String expectedResultString = String.format(MessageConstant.LEAVE_SUCCESS,car.getPlateNumber(),expectedSlot, expectedFee);
        parkingLotDao.park(car);
        String actualResultString = parkingLotDao.leave(car);
        Assert.assertEquals(expectedResultString,actualResultString);
    }

    @Test
    public void leave_shouldReturn_LEAVE_SUCCESS_withTheSecond_plateNumbersCar_when_CarIsExist() {
        Integer capacity = 2;
        Integer expectedSlot = 2;
        ParkingLotDaoImpl parkingLotDao = new ParkingLotDaoImpl(capacity);
        Car firstCar = new Car("B 2020 PP",3);
        Car secondCar = new Car("B 1530 AA",1);
        String expectedFee = parkingLotDao.calculation(secondCar.getHours()).toString();
        String expectedResultString = String.format(MessageConstant.LEAVE_SUCCESS,secondCar.getPlateNumber(),expectedSlot,expectedFee);
        parkingLotDao.park(firstCar);
        parkingLotDao.park(secondCar);
        String actualResultString = parkingLotDao.leave(secondCar);
        Assert.assertEquals(expectedResultString,actualResultString);
    }

    @Test
    public void leave(){
        Integer capacity = 1;
        Integer expectedSlot = 1;
        ParkingLotDaoImpl parkingLotDao = new ParkingLotDaoImpl(capacity);
        Car car = new Car("B 2020 PP",5);

        String expectedString = parkingLotDao.leave(car);
        String actualString = String.format(MessageConstant.LEAVE_FAILED,car.getPlateNumber());
        Assert.assertEquals(expectedString,actualString);
    }

    @Test
    public void getStatus() {
        Integer capacity = 3;
        ParkingLotDaoImpl parkingLotDao = new ParkingLotDaoImpl(capacity);
        parkingLotDao.createParkingLot();
        Car firstCar = new Car("B 2020 PP");
        Car secondCar = new Car("B 1530 AA");
        Car thirdCar = new Car("B 1283 AB");
        parkingLotDao.park(firstCar);
        parkingLotDao.park(secondCar);
        parkingLotDao.park(thirdCar);
        String actualString = parkingLotDao.getStatus();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(MessageConstant.HEADER_STATUS );
        stringBuilder.append(String.format(MessageConstant.STATUS,1, firstCar.getPlateNumber()));
        stringBuilder.append(String.format(MessageConstant.STATUS,2, secondCar.getPlateNumber()));
        stringBuilder.append(String.format(MessageConstant.STATUS,3, thirdCar.getPlateNumber()));
        Assert.assertEquals(actualString,stringBuilder.toString());
    }
}