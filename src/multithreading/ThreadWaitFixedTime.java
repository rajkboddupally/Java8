package multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ThreadWaitFixedTime {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService ex = Executors.newSingleThreadExecutor();
		Future<String> f = ex.submit(new MyTask());
		
		try {
			String output = f.get(1, TimeUnit.SECONDS);
			System.out.println("Task success "+output);
		} catch (TimeoutException e) {
			System.out.println("Time out. Thread cancelled ");
			e.printStackTrace();
		}
		
		ex.shutdownNow();
		

	}

}

class MyTask implements Callable<String>{

	@Override
	public String call() throws Exception {
		System.out.println("call");
		Thread.sleep(2000);
		return "task complete";
	}
	
}
