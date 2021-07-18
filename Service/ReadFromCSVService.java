package Service;

import java.io.FileNotFoundException;

public interface ReadFromCSVService {

    public String[][] readCSVFile() throws FileNotFoundException;
}w