package _list;

import java.util.LinkedList;
import java.util.List;

public class _LinkedList {
    public static void main(String[] args) {
        List<String> array = new LinkedList<>();

        array.add("AAA");
        array.add("BBB");
        array.add("CCC");

        System.out.println(array);

        array.add(1, "III");

        System.out.println(array);
    }
}
