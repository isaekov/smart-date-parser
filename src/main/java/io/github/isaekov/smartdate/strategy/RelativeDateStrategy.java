package io.github.isaekov.smartdate.strategy;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RelativeDateStrategy implements DateParseStrategy {

    private static final Pattern RELATIVE_PATTERN =
            Pattern.compile("([+-]\\d+)\\s*(day|days|week|weeks)");

    @Override
    public boolean supports(String input) {
        String value = input.trim().toLowerCase();

        return value.equals("today")
                || value.equals("yesterday")
                || value.equals("tomorrow")
                || RELATIVE_PATTERN.matcher(value).matches();
    }

    @Override
    public LocalDate parse(String input) {
        String value = input.trim().toLowerCase();

        return switch (value) {
            case "today" -> LocalDate.now();
            case "yesterday" -> LocalDate.now().minusDays(1);
            case "tomorrow" -> LocalDate.now().plusDays(1);
            default -> parseRelative(value);
        };
    }

    private LocalDate parseRelative(String value) {
        Matcher matcher = RELATIVE_PATTERN.matcher(value);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid relative date: " + value);
        }

        int amount = Integer.parseInt(matcher.group(1));
        String unit = matcher.group(2);

        return switch (unit) {
            case "day", "days" -> LocalDate.now().plusDays(amount);
            case "week", "weeks" -> LocalDate.now().plusWeeks(amount);
            default -> throw new IllegalStateException("Unexpected unit: " + unit);
        };
    }
}
