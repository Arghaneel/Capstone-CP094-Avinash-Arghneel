package com.copycheck;

import com.copycheck.model.Document;
import com.copycheck.model.PairResult;
import com.copycheck.report.ReportPrinter;
import com.copycheck.similarity.Ranker;
import java.util.ArrayList;
import java.util.List;

// Tests for Ranker (sorting and top pairs) and the ranking table.
public class RankerTest {

    // Runs every Ranker check.
    public static void run() {
        System.out.println("\nRankerTest");
        checkSort();
        checkTop();
        checkRanking();
    }

    // Three made-up results with word scores 0.2, 0.9 and 0.5, in that order.
    private static List<PairResult> makeResults() {
        List<PairResult> results = new ArrayList<PairResult>();
        results.add(makeResult("a.txt", "b.txt", 0.2));
        results.add(makeResult("a.txt", "c.txt", 0.9));
        results.add(makeResult("b.txt", "c.txt", 0.5));
        return results;
    }

    // One result between two small documents, with the given word score.
    private static PairResult makeResult(String nameA, String nameB, double wordScore) {
        Document first = new Document(nameA, "Some text.");
        Document second = new Document(nameB, "Other text.");
        return new PairResult(first, second, wordScore, 0.0, new ArrayList<String>());
    }

    // Highest score first, and the original list keeps its old order.
    private static void checkSort() {
        List<PairResult> results = makeResults();
        List<PairResult> sorted = Ranker.sortByWordScore(results);
        Check.close("sorted 1st is 0.9", 0.9, sorted.get(0).getWordScore());
        Check.close("sorted 2nd is 0.5", 0.5, sorted.get(1).getWordScore());
        Check.close("sorted 3rd is 0.2", 0.2, sorted.get(2).getWordScore());
        Check.close("original list still starts with 0.2", 0.2, results.get(0).getWordScore());
        Check.close("original list still has 0.9 second", 0.9, results.get(1).getWordScore());
        Check.close("original list still ends with 0.5", 0.5, results.get(2).getWordScore());
    }

    // top() gives at most n pairs, best first, and rejects n below 1.
    private static void checkTop() {
        List<PairResult> results = makeResults();
        List<PairResult> topTwo = Ranker.top(results, 2);
        Check.equal("top 2 has 2 results", 2, topTwo.size());
        Check.close("top 2 starts with 0.9", 0.9, topTwo.get(0).getWordScore());
        Check.equal("top 10 of 3 results gives 3", 3, Ranker.top(results, 10).size());
        try {
            Ranker.top(results, 0);
            Check.isTrue("top 0 is rejected", false);
        } catch (IllegalArgumentException expected) {
            Check.isTrue("top 0 is rejected", true);
        }
    }

    // The ranking has a title with the count and shows scores as percentages.
    private static void checkRanking() {
        String ranking = ReportPrinter.buildRanking(Ranker.top(makeResults(), 2));
        Check.isTrue("ranking title says Top 2 most similar pairs",
                ranking.contains("Top 2 most similar pairs"));
        Check.isTrue("ranking shows 90.00%", ranking.contains("90.00%"));
        Check.equal("ranking of an empty list", "No results to show.\n",
                ReportPrinter.buildRanking(new ArrayList<PairResult>()));
    }
}
