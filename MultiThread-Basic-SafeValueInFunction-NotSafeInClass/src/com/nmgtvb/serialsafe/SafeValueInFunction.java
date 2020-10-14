package com.nmgtvb.serialsafe;

public class SafeValueInFunction {
	public void isSafeValueInFunction() {
		// synchronized (this) {
		// int number = 5;
		// while (number > 0) {
		// System.out.println("currentThread is " + Thread.currentThread().getName() +
		// ", number is " + number);
		// number--;
		// }
		// }
		int number = 5;
		while (number > 0) {
			System.out.println("currentThread is " + Thread.currentThread().getName() + ", number is " + number);
			number--;
		}
	}
}
