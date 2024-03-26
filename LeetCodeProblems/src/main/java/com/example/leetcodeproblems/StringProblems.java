package com.example.leetcodeproblems;

public class StringProblems {

    public String findSimpleGene(String dna) {
        int startCodon = dna.toUpperCase().indexOf("ATG");

        if(startCodon == -1) {
            return "";
        }

        int stopCodon = dna.toUpperCase().indexOf("TAA", startCodon );

        if(stopCodon == -1) {
            return "";
        }

        int diff = stopCodon - startCodon;

        if(diff %3 != 0) {
            return "";
        }
        return dna.substring(startCodon, stopCodon + 3);
    }

    public String findSimpleGeneLoop(String dna) {
        int startCodon = dna.toUpperCase().indexOf("ATG");
        int stopCodon = dna.toUpperCase().indexOf("TAA", startCodon );

        while(stopCodon != -1) {
            int diff = stopCodon - startCodon;

            if(diff % 3 != 0) {
                stopCodon = dna.toUpperCase().indexOf("TAA", stopCodon + 3);
            } else {
                return dna.substring(startCodon, stopCodon + 3);
            }
        }
        return "";
    }


    public boolean twoOccurrences(String stringa, String stringb) {
        int firstOccur = stringb.indexOf(stringa);

        if(firstOccur == -1) {
            return false;
        }

        int secondOccur = stringb.indexOf(stringa, firstOccur + 3);

        if(secondOccur == -1) {
            return false;
        }

        return true;
    }

    public String lastPart(String stringa, String stringb) {
        int index = stringb.indexOf(stringa);

        if(index == -1) {
            return stringb;
        }

        return stringb.substring(index, index + stringa.length() + 1 );
    }

    public void testing() {
        System.out.println(twoOccurrences("by", "A story by Abby Long"));
        System.out.println(twoOccurrences("a", "banana"));
        System.out.println(twoOccurrences("atg", "ctgtatgta"));

        System.out.println(lastPart("an", "banana"));
        System.out.println(lastPart("zoo", "forest"));

    }
}
