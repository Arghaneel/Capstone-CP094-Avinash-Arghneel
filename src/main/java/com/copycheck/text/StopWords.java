package com.copycheck.text;

import java.util.Set;

/**
 * Fixed list of common English words that are ignored during comparison.
 * Words are stored in normalised form: lowercase, no apostrophes.
 */
public final class StopWords {

    private StopWords() {
    }

    /**
     * Checks whether a normalised word is a stop word.
     *
     * @param word lowercase word without punctuation
     * @return true if the word should be ignored
     */
    public static boolean isStopWord(String word) {
        throw new UnsupportedOperationException("Not implemented yet - see CC-04");
    }

    /**
     * Returns every stop word.
     *
     * @return unmodifiable set of stop words
     */
    public static Set<String> all() {
        throw new UnsupportedOperationException("Not implemented yet - see CC-04");
    }
}
