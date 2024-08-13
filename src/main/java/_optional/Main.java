package _optional;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {


        Optional<String> optional = Optional.of("Hello");

//        if(optional.isPresent()){
//            System.out.println(optional.get());
//        }

        optional.ifPresent(System.out::println);

        String anotherNullSafeValue = optional.orElseGet(()->"Test"); // выведется Test если придет не Hello а null
        System.out.println(anotherNullSafeValue);
    }
}
