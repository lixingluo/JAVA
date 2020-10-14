package com.nmgtvb.serialsafe;

public class NotSafeValueInClass {
	private int number = 5;

	public void isNotSafeValueInClass() {
		// synchronized (this) {
		// while(number > 0) {
		// System.out.println("currentThread is " + Thread.currentThread().getName() +
		// ", number is " + number);
		// number--;
		// }
		// }
		while (number > 0) {
			System.out.println("currentThread is " + Thread.currentThread().getName() + ", number is " + number);
			number--;
		}
	}
}
