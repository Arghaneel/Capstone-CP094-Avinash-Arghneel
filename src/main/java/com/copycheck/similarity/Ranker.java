package com.copycheck.similarity;

import com.copycheck.model.PairResult;
import java.util.ArrayList;
import java.util.List;

// Sorts pair results from most similar to least similar.
public class Ranker {

    // Returns a new list sorted by word score, highest first.
    public static List<PairResult> sortByWordScore(List<PairResult> results) {
        List<PairResult> sorted = new ArrayList<PairResult>();
        if (results == null) {
            return sorted;
        }
        sorted.addAll(results);
        sorted.sort((a, b) -> Double.compare(b.getWordScore(), a.getWordScore()));
        return sorted;
    }

    // Returns the n most similar pairs.
    public static List<PairResult> top(List<PairResult> results, int n) {
        if (n < 1) {
            throw new IllegalArgumentException("Please choose at least 1 pair.");
        }
        List<PairResult> sorted = sortByWordScore(results);
        int count = Math.min(n, sorted.size());
        List<PairResult> topPairs = new ArrayList<PairResult>();
        for (int i = 0; i < count; i++) {
            topPairs.add(sorted.get(i));
        }
        return topPairs;
    }
}
