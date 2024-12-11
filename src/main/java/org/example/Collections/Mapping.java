package org.example.Collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Mapping {

    public static void main(String[] args){

        HashMap<String, Integer> map = new HashMap<>();
        map.put("Apple", 10);
        map.put("Banana", 20);
        map.put("Cherry", 30);
        map.put("Orange", 40);

        Boolean value = map.containsKey("Cherry");
        System.out.println(value);
        Boolean num = map.containsValue("Orange");
        System.out.println(num);
        map.remove("Apple");
        System.out.println("sise" + map.size());
        System.out.println("Value for apple: " + map.get("Apple"));
        System.out.println("Value to Banana: " + map.get("Banana"));
        Set<String> keys = map.keySet();
        Collection<Integer> values = map.values();
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for(String key : keys){
            System.out.println(key + ": " + map.get(key));
        }
        for(Integer vaue : values){
            System.out.println(vaue);
        }
        for(Map.Entry<String, Integer> entry : entries){
            System.out.println(entry.getKey() + " ---" + entry.getValue());
        }
    }
}
