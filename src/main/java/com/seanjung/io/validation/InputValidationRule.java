package com.seanjung.io.validation;

public interface InputValidationRule {
    boolean isValid(String input);

    String getDescription();
}
