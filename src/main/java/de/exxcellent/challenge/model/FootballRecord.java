package de.exxcellent.challenge.model;

import java.util.Comparator;

/**
 * This class offers a partial view on provided team data in order to solve the footballdata challenge.
 *
 * @author Jonas Mayer
 */
public class FootballRecord {

    private String team;
    private Integer goals;
    private Integer goalsAllowed;

    public FootballRecord(String team, Integer goals, Integer goalsAllowed){
        this.team = team;
        this.goals = goals;
        this.goalsAllowed = goalsAllowed;
    }

    public String getTeam() {
        return team;
    }

    public Integer calculateSpread(){
        return Math.abs(goals - goalsAllowed);
    }

    public static Comparator<FootballRecord> spreadComparator(){
        return (r1,r2) -> r1.calculateSpread() - r2.calculateSpread();
    }
}
