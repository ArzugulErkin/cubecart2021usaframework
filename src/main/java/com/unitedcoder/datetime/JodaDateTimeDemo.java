package com.unitedcoder.datetime;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
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


    }
}
