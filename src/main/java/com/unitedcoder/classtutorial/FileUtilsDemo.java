package com.unitedcoder.classtutorial;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class FileUtilsDemo {
    public static void main(String[] args) throws IOException {
    FileUtils.write(new File("Dolkun.txt"),"How are you today", Charset.defaultCharset(),false);


    }
}
