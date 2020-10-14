package com.multithread.TurtleAndRabit;

public class Rabbit implements Runnable {
	private int runned_distance;
	private static int speed = 5;
	private boolean sleep = false;

	@Override
	public void run() {
		while (ThreadTest.winner == null) {
			if (runned_distance >= ThreadTest.distance) {
				ThreadTest.winner = "Rabbit";
				System.out.println("龟兔赛跑的冠军是兔子");
				break;
			}
			runned_distance += speed;
			System.out.println("兔子跑了" + runned_distance);
			try {
				Thread.sleep(500);
				if (runned_distance >= 60 && !sleep) {
					System.out.println("兔子累了要休息玩会");
					Thread.sleep((int) (10000));
					speed = 4;
					System.out.println("兔子睡醒后以为乌龟在后面跑慢点");
					sleep = true;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
