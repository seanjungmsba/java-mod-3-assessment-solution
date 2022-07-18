package com.jaymansmann.io.validation;

public interface InputValidationRule {
    boolean isValid(String input);

    String getDescription();
}
