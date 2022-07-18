package com.jaymansmann.io;

import com.jaymansmann.io.validation.ContainsValidationRule;
import com.jaymansmann.io.validation.InputValidationRule;
import com.jaymansmann.io.validation.Validator;
import com.jaymansmann.model.exception.DataException;

import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

public class ConsoleUserInputService implements UserInputService {
    private final Scanner scanner;
    private final UserOutputService userOutputService;

    public ConsoleUserInputService(UserOutputService userOutputService) {
        this.scanner = new Scanner(System.in);
        this.userOutputService = userOutputService;
    }

    @Override
    public String getInput(String prompt, InputValidationRule... validationRules) {
        this.userOutputService.displayText(prompt);
        String input = scanner.nextLine();
        Stack<String> violations = Validator.getViolations(input, validationRules);
        if (violations.isEmpty()) {
            return input;
        } else {
            violations.forEach(violation -> this.userOutputService.displayErrorText("'" + input + "' is invalid: " + violation));
            return getInput(prompt, validationRules);
        }
    }

    @Override
    public String getOption(String prompt, Set<MenuItem> options) {
        return getInput(prompt + "\n\t" + options.stream().map(item -> item.getLabel() + " [" + item.getShortcut() + "]").collect(Collectors.joining("\n\t")), new ContainsValidationRule(options.stream().map(MenuItem::getShortcut).collect(Collectors.toSet())));
    }

    @Override
    public void close() throws Exception {
        this.scanner.close();
    }
}
