package com.nmgtvb.multithread2;

public class Thread2 implements Runnable {
	int idx = 0;
	@Override
	public void run() {
		idx++;
	}
}
