

package com.example.leetcodeproblems;

import java.util.ArrayList;


public class MergeSort {

//    This algorithm is useful for merging two sorted arrays into one sorted array
    public ArrayList<Integer> twoMergeSort(int[] arr1, int[] arr2) {

        int i = 0;
        int j = 0;
        ArrayList<Integer> mergedArr = new ArrayList<>();

        while(i < arr1.length && j < arr2.length) {
            if(arr1[i] < arr2[j]) {
                mergedArr.add(arr1[i]);
                i+= 1;
            }else {
                mergedArr.add(arr2[j]);
                j+= 1;
            }
        }

        while (i < arr1.length) {
            mergedArr.add(arr1[i]);
            i += 1;
        }

        while (j < arr2.length) {
            mergedArr.add(arr2[i]);
            j += 1;
        }

        return mergedArr;


    }

    public void printArr(ArrayList<Integer> arr) {
        for(int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
    }

}
