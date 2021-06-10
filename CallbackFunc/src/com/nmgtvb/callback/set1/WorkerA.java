package com.nmgtvb.callback.set1;

import com.nmgtvb.callback.test1.RoomMate1;

public class WorkerA implements Person {

	@Override
	public void doHomeWork(String question, String answer) {
		// TODO Auto-generated method stub
		System.out.println(this.getClass().getSimpleName() + " is working on: " + question);
		if(null != answer) {
			System.out.println("Get the Answer! Answer is: " + answer);
		} else {
			System.out.println("Not get the answer");
		}
	}

	public static void main(String[] args) {
		WorkerA workerA = new WorkerA();
		RoomMate1 roomMate1 = new RoomMate1();
		roomMate1.getAnswer("How can I upgrade my iphone app?", workerA);
	}
}
