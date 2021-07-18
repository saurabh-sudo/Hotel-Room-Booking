package Service;

import java.io.FileNotFoundException;
import java.util.Scanner;

public interface ReadFromCSVService {

    public String[][] readCSVFile() throws FileNotFoundException;
}