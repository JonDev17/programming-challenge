package de.exxcellent.challenge;

import de.exxcellent.challenge.factories.DataSetFactory;
import de.exxcellent.challenge.model.DataSet;
import de.exxcellent.challenge.model.WeatherRecord;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WeatherDataSetTest {

    private String[] labels = new String[]{"Day", "MxT", "MnT"};
    @Test
    void dataSetTest(){
        List<WeatherRecord> list = List.of(new WeatherRecord(0,10,0),
                                            new WeatherRecord(1,15,10),
                                            new WeatherRecord(2,25,10));
        DataSet<WeatherRecord> ds = new DataSet<>(labels,list);

        assertEquals(2, ds.findIndexByLabel("MnT"), "MnT supposed to be the 2nd label!");
        assertEquals(1,ds.getSmallestBy(WeatherRecord.spreadComparator()).getDay(),"Day 1 supposed to have smallest spread!");
    }

    @Test
    void emptySetTest(){
        DataSet<WeatherRecord> ds = new DataSet<>(null,null);
        assertNull(ds.getSmallestBy(WeatherRecord.spreadComparator()));
    }

    @Test
    void factoryTest(){
        List<String[]> rawData = List.of(labels, new String[]{"0", "10", "0"}, new String[]{"1", "15", "10"}, new String[]{"2", "25", "10"});

        DataSet<WeatherRecord> ds = DataSetFactory.createWeatherDataSet(rawData);

        assertEquals(3, ds.getData().size(), "Data set supposed to have 3 entries!");
        assertEquals(1, ds.getData().get(1).getDay(), "Day mismatch!");
    }

}
