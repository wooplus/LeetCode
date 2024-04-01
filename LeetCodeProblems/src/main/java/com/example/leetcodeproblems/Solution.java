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

    public void searchInSortedMatrix(int[][] matrix, int value, int n) {
        int i = 0;
        int j = n - 1;

        while (i < n && j >= 0) {
            if(value == matrix[i][j]) {
                System.out.println("Found!");
                return;
            }
            if(value > matrix[i][j]) {
                System.out.println(i);
                i++;
            }else {
                System.out.println(i);
                j--;
            }

        }
        System.out.println("Not found");
    }

    public int search(int[] arr, int x)  {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == x ) {
                return i;
            }
        }
        return -1;
    }

    public int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length -1;

        while (low <= high) {
            int mid = (low + high) /2;
            if(arr[mid] == key) {
                return mid;
            }
            if(key < arr[mid]) {
                high = mid -1;
            }else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int searchInsert(int[] arr, int key) {
        int low = 0;
        int high = arr.length -1;
        while (low <= high) {
            int mid = low + (high - low) /2;
            if(arr[mid] == key) return mid;
            if(key <  arr[mid] ) {
                high = mid -1;
            } else {
                low = mid + 1;
            }
          }
        return low;
    }

    public int[] bubbleSort(int[] arr) {
        boolean isSwapped;
        for(int i = 0; i < arr.length - 1; i++) {
            isSwapped = false;
            for(int j = 0; j < arr.length -1 - i; j++) {
                if(arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    isSwapped = true;
                }
            }

            if(isSwapped == false) break;
        }
        return arr;
    }

    public int[] insertionSort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i -1;
            while(j >=0 && arr[j] > tmp) {
                arr[j+1] = arr[j];
                j = j -1;
            }
            arr[j+1] =tmp;
        }
        return arr;
    }

    public int[] dutchNationalProblem(int[] arr) {
        int i = 0;
        int j = 0;
        int k = arr.length -1;
        while(i <= k) {
            if(arr[i] == 0) {
                swap(arr, i, j);
                i++;
                j++;
            } else if(arr[i] == 1) {
                i++;
            } else if(arr[i] == 2) {
                swap(arr, i, k);
                k--;
            }
        }
        return arr;
    }

    public void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
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
//
//            System.out.println(isPalindrome("madam"));
//            System.out.println(isPalindrome("racecar"));
//            System.out.println(isPalindrome("bollym"));



            int[][] sortedMatrix =  {
                {10,20,30,40},
                {15,25,35,45},
                {27,29,37,48},
                {32,33,39,51}
            };

            int [] binaryArr = {1,10,20, 47, 59, 65,75, 88, 99};

            System.out.println(binarySearch(binaryArr,121 ));

            int [] arr  = {1,5,9,2,10};
            int[] bubbleSortedArr = bubbleSort(arr);
            printNumInArr(bubbleSortedArr);

            int [] insertionSortArr = insertionSort(arr);
            printNumInArr(insertionSortArr);

//            searchInSortedMatrix(sortedMatrix, 101, 4);
        }
    }
