package com.copycheck.similarity;

import java.util.List;
import java.util.Set;

/**
 * Jaccard similarity between sets of n-word sequences (shingles).
 */
public class NGramSimilarity implements SimilarityMeasure {

    private final int n;

    /**
     * Creates the measure.
     *
     * @param n sequence length, at least 1
     */
    public NGramSimilarity(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("n must be at least 1");
        }
        this.n = n;
    }

    @Override
    public String name() {
        return n + "-word sequences";
    }

    @Override
    public double compute(List<String> tokensA, List<String> tokensB) {
        throw new UnsupportedOperationException("Not implemented yet - see CC-10");
    }

    /**
     * Builds every run of n consecutive tokens, joined by single spaces.
     *
     * @param tokens words
     * @param n      sequence length, at least 1
     * @return set of n-grams
     */
    public static Set<String> ngrams(List<String> tokens, int n) {
        throw new UnsupportedOperationException("Not implemented yet - see CC-10");
    }
}
