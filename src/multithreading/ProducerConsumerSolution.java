package multithreading;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerSolution {
    public static void main(String[] args){
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(1);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for(int i=0;i<1;i++){
            executorService.execute(new Producer1(queue));
            executorService.execute(new Consumer1(queue));
        }
    }
}



class Producer1 implements Runnable{
    BlockingQueue<Integer> queue;

    public Producer1(BlockingQueue<Integer> queue){
        this.queue = queue;
    }


    @Override
    public void run() {
        Random r = new Random();
        for(int i=0;i<100;i++){
            try {
                int random = r.nextInt(100);
                System.out.println("PRODUCER "+random + " "+ Thread.currentThread().getName());
                queue.put(random);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Consumer1 implements Runnable{
    BlockingQueue<Integer> queue;

    public Consumer1(BlockingQueue<Integer> queue){
        this.queue = queue;
    }


    @Override
    public void run() {
        while(true){
            try {
                System.out.println("CONSUMER  " + queue.take() + " "+ Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
