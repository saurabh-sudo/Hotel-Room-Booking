package Controller;

import Service.Impl.HotelServiceImpl;
import Service.Impl.MenuServiceImpl;
import Service.Impl.ReadFromCSVServiceImpl;

public class MainController {
    private ReadFromCSVServiceImpl read = new ReadFromCSVServiceImpl();

    public static void main(String[] args) {
        MainController mainController = new MainController();
        try {
            HotelServiceImpl hotels = new HotelServiceImpl(mainController.getRead().readCSVFile());

            MenuServiceImpl menu = new MenuServiceImpl();
            //User Inputs and Display Output Value
            menu.getUserInputs(hotels, mainController);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ReadFromCSVServiceImpl getRead() {
        return read;
    }

}