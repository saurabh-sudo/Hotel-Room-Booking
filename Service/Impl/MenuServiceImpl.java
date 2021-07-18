package Service.Impl;

import Controller.MainController;
import Entity.HotelEntity;
import Service.MenuService;

import java.io.IOException;
import java.util.*;

public class MenuServiceImpl implements MenuService {
    /*
    Run the menu for user to input the program
    */
    public void getUserInputs(HotelServiceImpl hot, MainController mainController) throws IOException {
        boolean run = true;
        Scanner input = new Scanner(System.in);
        while (run) {

            System.out.println("Welcome to Miami, Please Enter Customer Type and Dates for Stay in DD/MM/YYYY format");
            String inputs = input.nextLine();
            String[] inputSplit = inputs.trim().split("\\s*:\\s*", 2);
            String customerType = inputSplit[0].trim();
            String dates = inputSplit[1].trim();
            String[] datesList = dates.trim().split("\\s*,\\s*", 5);;

            String lowestPriceHotel = getLowestCostingHotel(customerType, datesList, hot);
            System.out.println(lowestPriceHotel);
        }
    }

    public String getLowestCostingHotel(String customerType, String[] datesList, HotelServiceImpl hot) {
        List<HotelEntity> entityList = hot.getListOfHotels();

        List<HotelEntity> list = new ArrayList<>();

        for (HotelEntity hotel :
                entityList) {
            double cost = 0;
            if (customerType.equals(hotel.getCustomerType())) {
                for (String date :
                        datesList) {
                    String[] f = date.split("/");
                    int d = Integer.parseInt(f[0]);
                    int m = Integer.parseInt(f[1]) - 1;
                    int y = Integer.parseInt(f[2]);
                    GregorianCalendar calendar = new GregorianCalendar(y, m, d);
                    int start = calendar.get(Calendar.DAY_OF_WEEK);
                    double[] rates = hotel.getRates();
                    cost = cost + rates[start - 2];
                }
                hotel.setTotalCost(cost);
                list.add(hotel);
            }

        }
        Collections.sort(list);
        return list.get(0).getHotelName();
    }
}