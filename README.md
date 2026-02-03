# Smart Date Parser

Небольшая Java-утилита для преобразования удобочитаемых строк даты в `java.time.LocalDate`.

Библиотека работает с разными форматами дат и временными выражениями благодаря простой и гибкой архитектуре

## Особенности

- ISO dates (`2024-01-10`)
- Dot-separated dates (`10.01.2024`)
- Relative dates:
    - `today`
    - `yesterday`
    - `tomorrow`
    - `+3 days`
    - `-1 week`
- Отсутствие внешних зависимостей
- Совместимость с Java 17
- Легко расширяется с помощью шаблона стратегии


## Использование

```java
LocalDate date1 = SmartDateParser.parse("2024-01-10");
LocalDate date2 = SmartDateParser.parse("10.01.2024");
LocalDate date3 = SmartDateParser.parse("today");
LocalDate date4 = SmartDateParser.parse("+3 days");
```

Каждый формат даты реализуется как отдельная стратегия

Чтобы добавить новый формат, просто реализуйте DateParseStrategy
и зарегистрируйте его в SmartDateParser.

### Requirements

Java 17+
Gradle

### Мотивация

Синтаксический анализ дат в Java часто приводит к ошибкам из-за множества форматов
и удобных для пользователя входных данных

  