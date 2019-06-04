package com.flysky.study.interview.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CacheDemo {

//    public static void main(String[] args) {
//        new CacheDemo().test();
//    }

    private void test() {
        for (int j = 0; j < 3; j++) {
            new Thread() {
                public void run() {
                    int i = 0;
                    while (i++ < 9) {
                        System.out.println(get("key" + i + "_"
                                + Thread.currentThread().getName()));
                    }

                }

                ;
            }.start();
        }
    }

    public Object get(String key) {
        try {
            System.out.println("准备获取读锁:" + Thread.currentThread().getName());
            rw.readLock().lock();
            System.out.println("已经获取读锁:" + Thread.currentThread().getName());
            Object value = cache.get(key);
            if (value == null) {
                try {
                    // Must release read lock before acquiring write lock
                    rw.readLock().unlock();// 必须释放，即使是同一个线程，也必须先释放读锁之后，方能获得写锁
                    System.out.println("准备获取写锁:"
                            + Thread.currentThread().getName());
                    rw.writeLock().lock();
                    System.out.println("已经获取写锁:"
                            + Thread.currentThread().getName());
                    if (value == null) {
                        value = key + "_getDataFromDb";// 实际中可以到数据库里面查询
                        cache.put(key, value);
                    }
                } finally {
                    rw.readLock().lock();// 很正常，在返回之前，防止数据被修改
                    rw.writeLock().unlock();
                }
            }
            return value;
        } finally {
            rw.readLock().unlock();
        }
    }

    private Map<String, Object> cache = new HashMap<String, Object>();

    private ReadWriteLock rw = new ReentrantReadWriteLock();
}
