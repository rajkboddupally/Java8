package multithreading;

public class DataRaceExample {

	public static void main(String[] args) {
		SharedClass sharedclass = new SharedClass();

		Thread thread1 = new Thread(() -> {
			for (int i = 0; i < Integer.MAX_VALUE; i++)
				sharedclass.increment();
			;
		});

		Thread thread2 = new Thread(() -> {
			for (int j = 0; j < Integer.MAX_VALUE; j++)
				try {
					sharedclass.checkRace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		});

		thread1.start();
		thread2.start();
	}

	private static class SharedClass {
		int x;
		int y;

		public void increment() {
			x++;
			y++;
		}

		public void checkRace() throws InterruptedException {

			Thread.sleep(1);
			if (y != x) {
				System.out.println("Race detected " + x + " , " + y);
			}
		}
	}

}
