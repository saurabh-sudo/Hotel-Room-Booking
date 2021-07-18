package Entity;

public class HotelEntity implements Comparable<HotelEntity> {

    private String hotelName;
    private int hotelStarRating;
    private String customerType;
    private double[] rates = new double[7];

    private double totalCost;

    public String getHotelName() {
        return hotelName;
    }

    public HotelEntity() {
    }

    public HotelEntity(String hotelName, int hotelStarRating, String customerType, double[] rates) {
        this.hotelName = hotelName;
        this.hotelStarRating = hotelStarRating;
        this.customerType = customerType;
        this.rates = rates;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }


    public int getHotelStarRating() {
        return hotelStarRating;
    }

    public void setHotelStarRating(int hotelStarRating) {
        this.hotelStarRating = hotelStarRating;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public double[] getRates() {
        return rates;
    }

    public void setRates(double[] rates) {
        this.rates = rates;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public int compareTo(HotelEntity o) {
        double i = this.totalCost - o.totalCost;
        if (i == 0) {
            return -(this.hotelStarRating - o.hotelStarRating);
        }
        return (int) i;
    }

}
