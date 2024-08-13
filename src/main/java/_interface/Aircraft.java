package _interface;

public class Aircraft implements Flyable{
    @Override
    public void fly() {
        System.out.println("самолет летит");
    }
}
