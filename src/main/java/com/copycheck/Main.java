package com.copycheck;

import com.copycheck.ui.Menu;
import java.util.Scanner;

/**
 * Entry point for the CopyCheck console application.
 */
public final class Main {

    private Main() {
    }

    /**
     * Starts the interactive menu.
     *
     * @param args command-line arguments (unused)
     */
    public static void main(String[] args) {
        new Menu(new Scanner(System.in), System.out).run();
    }
}
