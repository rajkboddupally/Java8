package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HackerCatch {

	public static final int MAX_NUMBER = 9999;
	
	public static void main(String[] args) {
		Random random = new Random();
		int password = random.nextInt(MAX_NUMBER);
		
		System.out.println("password "+password);
		
		Vault vault = new Vault(password);
		
		List<Thread> threads = new ArrayList<Thread>();
		threads.add(new AscendingThread(vault));
		threads.add(new DecendingThread(vault));
		threads.add(new PoliceThread());
		
		for(Thread thread:threads) {
			thread.start();
		}
		
	}
	
	

	private static class Vault {
		public int password;

		public Vault(int password) {
			this.password = password;
		}

		public boolean isCorrectPassword(int guess) {
			return this.password == guess;
		}
	}

	private static abstract class HackerThread extends Thread {
		Vault vault;

		public HackerThread(Vault vault) {
			this.vault = vault;
			this.setName(this.getClass().getSimpleName());
			this.setPriority(MAX_PRIORITY);
		}

		@Override
		public void start() {
			System.out.println("Thread starting " + this.getName());
			super.start();
		}
	}

	private static class AscendingThread extends HackerThread {

		public AscendingThread(Vault vault) {
			super(vault);
		}

		@Override
		public void run() {
			for (int guess = 0; guess < MAX_NUMBER; guess++) {
				//.out.println("Guess" + guess);

				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (vault.isCorrectPassword(guess)) {
					System.out.println("AscendingThread hacked the system " + guess);
					System.exit(0);
				}
			}
		}
	}

	private static class DecendingThread extends HackerThread {

		public DecendingThread(Vault vault) {
			super(vault);
		}

		@Override
		public void run() {
			for (int guess = MAX_NUMBER; guess > 0; guess--) {
				//System.out.println("Guess" + guess);
				
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (vault.isCorrectPassword(guess)) {
					System.out.println("DecendingThread hacked the system " + guess);
					System.exit(0);
				}
			}
		}
	}

	private static class PoliceThread extends Thread {

		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(i);
			}
			System.out.println("Police caught hacker ");
			System.exit(0);
			
		}
	}

}
