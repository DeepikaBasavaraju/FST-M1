package org.example;

import java.util.HashSet;

public class Activity10 {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<String>();
        hs.add("D");
        hs.add("P");
        hs.add("E");
        hs.add("T");
        hs.add("D");
        hs.add("X");

        System.out.println("Original HashSet: " + hs);
        System.out.println("Size of HashSet: " + hs.size());
        System.out.println("Removing T from HashSet: " + hs.remove("T"));
        if(hs.remove("Z")) {
            System.out.println("Z removed from the Set");
        } else {
            System.out.println("Z is not present in the Set");
        }

        System.out.println("Checking if D is present: " + hs.contains("D"));
        System.out.println("Updated HashSet: " + hs);
    }
}
