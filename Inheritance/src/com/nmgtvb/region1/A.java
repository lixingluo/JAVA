package com.nmgtvb.region1;

import com.nmgtvb.region2.C;

//public class A {
//2. 新写A继承C
public class A extends C {
	public void test() {
		B b = new B("?");
		System.out.println("子类A内部");
		C c = new C();
		System.out.println("没有函数修饰符，同一包中。" + b.bNum);
		// 1.直接报错
		// System.out.println("没有函数修饰符，不在同一包中。" + c.cNum);
		cNum = 30;
		System.out.println("有protected修饰符，父类C中。" + super.cNum);
		System.out.println("有protected修饰符，子类A中。" + this.cNum);
	}

	public A() {
		System.out.println("子类A的constructor");
	}

	static {
		System.out.println("子类A的static块区");
	}

	{
		System.out.println("子类的普通块区");
	}
}
