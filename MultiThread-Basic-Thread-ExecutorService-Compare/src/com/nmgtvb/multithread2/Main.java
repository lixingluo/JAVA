package com.nmgtvb.multithread2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	public static void main(String[] args) {
		Runtime run = Runtime.getRuntime();// 创建Runtime对象
		run.gc();// 运行垃圾回收器
		long freeMemory = run.freeMemory();// 获得当前虚拟机的空闲内存
		long currentTime = System.currentTimeMillis();// 获得当前虚拟机的时间
		for (int i = 0; i < 1000; i++) {// 独立运行1000个线程
			new Thread(new Thread2()).start();
		}
		// 查看内存变化
		System.out.println("普通方法：独立运行1000个线程所占用的内存:" + (freeMemory - run.freeMemory()));
		System.out.println("普通方法：独立运行1000个线程所消耗时间:" + (System.currentTimeMillis() - currentTime));

		run.gc();// 运行垃圾回收器
		freeMemory = run.freeMemory();// 获得当前虚拟机的空闲内存
		currentTime = System.currentTimeMillis();// 获得当前虚拟机的时间
		ExecutorService executorService = Executors.newFixedThreadPool(2);// 创建线程池
		for (int i = 0; i < 1000; i++) {// 独立运行1000个线程
			executorService.submit(new Thread2());
		}
		// 查看内存变化
		System.out.println("线程池：独立运行1000个线程所占用的内存:" + (freeMemory - run.freeMemory()));
		System.out.println("线程池：独立运行1000个线程所消耗时间:" + (System.currentTimeMillis() - currentTime));

		executorService.shutdown();
	}
}
