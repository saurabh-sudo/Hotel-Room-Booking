import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFromCSV {

    private String[][] info;

    public String[][] readCSVFile() throws FileNotFoundException {

        java.io.File file = new java.io.File("MiamiHotels.csv");

        Scanner input = new Scanner(file);

        String line;
        this.info = new String[7][7];
        int z = 0;
        while (input.hasNext()) {
            line = input.nextLine();
            this.info[z] = line.split(",");
            z++;
        }
        input.close();
        return info;
    }
}