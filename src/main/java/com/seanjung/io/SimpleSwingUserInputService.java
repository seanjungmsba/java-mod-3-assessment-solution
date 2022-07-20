package com.seanjung.io;

import com.seanjung.io.validation.InputValidationRule;
import com.seanjung.io.validation.Validator;

import javax.swing.*;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

public class SimpleSwingUserInputService implements UserInputService {

    @Override
    public String getInput(String prompt, InputValidationRule... validationRules) {
        String input = JOptionPane.showInputDialog(null, prompt);
        Stack<String> violations = Validator.getViolations(input, validationRules);
        if (violations.isEmpty()) {
            return input;
        } else {
            String violationText = violations.stream().map(violation -> "'" + prompt + "'' is invalid: " + violation).collect(Collectors.joining("<br>"));
            JOptionPane.showMessageDialog(null, violationText, "INVALID!", JOptionPane.WARNING_MESSAGE);
            return getInput(prompt, validationRules);
        }
    }

    @Override
    public String getOption(String prompt, Set<MenuItem> options) {
        Object[] items = options.toArray();
        MenuItem choice = (MenuItem) (items[JOptionPane.showOptionDialog(null, prompt, "Choose",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, items, items[0])]);
        return choice.getShortcut();
    }

    @Override
    public void close() throws Exception {
        // NO OP
    }

}
