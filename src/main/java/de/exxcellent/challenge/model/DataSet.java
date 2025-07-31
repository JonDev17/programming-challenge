package de.exxcellent.challenge.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DataSet<K> {

    private String[] labels;
    private List<K> data;

    public DataSet(String[] labels, List<K> data){
        this.labels = labels;

        this.data = new ArrayList<>();
        if(data != null){
            this.data.addAll(data);
        }
    }

    public K getSmallestBy(Comparator<K> comparisonFunction){
        return data.stream().min(comparisonFunction).orElse(null);
    }

}
