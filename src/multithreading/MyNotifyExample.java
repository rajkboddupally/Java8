package multithreading;

import java.util.concurrent.Semaphore;

public class MyNotifyExample {

	public static void main(String[] args) throws InterruptedException {
		MyTask1 myt = new MyTask1();
		new Thread(myt, "T1").start();
		new Thread(myt, "T2").start();
		new Thread(myt, "T3").start();

		myt.s.acquire(3);

		myt.canwait = false;
		System.out.println("Semaphore reached 0 ");

		new Thread(myt, "T4").start();

	}

}

class MyTask1 implements Runnable {

	public Semaphore s = new Semaphore(0);
	public boolean canwait = true;

	public void run() {
		
		synchronized(this){
			if (canwait) {
				System.out.println(Thread.currentThread().getName() + " is gng to wait");
				s.release();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + " acquired the lock");
			}
		
			System.out.println(Thread.currentThread().getName() + " notify");
			
		
			notify();
		}

	}
}
