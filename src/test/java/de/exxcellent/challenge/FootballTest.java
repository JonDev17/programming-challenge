package de.exxcellent.challenge;

import de.exxcellent.challenge.model.DataSet;
import de.exxcellent.challenge.model.FootballRecord;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FootballTest {

    @Test
    void FootballDataSetTest(){
        DataSet<FootballRecord> ds = new DataSet<>(null,
                List.of(new FootballRecord("BD", 15, 9),
                        new FootballRecord("HSV",10, 12),
                        new FootballRecord("FCB", 23, 10)));

        String smallestSpreadTeam = ds.getSmallestBy(FootballRecord.spreadComparator()).getTeam();

        assertEquals("HSV", smallestSpreadTeam, "HSV supposed to have smallest spread!");
    }
}
