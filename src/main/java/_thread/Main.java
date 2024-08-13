package _thread;

public class Main {
    public static void main(String[] args) {

        Runner runner = new Runner();
        Thread tr = new Thread(runner);
        tr.start();

        MyThread mt = new MyThread();
        mt.start();

        Thread tr2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Анонимный класс " + i);
                }
            }
        });

        tr2.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("=" + i + " Main " + Thread.currentThread().getName());
        }

        System.out.println("Done ");
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " Thread " + Thread.currentThread().getName());
        }
    }
}

class Runner implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " Runner " + Thread.currentThread().getName());
        }
    }
}