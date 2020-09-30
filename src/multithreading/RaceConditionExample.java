package multithreading;

public class RaceConditionExample {
	public static void main(String[] args) throws InterruptedException {
		Counter counter = new Counter(0);
		
		Thread incrementThread = new IncrementThread(counter);
		Thread decrementThread = new DecrementThread(counter);
		
		incrementThread.start();
		incrementThread.join();
		
		decrementThread.start();
		decrementThread.join();
		
		
		System.out.println("Final counter "+counter.getCount());
		
	}

	private static class Counter {
		int counter;

		public Counter(int counter) {
			super();
			this.counter = counter;
		}

		public int getCount() {
			return counter;
		}

		public void increment() {
			counter++;
		}

		public void decrement() {
			counter--;
		}
	}

	private static class IncrementThread extends Thread {
		Counter counter;

		public IncrementThread(Counter counter) {
			this.counter = counter;
		}

		@Override
		public void run() {
			for (int i = 0; i < 100; i++) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				counter.increment();
			}
		}
	}

	private static class DecrementThread extends Thread {
		Counter counter;

		public DecrementThread(Counter counter) {
			this.counter = counter;
		}

		@Override
		public void run() {
			for (int i = 0; i < 100; i++)
				counter.decrement();
			;
		}
	}
}
