package de.exxcellent.challenge.io;

import com.opencsv.*;

import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.List;

public class CSVIO {

    public static List<String[]> retrieveRawData(String file){
        List<String[]> records = null;

        try{
            URL fileURL = CSVIO.class.getClassLoader().getResource(file);
            if(fileURL != null){
                File f = new File(fileURL.getPath());
                FileReader fr = new FileReader(f);
                CSVReader c = new CSVReader(fr);
                records = c.readAll();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return records;
    }

}
