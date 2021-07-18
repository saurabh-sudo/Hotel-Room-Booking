package Service.Impl;

import Controller.MainController;
import Entity.HotelEntity;
import Service.MenuService;

import java.io.IOException;
import java.util.*;

public class MenuServiceImpl implements MenuService {
    /*
    Run the MenuServiceImpl for user to input the program
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
        List<HotelEntity> hotelEntityList = hot.getListOfHotels();

        List<HotelEntity> filteredList = new ArrayList<>();

        for (HotelEntity hotel :
                hotelEntityList) {
            double costOfRoom = 0;
            if (customerType.equals(hotel.getCustomerType())) {
                for (String date :
                        datesList) {
                    String[] f = date.split("/");
                    int date1 = Integer.parseInt(f[0]);
                    int month = Integer.parseInt(f[1]) - 1;
                    int year = Integer.parseInt(f[2]);
                    GregorianCalendar calendar = new GregorianCalendar(year, month, date1);
                    int start = calendar.get(Calendar.DAY_OF_WEEK);
                    //for Sunday to work properly with inputs
                    if(start == 1){
                        start = 6;
                    }else{
                        start = start - 2;
                    }
                    double[] rates = hotel.getRates();
                    costOfRoom = costOfRoom + rates[start];
                }
                hotel.setTotalCost(costOfRoom);
                filteredList.add(hotel);
            }

        }
        Collections.sort(filteredList);
        return filteredList.get(0).getHotelName();
    }
}