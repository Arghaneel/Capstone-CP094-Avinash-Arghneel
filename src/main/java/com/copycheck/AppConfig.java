package com.copycheck;

import com.copycheck.similarity.SimilarityMeasure;
import com.copycheck.similarity.WordFrequencySimilarity;
import java.nio.file.Path;
import java.util.List;

/**
 * Central place for every tunable setting in CopyCheck.
 */
public final class AppConfig {

    /** Folder where saved reports are written. */
    public static final Path REPORTS_DIR = Path.of("reports");

    /** A sentence needs at least this many content words to count as a common sentence. */
    public static final int MIN_SENTENCE_WORDS = 3;

    /** Default number of pairs shown by the ranking feature. */
    public static final int DEFAULT_TOP_N = 5;

    /** Scores at or above this value (0..1) are MODERATE. */
    public static final double MODERATE_THRESHOLD = 0.40;

    /** Scores at or above this value (0..1) are HIGH. */
    public static final double HIGH_THRESHOLD = 0.70;

    private AppConfig() {
    }

    /**
     * Returns the similarity measures used for every comparison, in display order.
     * The first measure is the primary one used for the verdict.
     *
     * @return ordered list of measures
     */
    public static List<SimilarityMeasure> measures() {
        return List.of(new WordFrequencySimilarity());
    }
}
