package de.exxcellent.challenge.factories;

import de.exxcellent.challenge.model.DataSet;
import de.exxcellent.challenge.model.FootballRecord;

import java.util.ArrayList;
import java.util.List;

public class FootballSetFactory {

    /**
     * Create a dataset consisting of FootballRecord objects.
     *
     * @param rawData List of data to transform into FootballRecords, including a header
     * @return A DataSet containing FootballRecords
     * @author Jonas Mayer
     */
    public static DataSet<FootballRecord> createFootballDataSet(List<String[]> rawData){
        DataSet<FootballRecord> ds = new DataSet<>(rawData.get(0),null);

        List<FootballRecord> data = new ArrayList<>();

        String currentTeam;
        Integer currentGoals;
        Integer currentGoalsAllowed;

        for(int i = 1; i < rawData.size(); i++){
            currentTeam = rawData.get(i)[ds.findIndexByLabel("Team")];
            currentGoals = Integer.valueOf(rawData.get(i)[ds.findIndexByLabel("Goals")]);
            currentGoalsAllowed = Integer.valueOf(rawData.get(i)[ds.findIndexByLabel("Goals Allowed")]);

            data.add(new FootballRecord(currentTeam, currentGoals, currentGoalsAllowed));
        }

        ds.setData(data);
        return ds;
    }

}
