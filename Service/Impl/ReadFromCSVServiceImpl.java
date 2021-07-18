package Service.Impl;

import Service.ReadFromCSVService;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFromCSVServiceImpl implements ReadFromCSVService {

    private String[][] inputs;

    public String[][] readCSVFile() throws FileNotFoundException {

        java.io.File file = new java.io.File("MiamiHotels.csv");

        Scanner input = new Scanner(file);

        String line;
        this.inputs = new String[7][7];
        int z = 0;
        while (input.hasNext()) {
            line = input.nextLine();
            this.inputs[z] = line.split(",");
            z++;
        }
        input.close();
        return inputs;
    }
}