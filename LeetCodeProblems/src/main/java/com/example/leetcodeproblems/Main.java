package com.example.leetcodeproblems;

public class Main {

    public static void main(String [] args) {
        System.out.println("hello leet code problems");

//        int [] arr =  {2, 7, 11, 15};
//        TwoSum ts = new TwoSum();
//
//        int [] tsArr = ts.twoSum(arr, 17);
//
//        for (int i : tsArr) {
//            System.out.print(i + " " );
//        }

        int [] arrr = {1,2,3,45, 243,234,34};

        ContainsDuplicate cd = new ContainsDuplicate();
        System.out.println(cd.containsDuplicate(arrr));



    }
}
