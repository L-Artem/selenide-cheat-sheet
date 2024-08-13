package _list;

import java.util.ArrayList;
import java.util.List;

public class _List {
    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            array.add(i);
        }
        System.out.println(array);
        System.out.println(array.size());
        array.remove(5);
        System.out.println(array);
        System.out.println(array.size());

    }


}
