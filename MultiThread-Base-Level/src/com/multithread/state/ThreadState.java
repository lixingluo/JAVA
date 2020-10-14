package com.multithread.state;

public class ThreadState implements Runnable {
	public synchronized void waitForASecond() throws InterruptedException {
		wait(500);// 将当前线程暂时等待0.5秒或其他线程调用notify()或notifyAll()
	}

	public synchronized void waitForLong() throws InterruptedException {
		wait();// 永久等待,直到其他线程调用notify()或notifyAll()
	}

	public synchronized void notifyNow() throws InterruptedException {
		notify();// 唤醒由调用wait()方法进入等待状态的线程
	}

	@Override
	public void run() {
		try {
			waitForASecond();// 在新线程中运行waitForASecond()方法
			waitForLong();// 在新线程中运行waitForLong()
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
