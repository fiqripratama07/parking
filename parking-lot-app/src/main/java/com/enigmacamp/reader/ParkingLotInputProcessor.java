package com.enigmacamp.reader;

import com.enigmacamp.dao.ParkingLotDaoImpl;
import com.enigmacamp.model.Car;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Array;

public class ParkingLotInputProcessor {

    public ParkingLotInputProcessor(){}

    public void process(BufferedReader bufferedReader) throws IOException {

        ParkingLotDaoImpl parkingLotDao = new ParkingLotDaoImpl();
            String scan;
            while ((scan = bufferedReader.readLine()) != null) {
                String[] array = scan.trim().split("\\s");
                for (int read = 0; read < array.length; read++) {
                    if (array.toString() == null) {
                        break;
                    } else {
                        switch (array[read]) {
                            case "create_parking_lot":
                                Integer capacity = Integer.parseInt(array[read+1]);
                                parkingLotDao = new ParkingLotDaoImpl(capacity);
                                System.out.println(parkingLotDao.createParkingLot());
                                break;
                            case "park":
                                Car car = new Car(array[read+1]);
                                System.out.println(parkingLotDao.park(car));
                                break;
                            case "leave":
                                Integer duration = Integer.parseInt(array[read+2]);
                                Car leaveCar = new Car(array[read+1],duration);
                                System.out.println(parkingLotDao.leave(leaveCar));
                                break;
                            case "status":
                                System.out.println(parkingLotDao.getStatus());
                                break;
                        }
                    }
                }
            }

    }
}
