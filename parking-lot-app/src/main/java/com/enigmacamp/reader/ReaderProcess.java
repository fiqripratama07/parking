package com.enigmacamp.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReaderProcess {

    File file = new File("src/main/java/com/enigmacamp/parkinglot.txt");
    Scanner scanner = new Scanner(file);
    List<String> content = new ArrayList<>();
    public ReaderProcess() throws FileNotFoundException {
        while (scanner.hasNextLine())
            content.add(scanner.nextLine());
    }

    public String createParkingSlot() throws FileNotFoundException {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <= content.size() ; i++) {
            if (i == 0){
            stringBuilder.append(content.get(i) + "\n");
            }
        }
        return stringBuilder.toString();
     }

    public String parkCar() throws FileNotFoundException {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <= content.size() ; i++) {
            if (i >= 1 && i <= 6){
                stringBuilder.append(content.get(i) + "\n");
            }
        }
        return stringBuilder.toString();
    }

    public String leaveCar() throws FileNotFoundException {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <= content.size() ; i++) {
            if (i == 7 ){
                stringBuilder.append(content.get(i) + "\n");
            }
        }
        return stringBuilder.toString();
    }

    public String status() throws FileNotFoundException {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <= content.size() ; i++) {
            if (i >= 8 && i <= 13){
                stringBuilder.append(content.get(i) + "\n");
            }
        }
        return stringBuilder.toString();
    }


}