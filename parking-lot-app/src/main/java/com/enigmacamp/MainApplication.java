package com.enigmacamp;

import com.enigmacamp.reader.ParkingLotInputProcessor;
import com.enigmacamp.reader.ReaderProcess;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.logging.Logger;

public class MainApplication {

    public static void main(String[] args) throws Exception {

        File file = new File("src/main/java/com/enigmacamp/parkinglot.txt");
        BufferedReader r;
        r = new BufferedReader(new FileReader(file));
        ParkingLotInputProcessor inputProcessor = new ParkingLotInputProcessor();
        inputProcessor.process(r);



//        ReaderProcess readerProcess = new ReaderProcess();
//        Integer command;
//        System.out.println("Input Command Here");
//        System.out.println("1. Create Parking Lot");
//        System.out.println("2. Park Car");
//        System.out.println("3. Leave Car");
//        System.out.println("4. Status");
//        java.util.Scanner scanner = new Scanner(System.in);
//        command = scanner.nextInt();
//        switch (command){
//            case 1:
//                System.out.println(readerProcess.createParkingSlot());
//                break;
//            case 2:
//                System.out.println(readerProcess.parkCar());
//                break;
//            case 3:
//                System.out.println(readerProcess.leaveCar());
//                break;
//            case 4:
//                System.out.println(readerProcess.status());
//                break;
//            default:
//                System.out.println("command not found");
//                break;
//        }
    }
}