package com.nmgtvb.region2;

public class C {
	// int cNum = 10;
	// 3. 新写C里的属性给予修饰符protected
	protected int cNum = 20;
	
	public C() {
		System.out.println("父类C的constructor");
	}
	
	static {
		System.out.println("父类C的static块区");
	}
	
	{
		System.out.println("父类的普通块区");
	}
}

// static块区
// 普通块区 -> constructor
