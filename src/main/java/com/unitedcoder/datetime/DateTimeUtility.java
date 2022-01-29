package com.unitedcoder.datetime;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Period;
import org.joda.time.PeriodType;

public class DateTimeUtility {

    public int calculateAge(String birthday)
    {
        DateTime beginDate=new DateTime(birthday);
        DateTime today=new DateTime(DateTimeZone.UTC);
        Period period=new Period(beginDate,today, PeriodType.years());
        return period.getYears();
    }
}
