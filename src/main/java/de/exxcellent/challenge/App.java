package de.exxcellent.challenge;

import de.exxcellent.challenge.factories.DataSetFactory;
import de.exxcellent.challenge.io.CSVIO;
import de.exxcellent.challenge.model.DataSet;
import de.exxcellent.challenge.model.WeatherRecord;

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

        DataSet<WeatherRecord> weatherData = DataSetFactory.createWeatherDataSet(CSVIO.retrieveRawData("de/exxcellent/challenge/weather.csv"));

        String dayWithSmallestTempSpread = "" + weatherData.getSmallestBy(WeatherRecord.spreadComparator()).getDay();
        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);

        String teamWithSmallestGoalSpread = "A good team"; // Your goal analysis function call …
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
    }
}
