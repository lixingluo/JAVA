package com.nmgtvb.thread;

import com.nmgtvb.serialsafe.SafeValueInFunction;

public class ThreadB extends Thread {
	private SafeValueInFunction safeValueInFunction;
	
	public ThreadB(SafeValueInFunction safeValueInFunction) {
		this.safeValueInFunction = safeValueInFunction;
	}
	
	@Override
	public void run() {
		this.safeValueInFunction.isSafeValueInFunction();
	}
}
