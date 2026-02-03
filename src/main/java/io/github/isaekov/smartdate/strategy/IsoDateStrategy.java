package io.github.isaekov.smartdate.strategy;

import java.time.LocalDate;

public class IsoDateStrategy implements DateParseStrategy {

    @Override
    public boolean supports(String input) {
        return input.matches("\\d{4}-\\d{2}-\\d{2}");
    }

    @Override
    public LocalDate parse(String input) {
        return LocalDate.parse(input);
    }
}
