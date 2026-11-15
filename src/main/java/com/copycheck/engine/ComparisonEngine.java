package com.copycheck.engine;

import com.copycheck.model.Document;
import com.copycheck.model.PairResult;
import com.copycheck.similarity.SentenceMatcher;
import com.copycheck.similarity.SimilarityMeasure;
import com.copycheck.text.TextNormalizer;
import java.util.List;

/**
 * Compares every pair of documents with every configured measure.
 */
public class ComparisonEngine {

    private final TextNormalizer normalizer;
    private final List<SimilarityMeasure> measures;
    private final SentenceMatcher sentenceMatcher;

    /**
     * Creates the engine.
     *
     * @param normalizer      text normaliser
     * @param measures        measures in display order; the first is primary
     * @param sentenceMatcher common-sentence finder
     */
    public ComparisonEngine(TextNormalizer normalizer, List<SimilarityMeasure> measures,
                            SentenceMatcher sentenceMatcher) {
        this.normalizer = normalizer;
        this.measures = List.copyOf(measures);
        this.sentenceMatcher = sentenceMatcher;
    }

    /**
     * Compares two documents.
     *
     * @param a first document
     * @param b second document
     * @return the result
     */
    public PairResult compare(Document a, Document b) {
        throw new UnsupportedOperationException("Not implemented yet - see CC-07");
    }

    /**
     * Compares every unordered pair (i &lt; j) in load order.
     *
     * @param documents at least two documents
     * @return n(n-1)/2 results
     * @throws IllegalArgumentException if fewer than two documents are given
     */
    public List<PairResult> compareAll(List<Document> documents) {
        throw new UnsupportedOperationException("Not implemented yet - see CC-07");
    }
}
