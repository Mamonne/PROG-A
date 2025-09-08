package series;

public class SeriesUI {
    private SeriesService seriesService;
    
    public SeriesUI(SeriesService seriesService) {
        this.seriesService = seriesService;
    }
    
    public void displayMainMenu() {
        System.out.println("LATEST SERIES - 2025");
        System.out.println("*******************************");
        
        if (promptForMenu()) {
            showMenu();
        } else {
            exitApplication();
        }
    }
    
    private boolean promptForMenu() {
        String input = InputValidator.getInput("Enter (1) to launch menu or any other key to exit: ");
        return "1".equals(input);
    }
    
    private void showMenu() {
        while (true) {
            System.out.println("\nPlease select one of the following menu items:");
            System.out.println("(1) Capture a new series.");
            System.out.println("(2) Search for a series.");
            System.out.println("(3) Update series.");
            System.out.println("(4) Delete a series.");
            System.out.println("(5) Print series report - 2025");
            System.out.println("(6) Exit Application.");
            
            String choice = InputValidator.getInput("Enter your choice: ");
            
            switch (choice) {
                case "1":
                    captureSeries();
                    break;
                case "2":
                    searchSeries();
                    break;
                case "3":
                    updateSeries();
                    break;
                case "4":
                    deleteSeries();
                    break;
                case "5":
                    printSeriesReport();
                    break;
                case "6":
                    exitApplication();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
            
            if (!promptForMenu()) {
                exitApplication();
                break;
            }
        }
    }
    
    private void captureSeries() {
        SeriesModel series = new SeriesModel();
        
        series.SeriesId = InputValidator.getInput("Enter the series id: ");
        series.SeriesName = InputValidator.getInput("Enter the series name: ");
        series.SeriesAge = InputValidator.getValidatedAge("Enter the series age restriction: ");
        series.SeriesNumberOfEpisodes = InputValidator.getInput("Enter the number of episodes: ");
        
        seriesService.addSeries(series);
        System.out.println("Series details have been successfully saved!");
    }
    
    private void searchSeries() {
        String searchId = InputValidator.getInput("Enter the series id to search: ");
        SeriesModel series = seriesService.findSeriesById(searchId);
        
        if (series != null) {
            displaySeriesDetails(series);
        } else {
            System.out.println("-----------------------------------");
            System.out.println("Series with Series Id: " + searchId + " was not found!");
            System.out.println("-----------------------------------");
        }
    }
    
    private void updateSeries() {
        String updateId = InputValidator.getInput("Enter the series id to update: ");
        
        if (!seriesService.seriesExists(updateId)) {
            System.out.println("Series with ID " + updateId + " not found!");
            return;
        }
        
        SeriesModel updatedSeries = new SeriesModel();
        updatedSeries.SeriesId = updateId;
        updatedSeries.SeriesName = InputValidator.getInput("Enter the series name: ");
        updatedSeries.SeriesAge = InputValidator.getValidatedAge("Enter the age restriction: ");
        updatedSeries.SeriesNumberOfEpisodes = InputValidator.getInput("Enter the number of episodes: ");
        
        if (seriesService.updateSeries(updateId, updatedSeries)) {
            System.out.println("Series updated successfully!");
        } else {
            System.out.println("Failed to update series.");
        }
    }
    
    private void deleteSeries() {
        String deleteId = InputValidator.getInput("Enter the series id to delete: ");
        
        if (InputValidator.getConfirmation("Are you sure you want to delete series " + deleteId + 
                                          " from the system? Yes (y) to delete: ")) {
            if (seriesService.deleteSeries(deleteId)) {
                System.out.println("----------------------------------------------");
                System.out.println("Series with Series Id: " + deleteId + " WAS deleted!");
                System.out.println("----------------------------------------------");
            } else {
                System.out.println("Series with ID " + deleteId + " not found!");
            }
        } else {
            System.out.println("Deletion cancelled.");
        }
    }
    
    private void printSeriesReport() {
        System.out.println("\nSeries Report - 2025");
        System.out.println("====================");
        
        java.util.List<SeriesModel> allSeries = seriesService.getAllSeries();
        
        if (allSeries.isEmpty()) {
            System.out.println("No series data available.");
            return;
        }
        
        int index = 1;
        for (SeriesModel series : allSeries) {
            System.out.println("\nSeries " + index++);
            System.out.println("-------------------------------------------------");
            displaySeriesDetails(series);
            System.out.println("-------------------------------------------------");
        }
    }
    
    private void displaySeriesDetails(SeriesModel series) {
        System.out.println("SERIES ID: " + series.SeriesId);
        System.out.println("SERIES NAME: " + series.SeriesName);
        System.out.println("SERIES AGE RESTRICTION: " + series.SeriesAge);
        System.out.println("NUMBER OF EPISODES: " + series.SeriesNumberOfEpisodes);
    }
    
    private void exitApplication() {
        System.out.println("Thank you for using the TV Series Management Application. Goodbye!");
        System.exit(0);
    }
}