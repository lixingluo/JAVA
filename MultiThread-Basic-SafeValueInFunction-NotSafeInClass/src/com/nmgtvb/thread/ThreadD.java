package com.nmgtvb.thread;

import com.nmgtvb.serialsafe.NotSafeValueInClass;

public class ThreadD extends Thread {
	private NotSafeValueInClass notSafeValueInClass;

	public ThreadD(NotSafeValueInClass notSafeValueInClass) {
		this.notSafeValueInClass = notSafeValueInClass;
	}

	@Override
	public void run() {
		this.notSafeValueInClass.isNotSafeValueInClass();
	}
}
