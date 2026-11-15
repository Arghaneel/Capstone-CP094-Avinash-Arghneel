package com.copycheck.model;

import java.util.Objects;

/**
 * A sentence that appears in both documents of a pair.
 *
 * @param sentenceA the sentence as written in the first document
 * @param sentenceB the matching sentence as written in the second document
 */
public record SentenceMatch(String sentenceA, String sentenceB) {

    /**
     * Validates the fields.
     */
    public SentenceMatch {
        Objects.requireNonNull(sentenceA, "sentenceA must not be null");
        Objects.requireNonNull(sentenceB, "sentenceB must not be null");
    }
}
