package com.copycheck.model;

import java.util.Objects;

/**
 * One text input (a submission) with a display name and its raw text.
 *
 * @param name display name, for example the file name; never blank
 * @param text raw, unmodified text; never null
 */
public record Document(String name, String text) {

    /**
     * Validates the fields.
     */
    public Document {
        Objects.requireNonNull(name, "name must not be null");
        Objects.requireNonNull(text, "text must not be null");
        if (name.isBlank()) {
            throw new IllegalArgumentException("Document name must not be blank");
        }
    }
}
