package io.github.isaekov.smartdate;

import io.github.isaekov.smartdate.i18n.EnglishRelativeVocabulary;
import io.github.isaekov.smartdate.strategy.DateParseStrategy;
import io.github.isaekov.smartdate.strategy.DotDateStrategy;
import io.github.isaekov.smartdate.strategy.IsoDateStrategy;
import io.github.isaekov.smartdate.strategy.RelativeDateStrategy;
import java.time.LocalDate;
import java.util.List;

public final class SmartDateParser {


    private final List<DateParseStrategy> strategies;

    private SmartDateParser(List<DateParseStrategy> strategies) {
        this.strategies = strategies;
    }

    public static SmartDateParser defaultParser() {
        return new SmartDateParser(List.of(
                new IsoDateStrategy(),
                new DotDateStrategy(),
                new RelativeDateStrategy(new EnglishRelativeVocabulary())
        ));
    }

    public LocalDate parse(String input) {
        return strategies.stream()
                .filter(s -> s.supports(input))
                .findFirst()
                .map(s -> s.parse(input))
                .orElseThrow(() ->
                        new IllegalArgumentException("Unsupported date format: " + input)
                );
    }
}
