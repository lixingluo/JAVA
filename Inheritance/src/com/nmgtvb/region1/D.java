package com.nmgtvb.region1;

public class D extends B {

	// 可以尝试删掉这个constructor就能发现
	// 如果父类有显示定义了带参数的constructor
	// 子类必须显示定义带参数的constructor
	// 不要指望系统会帮你添加默认的constructor
	public D(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

}
