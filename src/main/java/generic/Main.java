package generic;

public class Main {
    public static void main(String[] args) {

        Box<Integer> boxInteger = new Box<>();
        Box<String> boxString = new Box<>();

        boxInteger.setT(123);
        boxString.setT("tttt");

        System.out.println(boxInteger.getT());
        System.out.println(boxString.getT());
    }
}

class Box<T> {
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
