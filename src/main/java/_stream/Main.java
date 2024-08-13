package _stream;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> names = List.of("Andrei", "Anton", "Alexandr", "Sergei");

        names.stream()
                .filter(name -> name.startsWith("A"))
                //.map(name -> name.toUpperCase())
                .map(String::toUpperCase)
                //.forEach(name -> System.out.println(name));
                .forEach(System.out::println);

        //names.parallelStream()
    }
}
