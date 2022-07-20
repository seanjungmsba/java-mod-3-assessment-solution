package com.seanjung.io.validation;

import java.util.Optional;
import java.util.function.Predicate;

public class BlankValidationRule implements InputValidationRule {

    @Override
    public boolean isValid(String input) {
        return Optional.ofNullable(input).filter(Predicate.not(String::isBlank)).isPresent();
    }

    @Override
    public String getDescription() {
        return "BLANK INPUT NOT ALLOWED";
    }

}
