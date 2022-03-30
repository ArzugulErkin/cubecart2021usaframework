package com.unitedcoder.basic;

import java.util.List;

public class Exam {

    public String outputItems(List<Object> objectList, int objectsPerLine)
    {
        String myString=null;
        for(Object object: objectList)
        {
            for(int i=1;i<=objectsPerLine;i++)
            {
                myString="Line " + objectsPerLine+" "+object.toString();
            }
            System.out.println(myString);

        }
        return myString;
    }

}
