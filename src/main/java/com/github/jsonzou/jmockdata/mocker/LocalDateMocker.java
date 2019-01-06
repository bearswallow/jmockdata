package com.github.jsonzou.jmockdata.mocker;

import com.github.jsonzou.jmockdata.DataConfig;
import com.github.jsonzou.jmockdata.Mocker;

import java.time.LocalDate;

public class LocalDateMocker implements Mocker<LocalDate> {

    @Override
    public LocalDate mock(DataConfig mockConfig) {
        String[] dateRange = mockConfig.dateRange();
        return null;
    }

}
