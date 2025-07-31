package de.exxcellent.challenge;

import de.exxcellent.challenge.io.CSVIO;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CSVIOTest {

    @Test
    void basicRetrievalTest(){
        List<String[]> records = CSVIO.retrieveRawData("de/exxcellent/challenge/weather.csv");

        assertEquals(31, records.size(), "Weather file supposed to have 31 lines");
        assertEquals(14, records.get(0).length, "File supposed to have 14 columns");

        records = CSVIO.retrieveRawData("does_not_exist.csv");
        assertNull(records, "File does not exist, no list should be created");
    }
}
