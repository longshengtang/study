package com.flysky.study.interview;

public class Test {

	public static void main(String[] args) {

		System.out.println("tryFinally--x="+new Test().tryFinally());
		System.out.println("17/2="+17/2);
		System.out.println("17>>1="+(17>>1));//17>>1=8
		System.out.println("17>>2="+(17>>2));//17>>1=4
		System.out.println("17>>3="+(17>>3));//17>>1=2
		System.out.println(Math.abs(-3));
	}
	
	public String tryFinally(){
		int x=1;
		try{
			return test(x)+"...try_x="+x;
		}finally{
			++x;
			System.out.println("x="+x);
		}
	}
	
	public String test(int x){
		System.out.println("-----");
		return x+"";
	}

}
