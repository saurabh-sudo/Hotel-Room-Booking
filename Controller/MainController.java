package Controller;

import Service.Impl.HotelServiceImpl;
import Service.Impl.MenuServiceImpl;
import Service.Impl.ReadFromCSVServiceImpl;


public class MainController {
    private ReadFromCSVServiceImpl read = new ReadFromCSVServiceImpl();

    public static void main(String[] args) throws Exception {
        MainController mainController = new MainController();
        HotelServiceImpl hotels = new HotelServiceImpl(mainController.getRead().readCSVFile());

        MenuServiceImpl menu = new MenuServiceImpl();
        //User Inputs and Display Output Value
        menu.getUserInputs(hotels, mainController);
    }

    public ReadFromCSVServiceImpl getRead() {
        return read;
    }

}