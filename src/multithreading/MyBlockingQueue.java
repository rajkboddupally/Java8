package multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MyBlockingQueue {

	public static void main(String[] args) {
		BlockingQueue<String> bq = new ArrayBlockingQueue<String>(5);
		new Thread(new Producer(bq)).start();
		new Thread(new Consumer(bq)).start();

	}

}

class Producer implements Runnable {
	BlockingQueue<String> bq;

	Producer(BlockingQueue<String> bq) {
		this.bq = bq;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				System.out.println("Producer " + i);
				bq.put("" + i);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Producer complste");
		try {
			bq.put("complete");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Consumer implements Runnable {
	BlockingQueue<String> bq;

	Consumer(BlockingQueue<String> bq) {
		this.bq = bq;
	}

	public void run() {

		while (true) {
			if (bq.peek() != "complete") {
				try {
					Thread.sleep(1000);
					System.out.println("consumer - " + bq.take());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				System.out.println("Producer complste");break;
			}
				
		}

	}

}