package com.copycheck;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Finds every compiled class whose name ends in "Test" and calls its static run() method.
 * New test classes are picked up automatically; never edit this file to register a test.
 */
public final class TestRunner {

    private TestRunner() {
    }

    /**
     * Runs all tests and exits with status 1 if any failed.
     *
     * @param args unused
     * @throws Exception if the class folder cannot be scanned
     */
    public static void main(String[] args) throws Exception {
        Path root = Path.of(TestRunner.class.getProtectionDomain().getCodeSource().getLocation().toURI());
        List<String> classNames;
        try (Stream<Path> files = Files.walk(root)) {
            classNames = files
                    .map(p -> root.relativize(p).toString())
                    .filter(name -> name.endsWith("Test.class") && !name.contains("$"))
                    .map(name -> name.substring(0, name.length() - ".class".length())
                            .replace(File.separatorChar, '.'))
                    .sorted()
                    .collect(Collectors.toList());
        }
        for (String className : classNames) {
            try {
                Method run = Class.forName(className).getMethod("run");
                TestSupport.startClass(className);
                run.invoke(null);
            } catch (InvocationTargetException e) {
                TestSupport.recordCrash(className, e.getCause());
            } catch (ReflectiveOperationException e) {
                TestSupport.recordCrash(className, e);
            }
        }
        TestSupport.printSummary();
        System.exit(TestSupport.failures() == 0 ? 0 : 1);
    }
}
