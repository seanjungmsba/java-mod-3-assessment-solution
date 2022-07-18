package com.jaymansmann.io;

public interface MenuItem {
    String getShortcut();

    String getLabel();

    default boolean matches(String userInput) {
        return this.getShortcut().equalsIgnoreCase(userInput.trim()) || this.getLabel().trim().equalsIgnoreCase(userInput.trim());
    }
}
