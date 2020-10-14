package com.multithread.state;

public class ThreadTest {
	public static void main(String[] args) throws InterruptedException {
		ThreadState state = new ThreadState();
		Thread thread = new Thread(state);
		System.out.println("新建线程:" + thread.getState()); // NEW
		thread.start();
		System.out.println("启动线程:" + thread.getState()); // RUNNABLE或TIMED_WAITING
		Thread.sleep(100); // 当前线程(主线程)休眠，等0.1s后，新线程已经进入waitForASecond()
		System.out.println("计时等待:" + thread.getState()); // TIMED_WAITING
		Thread.sleep(500); // 当前线程(主线程)休眠，等0.5s后，新线程已经进入waitForLong()
		System.out.println("等待线程:" + thread.getState()); // WAITING
		state.notifyNow();
		System.out.println("唤醒线程:" + thread.getState()); // RUNNABLE或TERMINATED
		Thread.sleep(500);// 当前线程(主线程)休眠，等0.5s后
		System.out.println("终止线程:" + thread.getState()); // TERMINATED
	}
}
