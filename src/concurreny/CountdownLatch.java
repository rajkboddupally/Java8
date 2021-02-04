package concurreny;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class CountdownLatch {

    public static void main(String[] args) throws InterruptedException {
        simulate(5, 3);
    }

    private static void simulate(int NUMBEROFTHREADS, int MAXOPERATIONS) throws InterruptedException {

        CountDownLatch countdownLatch = new CountDownLatch(5);
        List<List<Integer>> finalList = new ArrayList<>();

        for (int i = 0; i < NUMBEROFTHREADS; i++) {
            new Thread(new WorkerThread1(countdownLatch, MAXOPERATIONS, finalList), "" + i).start();
        }
        System.out.println("Thread waiting await.." + Thread.currentThread().getName());
        countdownLatch.await();
        System.out.println("Thread completed await.." + Thread.currentThread().getName());
        int sum = 0;
        for (List<Integer> list : finalList) {
            for (Integer i : list) {
                sum += i;
            }
        }
        System.out.println("Total sum " + sum);

    }

}

class WorkerThread1 implements Runnable {
    private CountDownLatch countdownLatch;
    private List<List<Integer>> finalList;
    private int MAXOPERATIONS;
    private Random random;

    public WorkerThread1(CountDownLatch countdownLatch, int maxoperations, List<List<Integer>> finalList) {
        this.countdownLatch = countdownLatch;
        this.finalList = finalList;
        this.MAXOPERATIONS = maxoperations;
        this.random = new Random();
    }

    @Override
    public void run() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < MAXOPERATIONS; i++) {
            list.add(random.nextInt(10));
        }
        finalList.add(list);
        System.out.println("Thread completed task.." + Thread.currentThread().getName());
        countdownLatch.countDown();
    }
}
