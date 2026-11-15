package com.copycheck.text;

import java.util.List;

/**
 * Turns raw text into a clean, comparable form.
 */
public class TextNormalizer {

    /**
     * Lowercases the text, deletes apostrophes, replaces every other non-letter,
     * non-digit character with a space, collapses whitespace and trims.
     *
     * @param text raw text, may be null
     * @return normalised text, never null
     */
    public String normalize(String text) {
        throw new UnsupportedOperationException("Not implemented yet - see CC-04");
    }

    /**
     * Normalises the text, splits it into words and removes stop words.
     * Order and duplicates are kept.
     *
     * @param text raw text, may be null
     * @return content words, never null
     */
    public List<String> tokenize(String text) {
        throw new UnsupportedOperationException("Not implemented yet - see CC-04");
    }
}
