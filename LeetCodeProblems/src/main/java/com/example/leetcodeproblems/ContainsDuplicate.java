package com.example.leetcodeproblems;

//Array --> [1,2,3,1]
//Expected Result : True
//
//Array --> [1,2,3,4]
//Expected Result : False

import java.util.HashMap;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Boolean> hashMap = new HashMap<Integer, Boolean>();

        for(int i = 0; i < nums.length; i++) {
            if(hashMap.containsKey(nums[i])) {
                return true;
            }
            hashMap.put(nums[i], true);
        }

        return false;
    }



}

