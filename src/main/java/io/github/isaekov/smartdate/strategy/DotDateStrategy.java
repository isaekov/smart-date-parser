package io.github.isaekov.smartdate.strategy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DotDateStrategy implements DateParseStrategy {


    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd.MM.yyyy");

    @Override
    public boolean supports(String input) {
        return input.matches("\\d{2}\\.\\d{2}\\.\\d{4}");
    }

    @Override
    public LocalDate parse(String input) {
        return LocalDate.parse(input, FORMATTER);
    }
}
