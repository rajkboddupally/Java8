package thread;

public class RaceCondition {

	private  int counter = 0;

	public synchronized void increment() {

		for (int i = 0; i < 100000; i++) {
			this.counter = this.counter + 1;
		}
	}

	public int getCounter() {
		return this.counter;
	}

	public static void main(String[] args) throws InterruptedException {
		RaceCondition rc = new RaceCondition();
		Thread t1 = new Thread(() -> rc.increment(), "T1");
		Thread t2 = new Thread(() -> rc.increment(), "T2");

		t1.start();
		t2.start();

		// Thread.sleep(1000);

		t1.join();
		t2.join();

		System.out.println(rc.getCounter());
	}

}
