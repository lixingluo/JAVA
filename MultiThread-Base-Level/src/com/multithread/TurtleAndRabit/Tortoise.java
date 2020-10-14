package com.multithread.TurtleAndRabit;

public class Tortoise implements Runnable {
	private int runned_distance;
	private static int speed = 3;

	@Override
	public void run() {
		while (ThreadTest.winner == null) {
			if (runned_distance >= ThreadTest.distance) {
				ThreadTest.winner = "Tortoise";
				System.out.println("龟兔赛跑的冠军是乌龟");
				break;
			}
			runned_distance += speed;
			System.out.println("乌龟跑了" + runned_distance);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
