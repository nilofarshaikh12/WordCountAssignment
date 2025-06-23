package com.app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;

public class WordCountHelper {

    private final Map<Character, Integer> alphabetMap = new HashMap<>();
    private final Map<Character, Integer> digitMap = new HashMap<>();
    private final Map<Character, Integer> specialCharMap = new HashMap<>();

    //read text for unit testing
    public void countFromText(String text) {
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (c == ' ') {
            	continue;
            }

            if (c >= 'a' && c <= 'z') {
                c = (char) (c - 32);  // convert to uppercase
            }

            if (c >= 'A' && c <= 'Z') {
                alphabetMap.put(c, alphabetMap.getOrDefault(c, 0) + 1);
            } else if (c >= '0' && c <= '9') {
                digitMap.put(c, digitMap.getOrDefault(c, 0) + 1);
            } else {
                specialCharMap.put(c, specialCharMap.getOrDefault(c, 0) + 1);
            }
        }
    }

    //reading from a URL (for main program use)
    public void countFromFile(String filePath) {
        try {
            URL url = new URL(filePath);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String str = "";
            while ((str = reader.readLine()) != null) {
                countFromText(str);
            }
        } catch (Exception e) {
            System.out.println("File not found: " + filePath);
        }

        printResults();
    }

    public Map<Character, Integer> getAlphabetMap() {
        return alphabetMap;
    }

    public Map<Character, Integer> getDigitMap() {
        return digitMap;
    }

    public Map<Character, Integer> getSpecialCharMap() {
        return specialCharMap;
    }

    private void printResults() {
        System.out.println("Alphabets");
        printSorted(alphabetMap);

        System.out.println("\nNumbers");
        printSorted(digitMap);

        System.out.println("\nSpecial characters");
        printSorted(specialCharMap);
    }

    private void printSorted(Map<Character, Integer> map) {
        if (map.isEmpty()) {
            System.out.println("Nil");
        } else {
            List<Character> keys = new ArrayList<>(map.keySet());
            Collections.sort(keys);
            for (Character key : keys) {
                System.out.println(key + ":" + map.get(key));
            }
        }
    }
}
