package com.seanjung.io;

import com.seanjung.io.validation.InputValidationRule;

import java.util.Set;

public interface UserInputService extends AutoCloseable {
    String getInput(String prompt, InputValidationRule... validationRules);
    String getOption(String prompt, Set<MenuItem> options);
}
