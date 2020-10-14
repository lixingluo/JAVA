package com.multithread.join;

public class Main {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + " Begins");
		Thread1 mth1 = new Thread1("A");
		Thread1 mth2 = new Thread1("B");
		mth1.start();
		mth2.start();
		try {
			mth1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			mth2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " Stops");
	}
}
