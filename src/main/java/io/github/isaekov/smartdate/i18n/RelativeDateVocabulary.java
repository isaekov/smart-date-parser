package io.github.isaekov.smartdate.i18n;

import java.util.Set;

public interface RelativeDateVocabulary {

    Set<String> today();
    Set<String> yesterday();
    Set<String> tomorrow();

    Set<String> dayUnits();
    Set<String> weekUnits();
}
