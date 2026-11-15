package com.copycheck.engine;

import com.copycheck.model.PairResult;
import java.util.List;

/**
 * Sorts pair results from most to least similar.
 */
public final class Ranker {

    private Ranker() {
    }

    /**
     * Sorts by the given measure, highest first; ties by first then second document name.
     *
     * @param results     results to sort (not modified)
     * @param measureName measure to sort by
     * @return new sorted list
     * @throws IllegalArgumentException if a result lacks that measure
     */
    public static List<PairResult> rank(List<PairResult> results, String measureName) {
        throw new UnsupportedOperationException("Not implemented yet - see CC-09");
    }

    /**
     * Returns the n most similar pairs.
     *
     * @param results     results to rank
     * @param measureName measure to sort by
     * @param n           how many to return, at least 1
     * @return at most n results
     */
    public static List<PairResult> top(List<PairResult> results, String measureName, int n) {
        throw new UnsupportedOperationException("Not implemented yet - see CC-09");
    }
}
