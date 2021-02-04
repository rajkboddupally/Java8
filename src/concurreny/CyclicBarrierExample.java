package concurreny;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {

    public static void main(String[] args) {
        simulate(5, 3);
    }

    private static void simulate(int threads, int operations) {
        final int NUMBER_OF_THREADS = threads;
        List<List<Integer>> finalList = new CopyOnWriteArrayList<>();

        CyclicBarrier barrier = new CyclicBarrier(NUMBER_OF_THREADS, new TriggerThread(finalList));

        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            Thread t = new Thread(new WorkerThread(operations, finalList, barrier));
            t.setName("" + i);
            t.start();
        }
    }
}

class WorkerThread implements Runnable {
    private int MAX_OPERATIONS;
    private List<List<Integer>> finalList;
    private Random random;
    private CyclicBarrier barrier;

    public WorkerThread(int maxOperaions, List<List<Integer>> finalList, CyclicBarrier barrier) {
        this.MAX_OPERATIONS = maxOperaions;
        this.finalList = finalList;
        this.barrier = barrier;
        this.random = new Random();
    }

    @Override
    public void run() {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < MAX_OPERATIONS; i++) {
            list.add(random.nextInt(10));
        }

        finalList.add(list);
        System.out.println("Thread complete task.. waiting for others " + Thread.currentThread().getName());
        try {
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

    }
}

class TriggerThread implements Runnable {
    List<List<Integer>> finalList;

    public TriggerThread(List<List<Integer>> finalList) {
        this.finalList = finalList;
    }

    @Override
    public void run() {
        int sum = 0;
        for (List<Integer> sublist : finalList) {
            for (Integer i : sublist) {
                sum += i;
            }
        }
        System.out.println("Total sum " + sum);
    }
}