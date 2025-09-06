package de.exxcellent.challenge.factories;

import de.exxcellent.challenge.exceptions.FaultyData;
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
    public static DataSet<FootballRecord> createFootballDataSet(List<String[]> rawData) throws FaultyData{
        try{
            FactoryUtil.checkData(rawData,new String[]{"Team","Goals","Goals Allowed"});

            String[] header = rawData.get(0);
            DataSet<FootballRecord> ds = new DataSet<>(header, null);
            List<FootballRecord> data = new ArrayList<>();

            String currentTeam;
            Integer currentGoals;
            Integer currentGoalsAllowed;
            int teamIndex = DataSet.findIndexByLabel(header, "Team");
            int goalsIndex = DataSet.findIndexByLabel(header, "Goals");
            int goalsAllowedIndex = DataSet.findIndexByLabel(header,"Goals Allowed");

            for (int i = 1; i < rawData.size(); i++) {
                try{
                    currentTeam = rawData.get(i)[teamIndex];
                    currentGoals = Integer.valueOf(rawData.get(i)[goalsIndex]);
                    currentGoalsAllowed = Integer.valueOf(rawData.get(i)[goalsAllowedIndex]);

                    data.add(new FootballRecord(currentTeam, currentGoals, currentGoalsAllowed));
                } catch (IndexOutOfBoundsException iob){
                    System.err.println("Entry at line " + i + " faulty. Skipping...");
                } catch (NumberFormatException nf){
                    System.err.println("Unexpected data in line " + i + ". Skipping...");
                }
            }

            ds.setData(data);
            return ds;
        } catch (FaultyData fdex){
            throw fdex;
        }
    }

}
