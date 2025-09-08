/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package series;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author PC
 */
public class SeriesServiceTest {
    
    public SeriesServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    seriesService = new SeriesService();

    // Preload one sample series (S001) so tests start with data
    SeriesModel sampleSeries = new SeriesModel();
    sampleSeries.SeriesId = "S001";
    sampleSeries.SeriesName = "Test Series";
    sampleSeries.SeriesAge = "13";
    sampleSeries.SeriesNumberOfEpisodes = "10";

    seriesService.addSeries(sampleSeries);
}

    
    @After
    public void tearDown() {
    }

    

    private SeriesService seriesService;
    private SeriesModel sampleSeries;

   

   @Test
public void testAddSeries() {
    SeriesModel newSeries = new SeriesModel();
    newSeries.SeriesId = "S002";
    newSeries.SeriesName = "Another Series";
    newSeries.SeriesAge = "16";
    newSeries.SeriesNumberOfEpisodes = "8";

    seriesService.addSeries(newSeries);

    // Expect 2 series now: S001 (from setUp) + S002 (added here)
    assertEquals(2, seriesService.getAllSeries().size());
    assertTrue(seriesService.seriesExists("S002"));
}


    @Test
    public void testFindSeriesById_Found() {
        SeriesModel found = seriesService.findSeriesById("S001");
        assertNotNull(found);
        assertEquals("Test Series", found.SeriesName);
    }

    @Test
    public void testFindSeriesById_NotFound() {
        SeriesModel found = seriesService.findSeriesById("INVALID");
        assertNull(found);
    }

    @Test
    public void testUpdateSeries_Success() {
        SeriesModel updated = new SeriesModel();
        updated.SeriesId = "S001";
        updated.SeriesName = "Updated Series";
        updated.SeriesAge = "18";
        updated.SeriesNumberOfEpisodes = "20";

        boolean result = seriesService.updateSeries("S001", updated);

        assertTrue(result);

        SeriesModel fetched = seriesService.findSeriesById("S001");
        assertEquals("Updated Series", fetched.SeriesName);
        assertEquals("18", fetched.SeriesAge);
        assertEquals("20", fetched.SeriesNumberOfEpisodes);
    }

    @Test
    public void testUpdateSeries_NotFound() {
        SeriesModel updated = new SeriesModel();
        updated.SeriesId = "S999";
        updated.SeriesName = "Ghost Series";
        updated.SeriesAge = "15";
        updated.SeriesNumberOfEpisodes = "5";

        boolean result = seriesService.updateSeries("S999", updated);
        assertFalse(result);
    }

    @Test
    public void testDeleteSeries_Success() {
        boolean deleted = seriesService.deleteSeries("S001");
        assertTrue(deleted);
        assertFalse(seriesService.seriesExists("S001"));
    }

    @Test
    public void testDeleteSeries_NotFound() {
        boolean deleted = seriesService.deleteSeries("UNKNOWN");
        assertFalse(deleted);
    }

    @Test
    public void testGetAllSeries() {
        List<SeriesModel> allSeries = seriesService.getAllSeries();
        assertNotNull(allSeries);
        assertEquals(1, allSeries.size());
    }

    @Test
    public void testSeriesExists_True() {
        assertTrue(seriesService.seriesExists("S001"));
    }

    @Test
    public void testSeriesExists_False() {
        assertFalse(seriesService.seriesExists("INVALID"));
    }
}
