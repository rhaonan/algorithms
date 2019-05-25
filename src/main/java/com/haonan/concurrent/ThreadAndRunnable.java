package com.haonan.concurrent;

/**
 * @Author rhaonan
 * @Data 2019/5/25
 * @Description Thread & Runnable
 * 卖票问题，多个线程访问共享的数据出现线程安全问题
 */
public class ThreadAndRunnable {

     static class MyThread extends Thread {
        private int ticket = 10;

        @Override
        public void run() {
            while (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + ": 卖票：ticket" + ticket--);
            }
        }
    }

    static class MySecThread extends Thread {
        private static int ticket = 10;

        @Override
        public void run() {
            // 成员变量ticket是静态类型，两个实例对象访问的是同一个，存在线程安全问题，需要给MySecThread的class文件加锁
            synchronized(MySecThread.class) {
                while (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + ": 卖票：ticket" + ticket--);
                }
            }
        }
    }


    static class MyRunnable implements Runnable {
        private int ticket = 10;

        @Override
        public synchronized void run() { // 两个线程访问的是同意给对象，存在线程安全问题，只需要给对象方法加锁
            while (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + ": 卖票：ticket" + ticket--);
            }
        }
    }

    public static void main(String[] args) {
         //ticket是Mythread类的成员变量，线程私有并不共享，将会卖出20张票
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("-----------------error---------------------");
        }
        System.out.println("-------------------------------------------");


        //ticket是MySecThread类的静态变量，线程共享，只会卖出10张票
        MySecThread threadA = new MySecThread();
        MySecThread threadB = new MySecThread();
        threadA.start();
        threadB.start();
        try {
            threadA.join();
            threadB.join();
        } catch (InterruptedException e) {
            System.out.println("-----------------error---------------------");
        }
        System.out.println("-------------------------------------------");

        //两个线程访问的是同一个类MyRunnable的成员变量，资源共享，只会卖出10张票
        MyRunnable runnable = new MyRunnable();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }

}
