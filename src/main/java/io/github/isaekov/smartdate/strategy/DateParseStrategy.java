package io.github.isaekov.smartdate.strategy;

import java.time.LocalDate;

public interface DateParseStrategy {

    boolean supports(String input);

    LocalDate parse(String input);
}
