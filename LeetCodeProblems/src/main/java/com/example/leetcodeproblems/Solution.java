package com.example.leetcodeproblems;
import java.util.HashMap;

public class Solution {
    public boolean isAnagram(String s, String t) {
       if(s.length() != t.length()) {
           return false;
       }

       HashMap<Character, Integer> hashS = new HashMap<>();

       for(Character ch : s.toCharArray()) {
           hashS.put(ch, hashS.getOrDefault(ch, 0) + 1);
       }

       for (Character ch : t.toCharArray()) {
           if(!hashS.containsKey(ch)) {
               return false;
           }
           hashS.put(ch, hashS.get(ch) -1);
           if(hashS.get(ch) == 0) {
               hashS.remove(ch);
           }
       }
       return hashS.isEmpty();
    }

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

    public boolean isPalindrome(String word) {
        int start = 0;
        int end = word.length() -1;

        while(start < end) {
            if(word.charAt(start) != word.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public int findSecondMax(int[] arr) {
        int maximum = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > maximum) {
                secondMax = maximum;
                maximum = arr[i];
            }else if (arr[i] > secondMax && arr[i]!=maximum) {
                secondMax = arr[i];
            }
        }
        return secondMax;
    }

    public int[] moveZeroToEnd(int[] arr) {
        int j = 0;

        for(int i = 0; i < arr.length; i++ ) {
            if(arr[i] != 0 && arr[j] == 0) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
            if(arr[j] != 0) {
                j++;
            }
        }

        return arr;
    }

    public void printNumInArr(int[] arr ) {
        for(int i = 0; i < arr.length; i++ ) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void resizeArr(int[] arr, int capacity) {
        int[] tmpArr = new int[capacity];
        for(int i = 0; i < arr.length; i++) {
            tmpArr[i] = arr[i];
        }
        arr = tmpArr;
    }

    public int findMissingNum(int[] arr) {
        int numRange = arr.length + 1;
        int sum = (numRange * (numRange + 1) ) / 2;
        for(int num : arr) {
            sum -= num;
        }
        return sum;
    }


        public void testing() {
//            System.out.println(isAnagram("anagram", "nagaram"));
//            System.out.println(isAnagram("rat", "car"));

//            int[] maxArr = {13,34,2,34,33,1};
//            System.out.println(findSecondMax(maxArr));
//
//            int[] testingArr = {0,1,0,4,12};
//            int[] testingArr2 = {8,1,0,2,1,0,3};
//            int[] zeroEndArr = moveZeroToEnd(testingArr);
//            int[] zeroEndArr2 = moveZeroToEnd(testingArr2);

//            printNumInArr(zeroEndArr);
//            printNumInArr(zeroEndArr2);
//
//            int[] testingArr3 = {1,2,3,5};
//            System.out.println(findMissingNum(testingArr3));
//
//            int[] testingArr4 = {2,4,1,8,6,3,7};
//            System.out.println(findMissingNum(testingArr4
//            ));

            System.out.println(isPalindrome("madam"));
            System.out.println(isPalindrome("racecar"));
            System.out.println(isPalindrome("bollym"));
        }
    }
