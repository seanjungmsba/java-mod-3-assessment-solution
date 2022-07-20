package com.seanjung.io.validation;

import java.util.Set;

public class ContainsValidationRule implements InputValidationRule {
    private final Set<String> options;

    public ContainsValidationRule(Set<String> options) {
        this.options = options;
    }

    @Override
    public boolean isValid(String input) {
        return this.options.contains(input);
    }

    @Override
    public String getDescription() {
        return "INPUT MUST BE ONE OF " + options;
    }
}
