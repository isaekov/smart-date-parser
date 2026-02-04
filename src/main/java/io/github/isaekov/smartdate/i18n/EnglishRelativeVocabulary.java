package io.github.isaekov.smartdate.i18n;

import java.util.Set;

public class EnglishRelativeVocabulary implements RelativeDateVocabulary  {

    @Override
    public Set<String> today() {
        return Set.of("today");
    }

    @Override
    public Set<String> yesterday() {
        return Set.of("yesterday");
    }

    @Override
    public Set<String> tomorrow() {
        return Set.of("tomorrow");
    }

    @Override
    public Set<String> dayUnits() {
        return Set.of("day", "days");
    }

    @Override
    public Set<String> weekUnits() {
        return Set.of("week", "weeks");
    }

}
