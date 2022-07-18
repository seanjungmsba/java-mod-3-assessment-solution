package com.jaymansmann.io;

import javax.swing.*;

public class SimpleSwingUserOutputService implements UserOutputService {

    @Override
    public void displayText(String text) {
        JOptionPane.showMessageDialog(null, text);
    }

    @Override
    public void displayErrorText(String text) {
        JOptionPane.showMessageDialog(null, text, "ERROR!", JOptionPane.ERROR_MESSAGE);
    }

}
