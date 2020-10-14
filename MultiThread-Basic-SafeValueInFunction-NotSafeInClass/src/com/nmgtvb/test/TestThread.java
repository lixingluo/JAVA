package com.nmgtvb.test;

import com.nmgtvb.serialsafe.NotSafeValueInClass;
import com.nmgtvb.serialsafe.SafeValueInFunction;
import com.nmgtvb.thread.ThreadA;
import com.nmgtvb.thread.ThreadB;
import com.nmgtvb.thread.ThreadC;
import com.nmgtvb.thread.ThreadD;

public class TestThread {
	public static void main(String[] args) {
		SafeValueInFunction safeValueInFunction = new SafeValueInFunction();
		ThreadA threadA = new ThreadA(safeValueInFunction);
		ThreadB threadB = new ThreadB(safeValueInFunction);
		threadA.setName("ThreadA");
		threadB.setName("ThreadB");
		threadA.start();
		threadB.start();
		// 以上是线程安全的，虽然是同一个safeValueInFunction对象，但是因为int number是在函数内实现的
		// 所以number本身每次在函数被执行的时候，都会重新inilize一次，而且作用范围只存在于这次函数调用中
		// 相同于同一个类执行了两次互不相关的函数调用

		NotSafeValueInClass notSafeValueInClass = new NotSafeValueInClass();
		ThreadC threadC = new ThreadC(notSafeValueInClass);
		ThreadD threadD = new ThreadD(notSafeValueInClass);
		threadC.setName("ThreadC");
		threadD.setName("ThreadD");
		threadC.start();
		threadD.start();
	}
}
