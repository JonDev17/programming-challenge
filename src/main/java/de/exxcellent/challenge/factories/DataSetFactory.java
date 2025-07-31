package de.exxcellent.challenge.factories;

import de.exxcellent.challenge.model.DataSet;
import de.exxcellent.challenge.model.WeatherRecord;

import java.util.ArrayList;
import java.util.List;

public class DataSetFactory {

    public static DataSet<WeatherRecord> createWeatherDataSet(List<String[]> rawData){
        DataSet<WeatherRecord> ds = new DataSet<>(rawData.get(0),null);

        List<WeatherRecord> data = new ArrayList<>();

        Integer currentDay;
        Integer currentMxT;
        Integer currentMnT;

        for(int i = 1; i < rawData.size(); i++){
            currentDay = Integer.valueOf(rawData.get(i)[ds.findIndexByLabel("Day")]);
            currentMxT = Integer.valueOf(rawData.get(i)[ds.findIndexByLabel("MxT")]);
            currentMnT = Integer.valueOf(rawData.get(i)[ds.findIndexByLabel("MnT")]);

            data.add(new WeatherRecord(currentDay, currentMxT, currentMnT));
        }

        ds.setData(data);
        return ds;
    }

}
