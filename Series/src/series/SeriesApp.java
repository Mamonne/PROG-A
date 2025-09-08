package series;
// run // main
public class SeriesApp {
    public static void main(String[] args) {
        SeriesService seriesService = new SeriesService();
        SeriesUI seriesUI = new SeriesUI(seriesService);
        
        seriesUI.displayMainMenu();
    }
}