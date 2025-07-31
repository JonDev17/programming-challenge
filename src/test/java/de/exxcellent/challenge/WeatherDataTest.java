package de.exxcellent.challenge;

import de.exxcellent.challenge.model.WeatherRecord;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WeatherDataTest {

    @Test
    void orderingTest(){
        WeatherRecord r1 = new WeatherRecord(0,15,5);
        WeatherRecord r2 = new WeatherRecord(1,20,5);
        WeatherRecord r3 = new WeatherRecord(2,25, 15);

        int compResult = WeatherRecord.spreadComparator().compare(r1,r2);

       assertTrue(compResult < 0, "r1 supposed to have smaller spread than r2!");

       compResult = WeatherRecord.spreadComparator().compare(r1,r3);

       assertEquals( 0, compResult, "r1 and r3 supposed to have equals spread!");

       compResult = WeatherRecord.spreadComparator().compare(r2,r3);

       assertTrue(compResult > 0, "r3 supposed to have larger spread than r2!");
    }

}
