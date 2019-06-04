package com.flysky.study.interview.thread;

public class ShareDataTest {

//	public static void main(String[] args) {
//		test();
//	}

	private static void test() {
		final MyData sd = new MyData();

		final int times = 10000000;

		for (int i = 0; i < 2; i++) {

			new Thread() {

				@Override
				public void run() {
					// System.out.println("+1" +
					// Thread.currentThread().getName());
					for (int j = 0; j < times; j++) {

						System.out.println("++ "
								+ Thread.currentThread().getName());
						sd.increase();
					}
				}

			}.start();

			new Thread() {

				@Override
				public void run() {
					for (int j = 0; j < times; j++) {
						System.out.println("-- "
								+ Thread.currentThread().getName());
						sd.decrease();
					}
				}

			}.start();
		}

		new Thread() {

			@Override
			public void run() {
				try {
					while (true) {
						System.out.println("当前i=" + sd.getI());
						Thread.sleep(1000);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}.start();
	}

}

class MyData {

	public /*synchronized*/ void increase() {
		i++;
	}

	public /*synchronized*/ void decrease() {
		i--;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	private int i = 0;
}
