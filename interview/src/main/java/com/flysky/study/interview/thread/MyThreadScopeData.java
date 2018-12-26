package com.flysky.study.interview.thread;

/**
 * 这是专门与线程编写的数据对象，在线程的任一地方调用获取实例方法，便会得到与此线程有关的实例对象，该实例对象无须用户创建<br>
 * 可以实现线程范围内心的单例的数据对象，值得注意的是，如果线程生命周期是短暂的，是否在线程生命结束之后，释放掉内存？<br>
 * 
 * @author Administrator
 * 
 */
public class MyThreadScopeData {

	private MyThreadScopeData() {
	}

	/**
	 * 因为每个线程都具有独立的实例，所以无须使用Synchronized来同步互斥
	 * 
	 * @return
	 */
	public static MyThreadScopeData getThreadInstance() {
//		ThreadDeathEvent e;

		MyThreadScopeData instance = threadLocalMap.get();

		if (instance == null) {
			instance = new MyThreadScopeData();
			threadLocalMap.set(instance);
		}

		return instance;

	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private int age;
	private String name;
	private static ThreadLocal<MyThreadScopeData> threadLocalMap = new ThreadLocal<MyThreadScopeData>();

}
