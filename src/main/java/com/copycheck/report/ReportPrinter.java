package com.copycheck.report;

import com.copycheck.model.PairResult;
import java.io.PrintStream;
import java.util.List;

/**
 * Formats pair results as a readable plain-text report.
 */
public class ReportPrinter {

    /**
     * Builds the full report text.
     *
     * @param results comparison results
     * @return report text
     */
    public String render(List<PairResult> results) {
        throw new UnsupportedOperationException("Not implemented yet - see CC-07");
    }

    /**
     * Prints the report.
     *
     * @param results comparison results
     * @param out     destination
     */
    public void print(List<PairResult> results, PrintStream out) {
        out.print(render(results));
    }
}
