package com.github.jsonzou.jmockdata.mocker;

import com.github.jsonzou.jmockdata.DataConfig;
import com.github.jsonzou.jmockdata.Mocker;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Random;

import static java.time.format.DateTimeFormatter.ofPattern;

public class LocalDateTimeMocker implements Mocker<LocalDateTime> {

    private final static DateTimeFormatter DATE_FORMATTER = ofPattern("yyyy-MM-dd");

    @Override
    public LocalDateTime mock(DataConfig mockConfig) {
        return generate(mockConfig);
    }

    public static LocalDateTime generate(DataConfig mockConfig) {
        String[] dateRange = mockConfig.dateRange();
        if (dateRange == null) {
            return LocalDateTime.now();
        }

        LocalDateTime min = dateRange[0] == null ? LocalDateTime.of(2000, 1, 1, 0, 0, 0) : LocalDate.from(DATE_FORMATTER.parse(dateRange[0])).atStartOfDay();
        LocalDateTime max = dateRange[1] == null ? LocalDateTime.MAX : LocalDate.from(DATE_FORMATTER.parse(dateRange[1])).atStartOfDay();
        if (min.isAfter(max)) {
            LocalDateTime tmp = min;
            min = max;
            max = tmp;
        }

        Duration duration = Duration.between(min, max);
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime date = min.plus(new Random().nextInt((int)duration.toHours()), ChronoUnit.HOURS);
        return LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), now.getHour(), now.getMinute(), now.getSecond());
    }

}
