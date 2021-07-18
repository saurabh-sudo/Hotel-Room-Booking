public class MainController {
    private ReadFromCSV read = new ReadFromCSV();

    public static void main(String[] args) throws Exception {
        MainController mainController = new MainController();
        Hotels hotels = new Hotels(mainController.getRead().readCSVFile());

        Menu menu = new Menu();
        //User Inputs and Display Output Value
        menu.getUserInputs(hotels, mainController);
    }

    public ReadFromCSV getRead() {
        return read;
    }

}