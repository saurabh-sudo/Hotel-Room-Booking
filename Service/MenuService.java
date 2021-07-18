package Service;

import Controller.MainController;
import Entity.HotelEntity;
import Service.Impl.HotelServiceImpl;

import java.io.IOException;
import java.util.*;

public interface MenuService {
    /*
    Run the menu for user to input the program
    */
    public void getUserInputs(HotelServiceImpl hot, MainController mainController) throws IOException;

    public String getLowestCostingHotel(String customerType, String[] datesList, HotelServiceImpl hot);
}