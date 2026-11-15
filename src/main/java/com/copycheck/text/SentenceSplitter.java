package com.copycheck.text;

import java.util.List;

/**
 * Splits raw text into sentences.
 */
public class SentenceSplitter {

    /**
     * Splits after '.', '!' or '?' followed by whitespace, and at blank lines.
     * Each sentence is trimmed with internal whitespace collapsed; empty pieces are dropped.
     *
     * @param text raw text, may be null
     * @return sentences in order, never null
     */
    public List<String> split(String text) {
        throw new UnsupportedOperationException("Not implemented yet - see CC-04");
    }
}
