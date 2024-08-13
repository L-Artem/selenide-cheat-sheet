package _interface;

public class ExampleInterface {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;

        ExampleInterface ei = new ExampleInterface();

        Flyable a1 = ei.getAirClass(a);
        Flyable b2 = ei.getAirClass(b);

        a1.fly();
        b2.fly();
    }

    public Flyable getAirClass(int a) {
        switch (a) {
            case 1 -> {
                return new Aircraft();
            }
            default -> {
                return new Butterfly();
            }
        }
    }
}
