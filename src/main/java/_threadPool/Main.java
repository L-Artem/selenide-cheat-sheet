package _threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 5; i++) {
            Runnable runnable = new WorkerThread("" + i);
            executorService.execute(runnable);
        }
        executorService.shutdown();
        while (!executorService.isTerminated()){

        }
        System.out.println("Done");
    }

    static class WorkerThread implements Runnable {

        private String command;

        public WorkerThread(String command) {
            this.command = command;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " Start command = " + command);
            processCommand();
            System.out.println(Thread.currentThread().getName() + " End");

        }
        private void processCommand(){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


