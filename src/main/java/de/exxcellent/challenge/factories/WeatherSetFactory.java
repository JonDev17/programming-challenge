package de.exxcellent.challenge.factories;

import de.exxcellent.challenge.exceptions.FaultyData;
import de.exxcellent.challenge.model.DataSet;
import de.exxcellent.challenge.model.WeatherRecord;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

public class WeatherSetFactory {

    /**
     * Create a dataset consisting of WeatherRecord objects.
     *
     * @param rawData List of data to transform into WeatherRecords, including a header
     * @return A DataSet containing WeatherRecords
     * @author Jonas Mayer
     */
    public static DataSet<WeatherRecord> createWeatherDataSet(List<String[]> rawData) throws FaultyData{
        try {
            FactoryUtil.checkData(rawData, new String[]{"Day", "MxT", "MnT"});

            String[] header = rawData.get(0);
            DataSet<WeatherRecord> ds = new DataSet<>(header, null);

            List<WeatherRecord> data = new ArrayList<>();

            Integer currentDay;
            Integer currentMxT;
            Integer currentMnT;
            int dayIndex = DataSet.findIndexByLabel(header, "Day");
            int mxtIndex = DataSet.findIndexByLabel(header, "MxT");
            int mntIndex = DataSet.findIndexByLabel(header, "MnT");

            for (int i = 1; i < rawData.size(); i++) {
                try{
                    currentDay = Integer.valueOf(rawData.get(i)[dayIndex]);
                    currentMxT = Integer.valueOf(rawData.get(i)[mxtIndex]);
                    currentMnT = Integer.valueOf(rawData.get(i)[mntIndex]);

                    data.add(new WeatherRecord(currentDay, currentMxT, currentMnT));
                } catch (IndexOutOfBoundsException iob){
                    System.err.println("Entry at line " + i + " faulty. Skipping...");
                } catch (NumberFormatException nf){
                    System.err.println("Unexpected data in line " + i + ". Skipping");
                }

            }

            ds.setData(data);
            return ds;
        } catch (FaultyData fde) {
            throw fde;
        }
    }
}
