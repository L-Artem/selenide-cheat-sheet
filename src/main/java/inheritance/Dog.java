package inheritance;

public class Dog extends Animal{
    private String color;

    public Dog(String name, int age, String color){
        super(name, age);
        this.color=color;
    }
    @Override
    public void makeSound() {
        System.out.println("woof");
    }
}
