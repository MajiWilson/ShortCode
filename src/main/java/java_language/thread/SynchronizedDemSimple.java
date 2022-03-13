package java_language.thread;

/**
 * Class:
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/1 , 19:16
 */
public class SynchronizedDemSimple {

    /**
     * 可重入锁
     */
    public synchronized void method() {
        synchronized (this) {
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName() + " " + i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
      SynchronizedDemSimple test = new SynchronizedDemSimple();
      for( int i = 0 ; i< 10 ;i++){
          Thread thread = new Thread(new Runnable() {
              @Override
              public void run() {
                  test.method();
              }
          });
          thread.start();
      }
    }
}
