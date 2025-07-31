package de.exxcellent.challenge.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DataSet<K> {

    private String[] labels;
    private List<K> data;

    /**
     * Constructor to initialize a simple structured dataset with labeled columns
     *
     * @param labels An ordered set of String labels for each column
     * @param data A list of data records
     * @author Jonas Mayer
     */
    public DataSet(String[] labels, List<K> data){
        this.labels = labels;

        this.data = new ArrayList<>();
        if(data != null){
            this.data.addAll(data);
        }
    }

    public List<K> getData(){
        return data;
    }

    public void setData(List<K> data) {
        this.data = data;
    }

    /**
     * This method finds the smallest data record by a specified metric passed as a Comparator<K> instance.
     * Returns null if no such element exists, which only happens if the data set is empty.
     *
     * @param comparisonFunction A comparator that allows to view the data set in an ordered way.
     * @return An element of type K that can be considered the smallest by a given comparator. Null if no such element exists.
     * @author Jonas Mayer
     */
    public K getSmallestBy(Comparator<K> comparisonFunction){
        return data.stream().min(comparisonFunction).orElse(null);
    }

    public int findIndexByLabel(String label){
        if(labels == null){
            return -1;
        }

        for(int i = 0; i <  labels.length; i++){
            if(label.equals(labels[i])){
                return i;
            }
        }

        return -1;
    }

}
