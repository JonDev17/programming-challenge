package de.exxcellent.challenge.factories;

import de.exxcellent.challenge.exceptions.FaultyData;
import de.exxcellent.challenge.model.DataSet;

import java.util.List;

public class FactoryUtil {

    static void checkData(List<String[]> ds, String[] labels) throws FaultyData {
        //Nulled lists should be rejected
        if(ds == null){
            throw new FaultyData("Provided list is null.");
        }

        //Empty lists should be rejected
        if(ds.size() == 0){
            throw new FaultyData("No processable data.");
        }

        String[] header = ds.get(0);

        if(labels != null){
            for(String l : labels){
                //Lists with incomplete headers should be rejected
                if(DataSet.findIndexByLabel(header,l) == -1){
                    throw new FaultyData(String.format("Can't find label %s in header.",l));
                }
            }
        }
    }

}
