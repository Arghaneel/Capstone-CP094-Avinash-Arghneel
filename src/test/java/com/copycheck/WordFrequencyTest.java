package com.copycheck;

import com.copycheck.similarity.WordFrequency;
import java.util.List;
import java.util.Map;

// Tests for WordFrequency: counting words and cosine similarity.
public class WordFrequencyTest {

    public static void run() {
        System.out.println("\nWordFrequencyTest");
        checkCountWords();
        checkSimilarity();
        checkEmptyInput();
    }

    // Each word is counted, and null gives an empty map.
    private static void checkCountWords() {
        Map<String, Integer> wordCounts = WordFrequency.countWords(List.of("apple", "banana", "apple"));
        Check.equal("countWords counts apple twice", 2, wordCounts.get("apple"));
        Check.equal("countWords counts banana once", 1, wordCounts.get("banana"));
        Check.equal("countWords finds two different words", 2, wordCounts.size());
        Check.isTrue("countWords of null is empty", WordFrequency.countWords(null).isEmpty());
    }

    // Scores from the issue, including the apple/banana worked example.
    private static void checkSimilarity() {
        List<String> textA = List.of("apple", "apple", "banana");
        List<String> textB = List.of("apple", "banana", "banana");
        Check.close("identical lists give 1.0", 1.0, WordFrequency.similarity(textA, textA));
        Check.close("same words in a different order give 1.0", 1.0,
                WordFrequency.similarity(List.of("cat", "dog", "fish"), List.of("fish", "cat", "dog")));
        Check.close("no words in common give 0.0", 0.0,
                WordFrequency.similarity(List.of("cat", "dog"), List.of("sun", "moon")));
        Check.close("apple/banana worked example gives 0.8", 0.8, WordFrequency.similarity(textA, textB));
        Check.close("[a, b] vs [a, c] gives 0.5", 0.5,
                WordFrequency.similarity(List.of("a", "b"), List.of("a", "c")));
        Check.close("[cat] vs [cat, cat] gives 1.0 (same proportions)", 1.0,
                WordFrequency.similarity(List.of("cat"), List.of("cat", "cat")));
        Check.close("swapping the two lists gives the same score",
                WordFrequency.similarity(textA, textB), WordFrequency.similarity(textB, textA));
    }

    // Empty or null input scores 0.0 instead of crashing.
    private static void checkEmptyInput() {
        List<String> noWords = List.of();
        Check.close("empty list vs words gives 0.0", 0.0,
                WordFrequency.similarity(noWords, List.of("cat")));
        Check.close("null vs words gives 0.0", 0.0,
                WordFrequency.similarity(null, List.of("cat")));
    }
}
