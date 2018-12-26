package com.flysky.study.interview;

public /*abstract*/ class Something {
//	/*private final*/ abstract String doSomething();//abstract之前不能有private final等修饰
	
	public static void main(String[] args) {
		Other o=new Other();
		new Something().addOne(o);
	}
	public void addOne(final Other o){
		o.i++;
	}
//	final int j;//final定义的变量需要被初始化
}
class Other{
	public int i;
}
