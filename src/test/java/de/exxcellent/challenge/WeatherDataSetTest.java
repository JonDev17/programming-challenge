package de.exxcellent.challenge;

import de.exxcellent.challenge.model.DataSet;
import de.exxcellent.challenge.model.WeatherRecord;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WeatherDataSetTest {

    @Test
    void dataSetTest(){
        List<WeatherRecord> list = List.of(new WeatherRecord(0,10,0),
                                            new WeatherRecord(1,15,10),
                                            new WeatherRecord(2,25,10));
        DataSet<WeatherRecord> ds = new DataSet<>(null,list);

        assertEquals(1,ds.getSmallestBy(WeatherRecord.spreadComparator()).getDay(),"Day 1 supposed to have smallest spread!");
    }

    @Test
    void emptySetTest(){
        DataSet<WeatherRecord> ds = new DataSet<>(null,null);
        assertNull(ds.getSmallestBy(WeatherRecord.spreadComparator()));
    }

}
