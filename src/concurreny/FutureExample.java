package concurreny;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(2);
        Future<Integer> result = service.submit(() -> {
            Thread.sleep(2000);
            return 1;
        });
        System.out.println("Future isDone "+result.isDone());
        service.shutdown();
        System.out.println("Future " + result.get());

    }
}
