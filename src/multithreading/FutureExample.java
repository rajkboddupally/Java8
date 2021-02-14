package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FutureExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable myCallable = new MyCallable();

        ExecutorService service = Executors.newFixedThreadPool(2);
        List<Future> result = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            result.add(service.submit(myCallable));
        }

        for (Future future : result) {
            System.out.println(future.get());
        }
    }
}


class MyCallable implements Callable<String> {


    @Override
    public String call() throws Exception {
        Thread.sleep(1000);

        return "Complete " + Thread.currentThread().getName();
    }
}
