package QAGU;

import java.util.*;

public class _11_Less_java_Collections {
    public static void main(String[] args) {

        List<Object> anyObject;

        List<String> stringList = new ArrayList<>();
        stringList.add("Dima");
        stringList.addAll(Arrays.asList("Vasya", "Petya", "Ivan", "Petr"));
        stringList.remove("Vasya");
        stringList.remove(1);
        stringList.stream()
                .filter(s -> s.equals("Petr"))
                .map(s -> s.toUpperCase());

        //Коллекции не могут работать с примитивами


        List<Integer> intList = new ArrayList<>();
        intList.add(10); //boxing примитивного типа во врапер
        intList.add(15);

        for (int var : intList) {
            System.out.println(var); // unboxing примитивного типа
        }

        Set<Integer> intSet = new HashSet<>(); // хранить только уникальные значения

        Map<Integer, String> instrMap = new HashMap<>();
        instrMap.put(7897, "Dima");
        instrMap.put(7234, "Dima");
        instrMap.put(7222, "Vasya");

        Set<Integer> valID = instrMap.keySet(); // вернет все ключи, по нему можно итерироваться
        Collection<String> valName = instrMap.values(); // вернет все значения.

        //01:18:00
        Set<Map.Entry<Integer, String>> entrySet = instrMap.entrySet(); // набор пар ключ-значение в джава энтри

        for (Map.Entry<Integer, String> entry : entrySet) {
            if (entry.getKey() == 7234) {
                System.out.println(" find 7234 " + entry.getValue());
            }
        }

    }
}

class Human {
    String name;
    int age;
    String sex;

    Human(String name, int age, String sex){
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
}