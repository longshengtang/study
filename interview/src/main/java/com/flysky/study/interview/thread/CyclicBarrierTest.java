package com.flysky.study.interview.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierTest {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());
		new CyclicBarrierTest().test();
	}

	private void test() {
		for (int i = 0; i < count; i++) {
			Runnable r = new Runnable() {
				public void run() {
					try {
						Thread.sleep((long) (Math.random() * 6000));
						System.out.println(Thread.currentThread().getName() + "已经到达松桃,已经有"+(cb.getNumberWaiting()+1)+"人");
						cb.await();
//						System.out.println();
						
						Thread.sleep((long) (Math.random() * 6000));
						System.out.println(Thread.currentThread().getName() + "已经到达玉屏,已经有"+(cb.getNumberWaiting()+1)+"人");
						cb.await();
//						System.out.println();
						
						Thread.sleep((long) (Math.random() * 6000));
						System.out.println(Thread.currentThread().getName() + "已经到达贵阳,已经有"+(cb.getNumberWaiting()+1)+"人");
						cb.await();
//						System.out.println();
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					} catch (BrokenBarrierException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
			es.execute(r);
		}
	}

	private int count=5;
	
	private ExecutorService es = Executors.newCachedThreadPool();
	// private CompletionService<Integer> cs = new
	// ExecutorCompletionService<Integer>(es);

	private CyclicBarrier cb = new CyclicBarrier(count);
}
