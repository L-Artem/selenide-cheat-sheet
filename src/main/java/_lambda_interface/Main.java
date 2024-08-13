package _lambda_interface;

public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println(1);
            System.out.println(2);
            System.out.println(3);
        });

        StringOperation reverse = input -> new StringBuilder(input).reverse().toString();
        System.out.println(reverse.operate("Hello"));
    }
}
@FunctionalInterface
interface StringOperation{
    String operate(String input);
}