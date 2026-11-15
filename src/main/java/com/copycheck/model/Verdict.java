package com.copycheck.model;

/**
 * Human-readable classification of a similarity score.
 */
public enum Verdict {

    /** Below the moderate threshold. */
    LOW("LOW - likely original"),

    /** Between the moderate and high thresholds. */
    MODERATE("MODERATE - review recommended"),

    /** At or above the high threshold. */
    HIGH("HIGH - likely copied");

    private final String label;

    Verdict(String label) {
        this.label = label;
    }

    /**
     * Returns the label printed in reports.
     *
     * @return display label
     */
    public String label() {
        return label;
    }

    /**
     * Classifies a score using AppConfig.MODERATE_THRESHOLD and AppConfig.HIGH_THRESHOLD.
     *
     * @param score similarity in the range 0..1
     * @return the matching verdict
     */
    public static Verdict fromScore(double score) {
        throw new UnsupportedOperationException("Not implemented yet - see CC-07");
    }
}
