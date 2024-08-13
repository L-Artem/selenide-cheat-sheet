package inheritance;

public class ExampleInheritance {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Bob", 3, "gray");

        System.out.println(dog1.name + dog1.age);
        dog1.makeSound();

    }
}
