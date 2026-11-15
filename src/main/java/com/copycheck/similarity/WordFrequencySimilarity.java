package com.copycheck.similarity;

import java.util.List;
import java.util.Map;

/**
 * Cosine similarity between word-frequency vectors.
 */
public class WordFrequencySimilarity implements SimilarityMeasure {

    /** Display name of this measure. */
    public static final String NAME = "Word frequency";

    @Override
    public String name() {
        return NAME;
    }

    @Override
    public double compute(List<String> tokensA, List<String> tokensB) {
        throw new UnsupportedOperationException("Not implemented yet - see CC-05");
    }

    /**
     * Counts how often each word occurs.
     *
     * @param tokens words
     * @return word to count
     */
    public static Map<String, Integer> frequencies(List<String> tokens) {
        throw new UnsupportedOperationException("Not implemented yet - see CC-05");
    }
}
