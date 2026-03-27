
package tvseriesmodel;

import org.junit.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ST10472846
 */
public class SeriesTest {
    
    public SeriesTest() {
    }
    
    //Test Methods Assisted By: (ChatGPT, 2025)
    @Before
    public void setUp() {
        Series.clearSeriesList(); // fresh start each test
        Series.addSeries(new Series("S1", "Kea Perisha", 16, 10));
        Series.addSeries(new Series("S2", "Breaking Code", 13, 8));
    }

    @Test
    public void TestSearchSeries() {
        Series result = Series.searchSeriesById("S1");
        assertNotNull(result);
        assertEquals("Kea Perisha", result.seriesName);
    }

    @Test
    public void TestSearchSeries_SeriesNotFound() {
        Series result = Series.searchSeriesById("X1");
        assertNull(result);
    }

    @Test
    public void TestUpdateSeries() {
        boolean updated = Series.updateSeriesById("S1", "Bankai", 15, 12);
        assertTrue(updated);

        
        Series updatedSeries = Series.searchSeriesById("S1");
        assertEquals("Bankai", updatedSeries.seriesName);
        assertEquals(15, updatedSeries.seriesAge);
        assertEquals(12, updatedSeries.seriesNumEp);
    }

    @Test
    public void TestDeleteSeries() {
        boolean deleted = Series.deleteSeriesById("S2");
        assertTrue(deleted);

        assertNull(Series.searchSeriesById("S2"));
    }

    @Test
    public void TestDeleteSeries_SeriesNotFound() {
        boolean deleted = Series.deleteSeriesById("X99");
        assertFalse(deleted);
    }

    @Test
    public void TestSeriesAgeRestriction_AgeValid() {
        assertTrue(Series.isValidAge(10));
        assertTrue(Series.isValidAge(2));
        assertTrue(Series.isValidAge(18));
    }

    @Test
    public void TestSeriesAgeRestriction_SeriesAgelnValid() {
        assertFalse(Series.isValidAge(1));
        assertFalse(Series.isValidAge(19));
        assertFalse(Series.isValidAge(-5));
    }
}
/*
OpenAI.2025.ChatGPT [GPT-5]. Available at 
<https://chat.openai.com/>. [Accessed 1 September 2025]
*/
