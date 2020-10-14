package com.multithread.TurtleAndRabit;

public class ThreadTest {
	static final int distance = 100;
	static String winner;

	public static void main(String[] args) {
		Rabbit rabbit = new Rabbit();
		Tortoise tortoise = new Tortoise();
		System.out.println("龟兔赛跑选手新建");
		new Thread(rabbit).start();
		new Thread(tortoise).start();
		System.out.println("龟兔赛跑准备就绪");
	}
}
