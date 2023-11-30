package concurreny;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public class CompleteableFuture {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(1);
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 1;
        }, service);

    }
}

class MySupplier implements Supplier<Integer> {

    @Override
    public Integer get() {
        return 1;
    }
}
