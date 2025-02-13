package com.example.project.WordPair;

import java.util.ArrayList;

public class WordPairList {
    private ArrayList<WordPair> allPairs;

    // Constructor that generates all unique pairs
    public WordPairList(String[] words) {
        allPairs = new ArrayList<>();
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                allPairs.add(new WordPair(words[i], words[j]));
            }
        }
    }

    // Method to return the list of all word pairs
    public ArrayList<WordPair> getAllPairs() {
        return allPairs;
    }

    // Counts the number of word pairs where the first and second word are the same
    public int numMatches() {
        int count = 0;
        for (WordPair pair : allPairs) {
            if (pair.getFirst().equals(pair.getSecond())) {
                count++;
            }
        }
        return count;
    }

    // String representation for testing purposes
    public String toString() {
        return allPairs.toString();
    }
}
