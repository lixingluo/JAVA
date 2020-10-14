package com.multithread.join;

class Thread1 extends Thread {
	public Thread1(String name) {
		super(name);
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " Begins");
		for (int i = 0; i < 5; i++) {
			try {
				sleep((int) (Math.random() * 10));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " Stops");
	}
}

public class MainWithoutJoin {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + " Begins");
		Thread1 mth1 = new Thread1("A");
		Thread1 mth2 = new Thread1("B");
		mth1.start();
		mth2.start();
		System.out.println(Thread.currentThread().getName() + " Stops");
	}
}
