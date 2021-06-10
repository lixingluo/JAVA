package com.nmgtvb.callback.set2;

import com.nmgtvb.callback.set1.Person;
import com.nmgtvb.callback.test1.RoomMate1;

public class StudentB implements Person {

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

	public void ask(String question, final RoomMate1 roommate) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				roommate.getAnswer(question, StudentB.this);
				
			}
		}).start();
		
		goHome();
	}
	
	public void goHome() {
		System.out.println("Sorry I feel sick...Please help me finish the homework.");
	}
	
	public static void main(String[] args) {
		StudentB studentB = new StudentB();
		RoomMate1 roomMate1 = new RoomMate1();
		studentB.ask("When x-> 0, what's the result of sin(x)/x ?", roomMate1);
	}
}
