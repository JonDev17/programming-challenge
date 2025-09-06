package de.exxcellent.challenge;

import de.exxcellent.challenge.exceptions.FaultyData;
import de.exxcellent.challenge.factories.FootballSetFactory;
import de.exxcellent.challenge.factories.WeatherSetFactory;
import de.exxcellent.challenge.io.CSVIO;
import de.exxcellent.challenge.model.DataSet;
import de.exxcellent.challenge.model.FootballRecord;
import de.exxcellent.challenge.model.WeatherRecord;

import java.util.Optional;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        try{
            DataSet<WeatherRecord> weatherData = WeatherSetFactory.createWeatherDataSet(CSVIO.retrieveRawData("de/exxcellent/challenge/weather.csv"));

            Optional<WeatherRecord> minSpreadWRec = weatherData.getSmallestBy(WeatherRecord.spreadComparator());
            String dayWithSmallestTempSpread = "No such element";
            if(minSpreadWRec.isPresent()){
                dayWithSmallestTempSpread = "" + minSpreadWRec.get().getDay();
            }
            System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
        } catch(FaultyData fde){
            fde.printStackTrace();
        }

        try{
            DataSet<FootballRecord> footballData = FootballSetFactory.createFootballDataSet(CSVIO.retrieveRawData("de/exxcellent/challenge/football.csv"));

            Optional<FootballRecord> minSpreadFRec = footballData.getSmallestBy(FootballRecord.spreadComparator());
            String teamWithSmallestGoalSpread = "No such element";
            if(minSpreadFRec.isPresent()){
                teamWithSmallestGoalSpread = footballData.getSmallestBy(FootballRecord.spreadComparator()).get().getTeam();
            }
            System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
        } catch (FaultyData fde) {
            fde.printStackTrace();
        }
    }
}
