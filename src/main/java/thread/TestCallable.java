package thread;

import java.util.concurrent.*;

/**
 * @description:
 * @author: 陈广驹
 * @time: 2022/9/2 14:16
 */
public class TestCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        int i=1/0;
        return "success";
    }

    public static void main(String[] args)  {
        ThreadLocal<String> objectThreadLocal = new ThreadLocal<>();
        //objectThreadLocal.set("123");
        objectThreadLocal.set("456");
        System.gc();
        System.out.println(objectThreadLocal.get());
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                int i=1/0;
                System.out.println(111222);
            }
        }).start();*/
        /*ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<?> submit = executorService.submit(new Runnable() {
            @Override
            public void run() {
                int i=1/0;
                System.out.println(111222);
            }
        });*/

        /*Future<String> submit = executorService.submit(new TestCallable());
        System.out.println(submit.get());*/
        System.out.println(111);
    }
}
