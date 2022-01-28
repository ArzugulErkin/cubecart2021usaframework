package com.unitedcoder.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalTimeDemo {

    public String getLocalDateTime()
    {
        LocalDateTime now=LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss-SSS");
        return now.format(formatter);
    }
}
