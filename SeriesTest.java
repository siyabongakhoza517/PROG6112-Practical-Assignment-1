import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SeriesTest {
    private Series series;

    @Before
    public void setUp() {
        series = new Series();
        series.seriesList.add(new SeriesModel("101", "Extreme Sports", "12", "10"));
    }

    @Test
    public void TestSearchSeries() {
        SeriesModel result = series.SearchSeries("101");
        assertNotNull(result);
        assertEquals("101", result.SeriesId);
    }

    @Test
    public void TestSearchSeries_SeriesNotFound() {
        SeriesModel result = series.SearchSeries("102");
        assertNull(result);
    }

    @Test
    public void TestUpdateSeries() {
        boolean updated = series.UpdateSeries("101", "Extreme Sports 2025", "10", "12");
        assertTrue(updated);
        assertEquals("Extreme Sports 2025", series.SearchSeries("101").SeriesName);
    }

    @Test
    public void TestDeleteSeries() {
        boolean deleted = series.DeleteSeries("101");
        assertTrue(deleted);
    }

    @Test
    public void TestDeleteSeries_SeriesNotFound() {
        boolean deleted = series.DeleteSeries("999");
        assertFalse(deleted);
    }

    @Test
    public void TestSeriesAgeRestriction_AgeValid() {
        assertTrue(series.isAgeValid("12"));
    }

    @Test
    public void TestSeriesAgeRestriction_SeriesAgeInValid() {
        assertFalse(series.isAgeValid("32"));
        assertFalse(series.isAgeValid("Ten"));
    }
}