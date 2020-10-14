package com.nmgtvb.thread;

import com.nmgtvb.serialsafe.SafeValueInFunction;

public class ThreadA extends Thread {
	private SafeValueInFunction safeValueInFunction;

	public ThreadA(SafeValueInFunction safeValueInFunction) {
		this.safeValueInFunction = safeValueInFunction;
	}

	@Override
	public void run() {
		this.safeValueInFunction.isSafeValueInFunction();
	}
}
