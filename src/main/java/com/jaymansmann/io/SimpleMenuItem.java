package com.jaymansmann.io;

public class SimpleMenuItem implements  MenuItem {
    private String shortcut;
    private String label;

    public SimpleMenuItem(String shortcut, String label) {
        this.shortcut = shortcut;
        this.label = label;
    }

    public SimpleMenuItem(String shortcut) {
        this.shortcut = shortcut;
        this.label = "";
    }

    @Override
    public String getShortcut() {
        return this.shortcut;
    }

    @Override
    public String getLabel() {
        return this.label;
    }
}
