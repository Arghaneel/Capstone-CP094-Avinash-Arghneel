# CopyCheck - rules for AI coding agents

This file is read by AI coding agents (Antigravity, Claude Code and others). Every GitHub issue repeats these rules inside its prompt, so they apply even if your agent does not read this file.

PROJECT RULES (follow every rule):
1. Project: CopyCheck, a menu-driven Java console application that measures how similar text submissions are (capstone problem "CopyCheck: Text Similarity and Plagiarism Detection Engine").
2. Language: Java 17. Use ONLY the Java standard library. No Maven, Gradle, external JARs, JUnit, Lombok, or text/NLP libraries (Apache Commons, OpenNLP, Lucene, etc.).
3. Console only: no GUI (Swing/JavaFX/AWT), no web server, no database. The only allowed file output is .txt and .csv.
4. Layout: base package com.copycheck. Production code goes in src/main/java/com/copycheck/..., tests in src/test/java/com/copycheck/... in the same package as the class under test.
5. The public classes, records and method signatures already in the repository are the shared team contract. Do not rename, remove or change their signatures. You may add private helpers. Add new public methods or constructors only if this issue explicitly says so.
6. Only create or modify the files listed under FILES in this task. If you believe another file must change, STOP and explain why instead of changing it.
7. Only com.copycheck.ui.Menu (and ReportPrinter.print, which receives a PrintStream) may print to the console. Every other class returns values or throws exceptions; it never calls System.out, System.err or System.exit.
8. Invalid input must never crash the program with a stack trace. Library classes throw IllegalArgumentException with a clear, user-friendly message; the Menu catches it and prints it.
9. Always pass Locale.ROOT to toLowerCase/toUpperCase/String.format. Read and write files as UTF-8.
10. Style: 4-space indentation, no tabs, no wildcard imports, descriptive names, small focused methods, Javadoc on every public class, constructor and method, constants in UPPER_SNAKE_CASE. Tunable values live in com.copycheck.AppConfig, never as magic numbers.
11. Tests: no JUnit. Write a final class named <Something>Test with a private constructor and `public static void run()` that uses the static helpers in com.copycheck.TestSupport (check, assertEquals, assertClose, assertThrows). TestRunner discovers *Test classes automatically, so never edit TestRunner or TestSupport.
12. Build and test with ./build.sh and ./test.sh (Windows: build.bat and test.bat). Before you finish, the build must print "Build OK" and the tests must print "ALL TESTS PASSED".
13. Do not run any git commands (no branch, commit, push or merge). The developer reviews your changes and opens the pull request.

## Project map

```
src/main/java/com/copycheck/
  Main.java                      entry point -> ui.Menu
  AppConfig.java                 all tunable settings + list of similarity measures
  model/   Document, SentenceMatch, PairResult, Verdict
  io/      DocumentLoader        typed text, single .txt file, folder of .txt files
  text/    StopWords, TextNormalizer, SentenceSplitter
  similarity/ SimilarityMeasure (interface), WordFrequencySimilarity (cosine),
              NGramSimilarity (3-word sequences, Jaccard), SentenceMatcher
  engine/  ComparisonEngine (all pairs), Ranker (top pairs)
  report/  ReportPrinter (console text), ReportWriter (.txt / .csv files)
  ui/      Menu (the only class that reads input / prints)
src/test/java/com/copycheck/
  TestSupport, TestRunner        tiny built-in test framework (do not edit)
  .../*Test.java                 one test class per production class
samples/                         test data (basic, submissions, edge)
```

## Data flow

```
Document(raw text) -> TextNormalizer.tokenize -> SimilarityMeasure.compute (each measure)
                   -> SentenceSplitter + SentenceMatcher.findCommon
                   -> PairResult -> ReportPrinter / Ranker / ReportWriter
```

## Commands

| Task | Linux / macOS / Git Bash | Windows cmd |
|---|---|---|
| Build | `./build.sh` | `build.bat` |
| Test | `./test.sh` | `test.bat` |
| Run | `./run.sh` | `run.bat` |
