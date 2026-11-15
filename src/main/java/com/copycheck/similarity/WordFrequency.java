package com.copycheck.similarity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Compares two word lists by how often each word appears (cosine similarity).
public class WordFrequency {

    // Counts each word. [a, b, a] -> {a=2, b=1}
    public static Map<String, Integer> countWords(List<String> words) {
        Map<String, Integer> wordCounts = new HashMap<String, Integer>();
        if (words == null) {
            return wordCounts;
        }
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }
        return wordCounts;
    }

    // similarity = (A . B) / (|A| x |B|): 0.0 means nothing in common, 1.0 means same proportions.
    public static double similarity(List<String> words1, List<String> words2) {
        Map<String, Integer> counts1 = countWords(words1);
        Map<String, Integer> counts2 = countWords(words2);
        if (counts1.isEmpty() || counts2.isEmpty()) {
            return 0.0;
        }
        double dotProduct = 0.0;
        for (String word : counts1.keySet()) {
            if (counts2.containsKey(word)) {
                dotProduct = dotProduct + (double) counts1.get(word) * counts2.get(word);
            }
        }
        double result = dotProduct / (length(counts1) * length(counts2));
        return Math.min(result, 1.0);
    }

    // Length of a word-count vector: the square root of the sum of each count squared.
    private static double length(Map<String, Integer> counts) {
        double sumOfSquares = 0.0;
        for (int count : counts.values()) {
            sumOfSquares = sumOfSquares + (double) count * count;
        }
        return Math.sqrt(sumOfSquares);
    }
}
