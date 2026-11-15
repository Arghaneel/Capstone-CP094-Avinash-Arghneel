package com.copycheck.model;

import static com.copycheck.TestSupport.assertClose;
import static com.copycheck.TestSupport.assertEquals;
import static com.copycheck.TestSupport.assertThrows;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Tests for the model records.
 */
public final class ModelTest {

    private ModelTest() {
    }

    /**
     * Runs all checks.
     */
    public static void run() {
        assertThrows("Document rejects blank name", IllegalArgumentException.class,
                () -> new Document("  ", "text"));
        assertThrows("Document rejects null text", NullPointerException.class,
                () -> new Document("a.txt", null));

        Document a = new Document("a.txt", "Hello");
        Document b = new Document("b.txt", "World");
        Map<String, Double> scores = new LinkedHashMap<>();
        scores.put("Word frequency", 0.8);
        scores.put("3-word sequences", 0.3);
        PairResult result = new PairResult(a, b, scores, List.of());

        assertClose("primaryScore is the first entry", 0.8, result.primaryScore(), 1e-9);
        assertClose("score(name) looks up by name", 0.3, result.score("3-word sequences"), 1e-9);
        assertEquals("score order is preserved", List.of("Word frequency", "3-word sequences"),
                List.copyOf(result.scores().keySet()));
        assertThrows("score(name) rejects unknown measure", IllegalArgumentException.class,
                () -> result.score("missing"));
        assertThrows("PairResult rejects empty scores", IllegalArgumentException.class,
                () -> new PairResult(a, b, Map.of(), List.of()));
    }
}
