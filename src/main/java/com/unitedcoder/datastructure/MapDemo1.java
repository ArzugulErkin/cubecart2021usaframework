package com.unitedcoder.datastructure;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo1 {
    public static void main(String[] args) {
        //define a map for website
        //Google(key)   value: https://www.google.com
        //Yahoo (key)   value: https://www.yahoo.com
        //Youtube (key)  value: https://www.YouTube.com
        //CNN (key)      value: https://www.cnn.com
        Map<String,String> websites=new HashMap<>();
        websites.put("Google","https://www.google.com"); //add an item to the map
        websites.put("Yahoo","https://www.yahoo.com");
        websites.put("Youtube","https://www.YouTube.com");
        websites.put("CNN","https://www.cnn.com");
        //count the total items in the map
        int count= websites.size();
        System.out.println("Total items in the map "+count);
        //get a value from a key
        System.out.println(websites.get("Youtube")); //get method is for getting the value by its key
        //contains key is used for verifying the key
        System.out.println(websites.containsKey("Amazon")); //containsKey method
        System.out.println(websites.containsKey("Google"));
        //containsValue is for verifying if the value exist in the map
        System.out.println(websites.containsValue("https://www.yahoo.com"));  //containsValue
        System.out.println(websites);
        //Get all keys as key set
       Set<String> sites=websites.keySet();  //returns all the key
       for(String site:sites)
       {
           System.out.println(site+"     "+websites.get(site));
       }
       //replace key and value in map
        websites.replace("CNN","https://www.cnn.com","https://cnn.com");
        System.out.println(websites);
    }
}
