package com.copycheck.model;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * The outcome of comparing two documents.
 *
 * @param first           first document of the pair
 * @param second          second document of the pair
 * @param scores          measure name to score in the range 0..1, in display order;
 *                        the first entry is the primary score
 * @param commonSentences sentences found in both documents
 */
public record PairResult(Document first, Document second,
                         Map<String, Double> scores,
                         List<SentenceMatch> commonSentences) {

    /**
     * Validates the fields and makes defensive, order-preserving copies.
     */
    public PairResult {
        Objects.requireNonNull(first, "first must not be null");
        Objects.requireNonNull(second, "second must not be null");
        Objects.requireNonNull(scores, "scores must not be null");
        Objects.requireNonNull(commonSentences, "commonSentences must not be null");
        if (scores.isEmpty()) {
            throw new IllegalArgumentException("At least one score is required");
        }
        scores = Collections.unmodifiableMap(new LinkedHashMap<>(scores));
        commonSentences = List.copyOf(commonSentences);
    }

    /**
     * Returns the score of the first (primary) measure.
     *
     * @return primary score in the range 0..1
     */
    public double primaryScore() {
        return scores.values().iterator().next();
    }

    /**
     * Returns the score for a given measure.
     *
     * @param measureName name returned by SimilarityMeasure.name()
     * @return score in the range 0..1
     * @throws IllegalArgumentException if this result has no such measure
     */
    public double score(String measureName) {
        Double value = scores.get(measureName);
        if (value == null) {
            throw new IllegalArgumentException("Unknown measure: " + measureName);
        }
        return value;
    }
}
