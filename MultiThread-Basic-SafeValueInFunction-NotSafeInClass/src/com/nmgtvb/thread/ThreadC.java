package com.nmgtvb.thread;

import com.nmgtvb.serialsafe.NotSafeValueInClass;

public class ThreadC extends Thread {
	private NotSafeValueInClass notSafeValueInClass;

	public ThreadC(NotSafeValueInClass notSafeValueInClass) {
		this.notSafeValueInClass = notSafeValueInClass;
	}

	@Override
	public void run() {
		this.notSafeValueInClass.isNotSafeValueInClass();
	}
}
