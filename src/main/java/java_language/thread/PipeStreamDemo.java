package java_language.thread;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * Class:
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/2 , 19:28
 */
public class PipeStreamDemo {

    private final PipedInputStream inputStream1;
    private final PipedOutputStream outputStream1;
    private final PipedInputStream inputStream2;
    private final PipedOutputStream outputStream2;

    public PipeStreamDemo(){
        inputStream1 = new PipedInputStream();
        outputStream1 = new PipedOutputStream();
        inputStream2 = new PipedInputStream();
        outputStream2 = new PipedOutputStream();
        try {
            inputStream1.connect(outputStream2);
            inputStream2.connect(outputStream1);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    /**程序退出时，需要关闭stream*/
    public void shutdown() throws IOException {
        inputStream1.close();
        inputStream2.close();
        outputStream1.close();
        outputStream2.close();
    }


    public static void main(String[] args) throws IOException {
        PipeStreamDemo demo =new PipeStreamDemo();
        new Thread(()->{
            PipedInputStream in = demo.inputStream2;
            PipedOutputStream out = demo.outputStream2;

            for (int i = 0; i < 10; i++) {
                try {
                    byte[] inArr = new byte[4];
                    in.read(inArr);
                    System.out.print(Thread.currentThread().getName()+": "+ i +" ");
                    System.out.println(new String(inArr));
                    while(true){
                        if("maji".equals(new String(inArr)))
                            break;
                    }
                    out.write("alin".getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }).start();

        new Thread(()->{
            PipedInputStream in = demo.inputStream1;
            PipedOutputStream out = demo.outputStream1;

            for (int i = 0; i < 10; i++) {
                try {
                    out.write("maji".getBytes());
                    byte[] inArr = new byte[4];
                    in.read(inArr);
                    System.out.print(Thread.currentThread().getName()+": "+i+" ");
                    System.out.println(new String(inArr));
                    while(true){
                        if("alin".equals(new String(inArr)))
                            break;
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }).start();
//        demo.shutdown();
    }
}

