package io.github.isaekov.smartdate.strategy;

import io.github.isaekov.smartdate.i18n.RelativeDateVocabulary;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RelativeDateStrategy implements DateParseStrategy {

    private final RelativeDateVocabulary vocabulary;

    private static final Pattern AMOUNT_PATTERN =
            Pattern.compile("([+-]\\d+)\\s*(\\p{L}+)");

    public RelativeDateStrategy(RelativeDateVocabulary vocabulary) {
        this.vocabulary = vocabulary;
    }

    @Override
    public boolean supports(String input) {
        String value = normalize(input);

        return vocabulary.today().contains(value)
                || vocabulary.yesterday().contains(value)
                || vocabulary.tomorrow().contains(value)
                || isRelativeExpression(value);
    }

    @Override
    public LocalDate parse(String input) {
        String value = normalize(input);

        if (vocabulary.today().contains(value)) {
            return LocalDate.now();
        }
        if (vocabulary.yesterday().contains(value)) {
            return LocalDate.now().minusDays(1);
        }
        if (vocabulary.tomorrow().contains(value)) {
            return LocalDate.now().plusDays(1);
        }

        return parseRelative(value);
    }

    private LocalDate parseRelative(String value) {
        Matcher matcher = AMOUNT_PATTERN.matcher(value);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid relative date: " + value);
        }

        int amount = Integer.parseInt(matcher.group(1));
        String unit = matcher.group(2);

        if (vocabulary.dayUnits().contains(unit)) {
            return LocalDate.now().plusDays(amount);
        }
        if (vocabulary.weekUnits().contains(unit)) {
            return LocalDate.now().plusWeeks(amount);
        }

        throw new IllegalArgumentException("Unsupported time unit: " + unit);
    }

    private String normalize(String input) {
        return input.trim().toLowerCase();
    }

    private boolean isRelativeExpression(String value) {
        Matcher matcher = AMOUNT_PATTERN.matcher(value);
        return matcher.matches();
    }
}
