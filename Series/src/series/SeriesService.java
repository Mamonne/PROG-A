package series;

import java.util.ArrayList;
import java.util.List;

public class SeriesService {
    private List<SeriesModel> seriesList = new ArrayList<>();
    
    public void addSeries(SeriesModel series) {
        seriesList.add(series);
    }
    
    public SeriesModel findSeriesById(String seriesId) {
        for (SeriesModel series : seriesList) {
            if (series.SeriesId.equals(seriesId)) {
                return series;
            }
        }
        return null;
    }
    
    public boolean updateSeries(String seriesId, SeriesModel updatedSeries) {
        SeriesModel existingSeries = findSeriesById(seriesId);
        if (existingSeries != null) {
            existingSeries.SeriesName = updatedSeries.SeriesName;
            existingSeries.SeriesAge = updatedSeries.SeriesAge;
            existingSeries.SeriesNumberOfEpisodes = updatedSeries.SeriesNumberOfEpisodes;
            return true;
        }
        return false;
    }
    
    public boolean deleteSeries(String seriesId) {
        SeriesModel seriesToDelete = findSeriesById(seriesId);
        if (seriesToDelete != null) {
            seriesList.remove(seriesToDelete);
            return true;
        }
        return false;
    }
    
    public List<SeriesModel> getAllSeries() {
        return new ArrayList<>(seriesList);
    }
    
    public boolean seriesExists(String seriesId) {
        return findSeriesById(seriesId) != null;
    }
}