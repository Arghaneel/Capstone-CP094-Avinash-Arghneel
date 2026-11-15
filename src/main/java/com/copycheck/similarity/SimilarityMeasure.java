package com.copycheck.similarity;

import java.util.List;

/**
 * A way of scoring how similar two token lists are (Strategy pattern).
 */
public interface SimilarityMeasure {

    /**
     * Returns the name shown as a column heading in reports.
     *
     * @return display name, unique among measures
     */
    String name();

    /**
     * Scores two token lists.
     *
     * @param tokensA content words of the first document
     * @param tokensB content words of the second document
     * @return similarity in the range 0..1, where 1 means identical
     */
    double compute(List<String> tokensA, List<String> tokensB);
}
