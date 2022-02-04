package com.unitedcoder.io;

import java.io.*;
import java.net.URL;


public class FileInputStreamDemo {
    public static void main(String[] args) {
        InputStream in = null;
        try {
            URL testUrl = new URL("https://commons.apache.org");
            in = testUrl.openStream();
            //use buffer read to read the content of the input stream
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String inputLine;
            StringBuilder websiteContent=new StringBuilder();

            while ((inputLine = reader.readLine()) != null) {
                System.out.println(inputLine);
                websiteContent.append(inputLine);
            }
            reader.close();

            if(websiteContent.toString().contains("Apache Commons Proper"))
            {
                System.out.println("Website content has the expected message");
            }
            else {
                System.out.println("Website content did not have the expected message");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
