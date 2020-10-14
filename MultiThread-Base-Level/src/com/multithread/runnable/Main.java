package com.multithread.runnable;

class Thread1 implements Runnable {
	String name;
	public Thread1(String name) {
		this.name = name;
	}
	@Override
	public void run() {
		for(int i = 0;i < 5;i++) {
			System.out.println(name + " runnable thread is running : " + i);
			try {
				Thread.sleep((int)Math.random()*1000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class Main {
	public static void main(String[] args) {
		Thread1 mTh1 = new Thread1("A");
		Thread1 mTh2 = new Thread1("B");
		new Thread(mTh1).start();
		new Thread(mTh2).start();
	}
}
