package com.nmgtvb.callback.test1;

import com.nmgtvb.callback.set1.Person;

public class RoomMate1 {
	public void getAnswer(String question, Person anyone) {
		if(null != question) {
			if(question == "1+1=?") {
				anyone.doHomeWork(question, "2");
			} else if(question == "How can I upgrade my iphone app?"){
				anyone.doHomeWork(question, "Use AppStore please!");
			} else if(question == "When x-> 0, what's the result of sin(x)/x ?") {
				System.out.println("Think...");
				try {
					Thread.sleep(3000);
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Know the answer");
				anyone.doHomeWork(question, "0");
			} else {
				System.out.println("No answer for this question : " + question);
			}
		} else {
			System.out.println("No question input!");
		}
	}
}
