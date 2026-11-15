package com.copycheck.similarity;

import com.copycheck.model.SentenceMatch;
import com.copycheck.text.SentenceSplitter;
import com.copycheck.text.TextNormalizer;
import java.util.List;

/**
 * Finds sentences that appear in both texts after normalisation.
 */
public class SentenceMatcher {

    private final TextNormalizer normalizer;
    private final SentenceSplitter splitter;

    /**
     * Creates a matcher with default helpers.
     */
    public SentenceMatcher() {
        this(new TextNormalizer(), new SentenceSplitter());
    }

    /**
     * Creates a matcher with the given helpers.
     *
     * @param normalizer text normaliser
     * @param splitter   sentence splitter
     */
    public SentenceMatcher(TextNormalizer normalizer, SentenceSplitter splitter) {
        this.normalizer = normalizer;
        this.splitter = splitter;
    }

    /**
     * Returns sentences present in both texts, in order of first appearance in textA.
     *
     * @param textA raw text of the first document
     * @param textB raw text of the second document
     * @return common sentences, never null
     */
    public List<SentenceMatch> findCommon(String textA, String textB) {
        throw new UnsupportedOperationException("Not implemented yet - see CC-06");
    }
}
