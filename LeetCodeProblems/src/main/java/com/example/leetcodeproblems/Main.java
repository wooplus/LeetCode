// ***Resources
//https://www.youtube.com/watch?v=2ZLl8GAk1X4/
// https://docs.google.com/spreadsheets/d/1A2PaQKcdwO_lwxz9bAnxXnIQayCouZP6d-ENrBz_NXc/edit#gid=0
//https://www.youtube.com/watch?v=_fa-uQ1fEt4&list=PL6Zs6LgrJj3s_3txT9QO0qfsq-LlY71rE


package com.example.leetcodeproblems;

import java.util.ArrayList;

public class Main {

    public static void main(String [] args) {
        Solution solution = new Solution();

        solution.testing();

        String s = "I am     going   To The  Class..";
        String newStr = "";

        for(int i = 0; i < s.length(); i++) {
            if(i ==0) {
                newStr += s.charAt(i);
                continue;
            }
            if(s.charAt(i) == ' ' && s.charAt(i-1) == ' ' ) {
                continue;
            }
            newStr += Character.toLowerCase(s.charAt(i));
        }



    }
}
