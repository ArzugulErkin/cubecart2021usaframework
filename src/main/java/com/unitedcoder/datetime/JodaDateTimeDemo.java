package com.unitedcoder.datetime;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class JodaDateTimeDemo {
    public static void main(String[] args) {
        //define a new joda date time object instance
        DateTime dt1=new DateTime();
        System.out.println(dt1); //standard format
        //formatting date time
        DateTimeFormatter formatter= DateTimeFormat.forPattern("yyyy-MM-dd-HH-mm-ss-SSS");
        System.out.println(dt1.toString(formatter));

        //get universal time
        DateTime universalTime=new DateTime(DateTimeZone.UTC);
        System.out.println("UTC time is "+universalTime);

        //get Europe Istanbul Timezone
        DateTimeZone istanbulTimeZone=DateTimeZone.forID("Europe/Istanbul");
        DateTime istanbulTime=new DateTime(istanbulTimeZone);
        System.out.println("Istanbul time" + istanbulTime);

        //get Asia Japan Date Time
        DateTimeZone japanTimeZone=DateTimeZone.forID("Asia/Tokyo");
        DateTime japanTime=new DateTime(japanTimeZone);
        System.out.println("Japan Time "+japanTime);
      //get year, month, day from a date time
        System.out.println("Day: "+universalTime.getDayOfMonth());
        System.out.println("Month: "+universalTime.getMonthOfYear());
        System.out.println("Year: "+universalTime.getYear());
        //get name of the day
        DateTime.Property dayName=universalTime.dayOfWeek();
        System.out.println("Day name: "+dayName.getAsShortText()); //short name for the day
        System.out.println("Day full name: "+dayName.getAsText());
        System.out.println("Day : "+universalTime.getDayOfWeek());

        // add date time using java joda time library
        universalTime=new DateTime(DateTimeZone.UTC);
        System.out.println(universalTime);
        int daysToAdd=20;
        int monthToAdd=2;
        System.out.println("Add 20 days: " + universalTime.plusDays(daysToAdd));
        System.out.println("Add 2 months: " + universalTime.plusMonths(monthToAdd));
        System.out.println("Add 3 hours: "+universalTime.plusHours(3));
        //subtract hours
        System.out.println("Minus 4 hours: "+universalTime.minusHours(4));
        //how to get the differences between the two date time
        DateTime beginDate=new DateTime("2020-01-01");
        DateTime endDate=new DateTime("2022-01-29");
        System.out.println("Begin date: "+beginDate);
        System.out.println("End date: "+endDate);
        Period days=new Period(beginDate,endDate, PeriodType.days());
        Period months=new Period(beginDate,endDate,PeriodType.months());
        Period years=new Period(beginDate,endDate,PeriodType.years());
        System.out.println("Total days: "+days.getDays());
        System.out.println("Total months:"+months.getMonths());
        System.out.println("Total years: "+years.getYears());
    }
}
