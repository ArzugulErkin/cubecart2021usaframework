package com.unitedcoder.datatype;

import org.apache.commons.lang3.StringUtils;

public class StringDemo3 {
    public static void main(String[] args) {
        String name="Dolkun Tarim";
        System.out.println(StringUtils.reverse(name));
        String s1="How are you doing";
        System.out.println(StringUtils.reverse(s1));
        String myString="kfjdkfjeorueojdlfjdlkafjladfjldsfjdklfjeldfjsldafjdlfjd;safjads";
        System.out.println(StringUtils.countMatches(myString,'k'));
        System.out.println(StringUtils.rotate(name,4));
        System.out.println(StringUtils.getCommonPrefix("Dolkun Tarim","Dolkun Tursun ","Dolkun Dolkun"));
    }
}
