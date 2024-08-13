package _sinchronized;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main2 {
    public static void main(String[] args) throws InterruptedException {
        Job job = new Job();
        job.start();
    }
}

class Job {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();
    private final List<Integer> list1 = new ArrayList<>();
    private final List<Integer> list2 = new ArrayList<>();

    public void addElementToList1() {
        synchronized (list1) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list1.add(new Random().nextInt(100));
        }
    }

    public void addElementToList2() {
        synchronized (lock2) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list2.add(new Random().nextInt(100));
        }
    }

    public void execute() {
        for (int i = 0; i < 1000; i++) {
            addElementToList1();
            addElementToList2();
        }
    }

    public void start() throws InterruptedException {
        long before = System.currentTimeMillis();
        //execute();
        Thread tr1 = new Thread(new Runnable() {
            @Override
            public void run() {
                execute();
            }
        });

        Thread tr2 = new Thread(new Runnable() {
            @Override
            public void run() {
                execute();
            }
        });

        tr1.start();
        tr2.start();
        tr1.join();
        tr2.join();

        long after = System.currentTimeMillis();

        System.out.println("List1 " + list1.size());
        System.out.println("List2 " + list2.size());
        System.out.println("Time " + (after - before));
    }

}
