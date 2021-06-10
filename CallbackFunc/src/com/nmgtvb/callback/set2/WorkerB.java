package com.nmgtvb.callback.set2;

import com.nmgtvb.callback.set1.Person;
import com.nmgtvb.callback.test1.RoomMate1;

public class WorkerB implements Person {

	@Override
	public void doHomeWork(String question, String answer) {
		// TODO Auto-generated method stub
	}

	public static void main(String[] args) {
		RoomMate1 roomMate1 = new RoomMate1();
		roomMate1.getAnswer("How can I upgrade my iphone app?", new Person() {

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
			
		});
	}
}
