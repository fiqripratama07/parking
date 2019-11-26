package com.enigmacamp.dao;

import com.enigmacamp.constant.MessageConstant;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParkingLotDaoImplTest {

    @Test
    public void createParkingLot_shouldReturn_stringMessage_CREATE_PARKING_LOT() {
        Integer capacity = 1;
        String expectedString =  new ParkingLotDaoImpl(capacity).createParkingLot();
        String actualString = String.format(MessageConstant.CREATE_PARKING_LOT,capacity);
        Assert.assertEquals(expectedString,actualString);

    }
}