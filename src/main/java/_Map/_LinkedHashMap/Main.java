package _Map._LinkedHashMap;

import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<String, Integer> map1 = new LinkedHashMap<>();
        map1.put("Orange", 10);
        map1.put("Cherry", 30);
        map1.put("Banana", 20);
        map1.put("Apple", 10);
        map1.put("Apple", 40);


        for (Map.Entry<String, Integer> stringIntegerEntry : map1.entrySet()) {
            System.out.println(stringIntegerEntry.getKey());
            System.out.println(stringIntegerEntry.getValue());
        }

        for (String key : map1.keySet()) {
            System.out.println(key);
            System.out.println(map1.get(key));

        }
        System.out.println(map1.values());
    }
}
