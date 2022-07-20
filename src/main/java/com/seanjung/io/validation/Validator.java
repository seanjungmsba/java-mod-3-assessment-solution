package com.seanjung.io.validation;

import java.util.Stack;

public class Validator {
    private Validator() {
    } // Don't implement

    public static Stack<String> getViolations(String input, InputValidationRule... validationRules) {
        Stack<String> violations = new Stack<>();
        for (InputValidationRule rule : validationRules) {
            if (!rule.isValid(input)) {
                violations.push(rule.getDescription());
            }
        }
        return violations;

    }
}
