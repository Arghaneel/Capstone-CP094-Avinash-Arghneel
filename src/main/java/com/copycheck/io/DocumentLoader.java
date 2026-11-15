package com.copycheck.io;

import com.copycheck.model.Document;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

/**
 * Creates Document objects from typed text, single files, and folders.
 */
public class DocumentLoader {

    /**
     * Creates a document from text the user typed or pasted.
     *
     * @param name display name
     * @param text the text
     * @return the document
     * @throws IllegalArgumentException if name or text is blank
     */
    public Document fromText(String name, String text) {
        throw new UnsupportedOperationException("Not implemented yet - see CC-03");
    }

    /**
     * Reads lines from the scanner until a line equal to END (case-insensitive, trimmed).
     *
     * @param scanner input source
     * @return the lines joined with newline characters, END excluded
     */
    public String readMultiline(Scanner scanner) {
        throw new UnsupportedOperationException("Not implemented yet - see CC-03");
    }

    /**
     * Loads one .txt file as UTF-8. The document name is the file name.
     *
     * @param path path to a .txt file
     * @return the document
     * @throws IllegalArgumentException if the path is missing, is a folder, is not .txt, or is blank
     * @throws IOException if reading fails
     */
    public Document fromFile(Path path) throws IOException {
        throw new UnsupportedOperationException("Not implemented yet - see CC-03");
    }

    /**
     * Loads every .txt file directly inside a folder, sorted by file name; blank files are skipped.
     *
     * @param folder folder path
     * @return the documents, possibly empty
     * @throws IllegalArgumentException if the folder is missing or not a folder
     * @throws IOException if reading fails
     */
    public List<Document> fromFolder(Path folder) throws IOException {
        throw new UnsupportedOperationException("Not implemented yet - see CC-03");
    }
}
