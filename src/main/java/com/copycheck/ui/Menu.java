package com.copycheck.ui;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Menu-driven console interface.
 */
public class Menu {

    private final Scanner in;
    private final PrintStream out;

    /**
     * Creates the menu.
     *
     * @param in  input source
     * @param out output destination
     */
    public Menu(Scanner in, PrintStream out) {
        this.in = in;
        this.out = out;
    }

    /**
     * Runs the menu loop until the user exits.
     */
    public void run() {
        out.println("CopyCheck - menu coming in CC-08");
    }
}
