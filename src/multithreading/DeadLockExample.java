package multithreading;

public class DeadLockExample {
	private static Object resource1 = new Object();
	private static Object resource2 = new Object();

	public static void main(String[] args) {
		Thread t1 = new Thread(new MyRunnable(resource1, resource2));
		Thread t2 = new Thread(new MyRunnable(resource2, resource1));
		
		t1.start();
		t2.start();
	}

	private static class MyRunnable implements Runnable {

		Object object1, object2;

		public MyRunnable(Object object1, Object object2) {
			this.object1 = object1;
			this.object2 = object2;
		}

		@Override
		public void run() {
			synchronized (this.object1) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + " holding lock for " + object1.getClass());
				synchronized (this.object2) {
					System.out.println(Thread.currentThread().getName() + " holding lock for " + object2);
				}

			}

		}

	}
}
