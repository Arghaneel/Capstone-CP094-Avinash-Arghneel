package com.copycheck.report;

import com.copycheck.model.PairResult;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

/**
 * Saves reports to .txt and .csv files.
 */
public class ReportWriter {

    /**
     * Writes the plain-text report to a timestamped .txt file, creating the folder if needed.
     *
     * @param results comparison results
     * @param folder  destination folder
     * @return path of the written file
     * @throws IOException if writing fails
     */
    public Path writeText(List<PairResult> results, Path folder) throws IOException {
        throw new UnsupportedOperationException("Not implemented yet - see CC-11");
    }

    /**
     * Writes one CSV row per pair to a timestamped .csv file, creating the folder if needed.
     *
     * @param results comparison results
     * @param folder  destination folder
     * @return path of the written file
     * @throws IOException if writing fails
     */
    public Path writeCsv(List<PairResult> results, Path folder) throws IOException {
        throw new UnsupportedOperationException("Not implemented yet - see CC-11");
    }
}
