package com.example.leetcodeproblems;

//Input --> [2, 7, 11, 15]
//Target = 9
//Expected Output --> [0, 1]


import java.util.HashMap;

public class TwoSum {
    public int [] twoSum (int[] arr, int target) {

        HashMap<Integer, Integer> hashmap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int diff = target - arr[i];
            if(!hashmap.containsKey(diff)) {
                hashmap.put(arr[i], i);
            }else {
                return new int[] {i, hashmap.get(diff)};
            }
        }

        return new int[] {0,0};
    }
}
