package io.github.isaekov.smartdate;

import io.github.isaekov.smartdate.exception.DateParseException;
import io.github.isaekov.smartdate.strategy.DateParseStrategy;
import io.github.isaekov.smartdate.strategy.DotDateStrategy;
import io.github.isaekov.smartdate.strategy.IsoDateStrategy;
import io.github.isaekov.smartdate.strategy.RelativeDateStrategy;
import java.time.LocalDate;
import java.util.List;

public final class SmartDateParser {

    private static final List<DateParseStrategy> STRATEGIES = List.of(
            new IsoDateStrategy(),
            new DotDateStrategy(),
            new RelativeDateStrategy()
    );

    public static LocalDate parse(String input) {
        return STRATEGIES.stream()
                .filter(s -> s.supports(input))
                .findFirst()
                .map(s -> s.parse(input))
                .orElseThrow(() ->
                        new DateParseException("Unsupported date format: " + input)
                );
    }
}
