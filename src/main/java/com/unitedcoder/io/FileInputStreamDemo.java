package com.unitedcoder.io;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class FileInputStreamDemo {
    public static void main(String[] args) {
        InputStream in = null;
        StringBuilder stringBuilder=new StringBuilder();
        try {
            URL testUrl=new URL("http://commons.apache.org");
            in= testUrl.openStream();
            FileUtils.write(new File("doc\\apache.txt"), (CharSequence) in);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
