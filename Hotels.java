import java.util.ArrayList;
import java.io.FileNotFoundException;
public class Hotels {
	private ArrayList<HotelEntity> listOfHotels = new ArrayList<>();

	private String choice;

	/*
	Hotels Constructor
	*/
	public Hotels(String csvInputs[][]) throws FileNotFoundException{
		createListOfHotels(csvInputs);
	}

	public void createListOfHotels(String csvInputs[][]){
		for(int i = 0; i < 6; i++){
				String hotelName = csvInputs[i+1][0];
				int hotelType = Integer.parseInt(csvInputs[i+1][1].trim());
				String customerType = csvInputs[i+1][2];
				double[] rates = new double[7];
				for(int r = 0; r < 7; r++){
					rates[r] = Double.parseDouble(csvInputs[i+1][r+3]);
				}
				for(int z = 0; z < 1; z++){
					HotelEntity hotelEntity =new HotelEntity(hotelName,hotelType,customerType,rates);
					listOfHotels.add(hotelEntity);
				}
		}
	}

	public ArrayList<HotelEntity> getListOfHotels() {
		return listOfHotels;
	}



}
