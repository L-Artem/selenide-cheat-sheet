package QAGU;

public class _11_Less_java2_ {

    public static void main(String[] args) {

        // public static void main(String... args) { аргументы переменной длины, массив varArg
        int[] arr3 = {100, 200, -1, 90}; // запись {100, 200, -1, 90} работает только при создании, передать как параметр метода нельзя
        //someMethod({"Vasia", "Petya"}); не валидно
        someMethod(new String[]{"Vasia", "Petya"});
        someVarMethod("Vasia", "Petya", "etc");

    }

    public static String someMethod(String[] args) {
        return "";
    }

    public static String someVarMethod(String... args) {
        return "";
    }

}


