package com.zipcodewilmington.arrayutility;

import java.util.*;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<Type> {

    Type[] arr;
    HashMap<Type, Integer> occurrences;
    public ArrayUtility(Type[] inputArray){
        this.arr = inputArray;
        occurrences =new HashMap<>();
        for(Type t : inputArray){
//            list.add(base);
            if(occurrences.containsKey(t)){
                occurrences.put(t, occurrences.get(t)+1);
            }else {
                occurrences.put(t,1);
            }
        }

    }

    public Integer countDuplicatesInMerge(Type[] arrayToMerge , Type valueToEvaluate){
        ArrayUtility<Type> temp = new ArrayUtility<>(arrayToMerge); //made new instance of arrayToMerge
        return this.occurrences.get(valueToEvaluate) + temp.occurrences.get(valueToEvaluate);
        //^^ this is checking the array                    ^^this is checking the arrayToMerge
        // pass through constructor from test               can also use .getnumberOfOccurence
    }

    public Integer getNumberOfOccurrences(Type arrayElement){
        int count =0;
        for(Type base : arr){
            if(base.equals(arrayElement)){
                count++;
            }
        }
        return count;
    }

    public Type getMostCommonFromMerge(Type[] arrayToMerge){
        ArrayUtility<Type> temp = new ArrayUtility<>(arrayToMerge);
        HashMap <Type,Integer> compare = new HashMap<>();
        for(Type t:arrayToMerge){
            int mostCommonNum = temp.getNumberOfOccurrences(t) + this.occurrences.get(t);// .get returns the value
            compare.put(t, mostCommonNum); //value is the total number of occurrence in the merged array.
        }
        int counter=0;
        Type hold=null;
        for(Map.Entry<Type,Integer> entry: compare.entrySet()){
            if(entry.getValue()>counter){
                hold = entry.getKey();
                counter = entry.getValue();
            }
        }
        return hold;
    }

    public Type[] removeValue(Type valueToRemove) {
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(valueToRemove)) {
                for (int j = i; j < arr.length - 1; j++) {
                    arr[j] = arr[j + 1];
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(valueToRemove)) {
                index = i;
                break;
            }
        }
        arr = Arrays.copyOfRange(arr, 0, index);
        return arr;
    }
}
