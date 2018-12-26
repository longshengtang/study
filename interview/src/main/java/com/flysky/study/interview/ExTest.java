package com.flysky.study.interview;

public class ExTest extends B implements A {

	public static void main(String[] args) {
		new CC().a();
	}

	public void pX(){
//		System.out.println(x);//x出错，ambiguous模糊不清，有歧义
	}

	@Override
	public void a() {
		
	}
}

interface A{
	int x=0;
	void a();
}
class B{
	int x=1;
}

interface C{
	void play();
}
interface D{
	void play();
}
interface E extends C,D{
	Ball ball=new Ball("");//默认为public static final类型
}
class Ball implements E{
	private String name;
	public String getName(){
		return this.name;
	}
	public Ball(String name) {
		this.name=name;
	}
	public void play(){
//		ball=new Ball("Football");
		//The final field E.ball cannot be assigned
		//因为定义在接口中的变量默认为public static final类型
	}
}
//////////////////////////////////////////////
class AA{
	public void a(){
		System.out.println("AA.a");
	}
}
class BB{
	public void a(){
		System.out.println("BB.a");
	}
}
class CC extends AA implements A{
	
}
