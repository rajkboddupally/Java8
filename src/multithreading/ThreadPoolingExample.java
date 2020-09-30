package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolingExample {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService ex = Executors.newFixedThreadPool(5);

		for(int i=0;i<20;i++) {
			ex.execute(new Mytask(i));
		}
		
		System.out.println("All tasks submitted "+Thread.currentThread().getName());
		ex.shutdown();
		
		while(!ex.awaitTermination(1, TimeUnit.SECONDS)) {
			System.out.println("Tasks are executing.. hold on..... ");
		}
		
		
	}
	
	private static class Mytask implements Runnable{
		private int i;
		public Mytask(int i) {
			this.i = i;
		}

		@Override
		public void run() {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Thread working on it "+i);
		}
	}

}
