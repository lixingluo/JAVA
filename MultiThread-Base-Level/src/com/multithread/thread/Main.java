package com.multithread.thread;

class Thread1 extends Thread {
	String name;
	public Thread1(String name) {
		this.name = name;
	}
	@Override
	public void run() {
		for(int i = 0;i < 5;i++) {
			System.out.println(name + " thread is running : " + i);
			try {
				sleep((int)(Math.random()*1000));
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class Main {
	public static void main(String[] args) {
		Thread1 mTh1=new Thread1("A");
		Thread1 mTh2=new Thread1("B");
		mTh1.start();
		mTh2.start();
	}
}
