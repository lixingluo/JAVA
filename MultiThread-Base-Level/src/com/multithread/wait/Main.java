package com.multithread.wait;

class ThreadPrinter implements Runnable {
	String name;
	Object self;
	Object next;

	public ThreadPrinter(String name, Object self, Object next) {
		this.name = name;
		this.self = self;
		this.next = next;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int count = 10;
		while (count > 0) {
			// 以线程A为例(B原理同A);线程C执行时,先申请对象c的锁
			synchronized (self) {
				// 成功申请到对象a的同步锁后,申请对象b的同步锁;成功申请对象c的同步锁,再申请对象a的锁
				// 解释: 执行线程A时,a.wait()使得线程A进入等待池,同时释放了对象a,所以对象a的同步锁能申请得到
				synchronized (next) {
					System.out.print(this.name);
					count--;
					// 唤醒处于wait状态的线程B(第一次执行时不存在wait状态线程B);唤醒处于wait状态的线程A,实际唤醒的是在对象a上等待的其中一个线程
					// 解释: 现在在对象a上等待的唯一一个线程就是第一步放入线程池中的线程A,线程A成功被唤醒,变成runnable
					next.notify();
				} // 同步语句块结束,自动释放对象b;同步语句块结束,自动释放对象a
				try {
					// 释放对象a，同步锁结束,因为调用了a.wait(),线程A会被放入等待池,等待notify的唤醒
					// 释放对象c，同步锁结束,因为调用了c.wait(),线程C会被放入等待池中,等待notify的唤醒
					// 现在循环没有结束,但是由于线程A处于等待池中,状态不是runnable而是wait,所以线程A再被唤醒前不会执行
					// 现在循环没有结束,但是由于线程C处于等待池中,状态不是runnable而是wait,所以线程C再被唤醒前不会执行
					self.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		// 结束线程的等待状态
		synchronized (self) {
			synchronized (next) {
				next.notify();
			}
		}
	}
}

public class Main {
	public static void main(String[] args) throws Exception {
		Object a = new Object();
		Object b = new Object();
		Object c = new Object();

		ThreadPrinter tA = new ThreadPrinter("A", a, b);
		ThreadPrinter tB = new ThreadPrinter("B", b, c);
		ThreadPrinter tC = new ThreadPrinter("C", c, a);

		// 因为JVM中线程调度的问题,不添加sleep没法保证线程顺序执行,A->B->C
		new Thread(tA).start();
		Thread.sleep(100);
		new Thread(tB).start();
		Thread.sleep(100);
		new Thread(tC).start();
		Thread.sleep(100);

		// 以上所有操作保证了计算机在执行这段代码时，永远只有一个线程是runnable的
	}
}
