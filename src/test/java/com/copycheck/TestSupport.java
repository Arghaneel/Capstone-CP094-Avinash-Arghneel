package com.copycheck;

import java.util.Objects;

/**
 * Minimal assertion helpers so the project needs no external test library.
 */
public final class TestSupport {

    private static int passed;
    private static int failed;
    private static String currentClass = "";

    private TestSupport() {
    }

    /**
     * Marks the start of a test class (prints a heading).
     *
     * @param name test class name
     */
    public static void startClass(String name) {
        currentClass = name;
        System.out.println("\n== " + name);
    }

    /**
     * Records a pass or a failure.
     *
     * @param description what is being checked
     * @param condition   true if the check passed
     */
    public static void check(String description, boolean condition) {
        if (condition) {
            passed++;
            System.out.println("  PASS  " + description);
        } else {
            failed++;
            System.out.println("  FAIL  " + description);
        }
    }

    /**
     * Checks equality using Objects.equals.
     *
     * @param description what is being checked
     * @param expected    expected value
     * @param actual      actual value
     */
    public static void assertEquals(String description, Object expected, Object actual) {
        boolean ok = Objects.equals(expected, actual);
        check(ok ? description : description + " (expected <" + expected + "> but was <" + actual + ">)", ok);
    }

    /**
     * Checks that two doubles are within a tolerance.
     *
     * @param description what is being checked
     * @param expected    expected value
     * @param actual      actual value
     * @param tolerance   allowed difference
     */
    public static void assertClose(String description, double expected, double actual, double tolerance) {
        boolean ok = Math.abs(expected - actual) <= tolerance;
        check(ok ? description : description + " (expected " + expected + " +/- " + tolerance + " but was " + actual + ")", ok);
    }

    /**
     * Checks that an action throws the given exception type.
     *
     * @param description what is being checked
     * @param type        expected exception type
     * @param action      code that should throw
     */
    public static void assertThrows(String description, Class<? extends Throwable> type, Runnable action) {
        try {
            action.run();
            check(description + " (nothing was thrown)", false);
        } catch (Throwable t) {
            check(type.isInstance(t) ? description : description + " (threw " + t + ")", type.isInstance(t));
        }
    }

    static void recordCrash(String testClass, Throwable t) {
        failed++;
        System.out.println("  CRASH " + testClass + ": " + t);
    }

    static void printSummary() {
        System.out.println("\n========================================");
        System.out.println("Tests passed: " + passed + ", failed: " + failed);
        System.out.println(failed == 0 ? "ALL TESTS PASSED" : "SOME TESTS FAILED");
    }

    static int failures() {
        return failed;
    }

    static String currentClass() {
        return currentClass;
    }
}
