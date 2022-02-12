package java_language.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 因为没有人释放信号，所以一直死循环，
 */
public class ThreadPrint1004 {
    private int i =1;
    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    public static void main(String[] args) {
        ThreadPrint1004 t = new ThreadPrint1004();
        t.print();
    }
    void print(){
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                while (i <= 100) {
                    lock.lock();
                    try {
                        condition1.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName());
                    System.out.println(i);
                    i++;
                    condition2.signal();
                    lock.unlock();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                while (i <= 100) {
                    lock.lock();
                    try {
                        condition2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName());
                    System.out.println(i);
                    i++;
                    condition1.signal();
                    lock.unlock();
                }
            }
        });

        t1.start();
        t2.start();
    }
}
