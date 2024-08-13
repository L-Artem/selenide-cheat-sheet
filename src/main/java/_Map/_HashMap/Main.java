package _Map._HashMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Map<String, Integer> map1 = new HashMap<>();
        map1.put("Apple", 10);
        map1.put("Orange", 10);
        map1.put("Banana", 20);
        map1.put("Cherry", 30);
        map1.put("Apple", 40);

        Set<String> keys1 = new HashSet<>();
        keys1.addAll(map1.keySet());

        keys1.add("potato");

        for (Map.Entry<String, Integer> stringIntegerEntry : map1.entrySet()) {
            System.out.println(stringIntegerEntry.getKey());
            System.out.println(stringIntegerEntry.getValue());
        }

        for (String key : map1.keySet()) {
            System.out.println(key);
            System.out.println(map1.get(key));

        }
        System.out.println(map1.values());

        System.out.println(keys1);
    }
}
