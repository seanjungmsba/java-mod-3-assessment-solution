package com.jaymansmann.view;

import com.jaymansmann.io.MenuItem;

import java.awt.*;
import java.util.Set;
import java.util.stream.Collectors;

public enum MainMenuItem implements MenuItem {
    ADD_DOCTOR("Add Doctor", "D"), ADD_PATIENT("Add Patient", "P"), TREAT_PATIENT("Treat Patient", "T"), SHOW_WORLD("Show World", "S"), QUIT("Quit", "Q");
    private String label;
    private String shortcut;

    MainMenuItem(String label, String shortcut) {
        this.label = label;
        this.shortcut = shortcut;
    }

    public String getDisplay() {
        return this.label + " [" + shortcut + "]";
    }

    public boolean matches(String userInput) {
        return this.getDisplay().equalsIgnoreCase(userInput.trim()) || this.label.trim().equalsIgnoreCase(userInput.trim()) || this.shortcut.trim().equalsIgnoreCase(userInput.trim());
    }

    public String getShortcut() {
        return shortcut;
    }

    @Override
    public String getLabel() {
        return label;
    }

    public static Set<MenuItem> getOptions() {
        return Set.of(values());
    }
}
