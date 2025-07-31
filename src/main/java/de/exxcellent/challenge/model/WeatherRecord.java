package de.exxcellent.challenge.model;

import java.util.Comparator;

/**
 * This class offers a partial view on provided weather data in order to solve the weatherdata challenge.
 *
 * @author Jonas Mayer
 */
public class WeatherRecord {

    Integer day;
    Integer mxt;
    Integer mnt;

    public WeatherRecord(Integer day, Integer mxt, Integer mnt){
        this.day = day;
        this.mxt = mxt;
        this.mnt = mnt;
    }

    public Integer getDay() {
        return day;
    }

    private Integer calculateSpread(){
        return Math.abs(mxt - mnt);
    }

    public static Comparator<WeatherRecord> spreadComparator(){
        return (r1,r2) -> r1.calculateSpread() - r2.calculateSpread();
    }

}
