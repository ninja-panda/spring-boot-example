package com.tuturself.springbootwebsocket;

import java.util.HashMap;
import java.util.Map;

public class Test1 {

    public static void main(String[] args) {

        int[] arr = {4, 3, 6, 2, 1, 1};
        printTwiceAndMissingNumber(arr);

        int[] arr1 = {1, 3, 8, 3, 7, 4, 5, 2, 2, 5, 3, 9, 7};
        printFirstRepetitiveNumber(arr1);
    }

    /**
     * In an array of all positive numbers one number is
     * missing and one number occurs twice
     *
     * @param arr
     */
    public static void printTwiceAndMissingNumber(int[] arr) {
        Map<Integer, Boolean> aMap = new HashMap<>();
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
            if (min > i) {
                min = i;
            }
            if (aMap.get(i) == null) {
                aMap.put(i, true);
            } else {
                System.out.println(i + " occurs twice");
            }
        }
        for (int i = min; i <= max; i++) {
            if (aMap.get(i) == null) {
                System.out.println(i + " is missing");
            }
        }
    }

    public static void printFirstRepetitiveNumber(int[] arr) {
        Map<Integer, Integer> aMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            Integer index = aMap.get(arr[i]);
            if (index == null) {
                aMap.put(arr[i], (i + 1));
            } else if (index > 0) {
                aMap.put(arr[i], (index * -1));
            }
        }
        int min = Integer.MIN_VALUE;
        int firstRepeat = 0;
        for(Map.Entry<Integer,Integer> entry : aMap.entrySet()){
            if(entry.getValue() < 0){
                if(entry.getValue() > min){
                    min = entry.getValue();
                    firstRepeat = entry.getKey();
                }
            }
        }
        System.out.println(firstRepeat);
    }
}
