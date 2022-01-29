package com.unitedcoder.io;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileWriteDemo2 {
    public static void main(String[] args) {
        StringBuilder stringBuilder=new StringBuilder();

        for(int i=1;i<=20;i++)
        {
            for(int j=1;j<=i;j++)
            {
                int result=i*j;
                stringBuilder.append(String.format("%d*%d=%d",i,j,result)).append("     ");
            }
            stringBuilder.append("\n");
        }
        try {
            FileUtils.write(new File("doc\\multiplication-table.txt"),stringBuilder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
