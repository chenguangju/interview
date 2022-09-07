package thread;

/**
 * @description:
 * @author: 陈广驹
 * @time: 2022/9/2 14:16
 */
public class ThreadTest {
    static InheritableThreadLocal<String> threadLocal=new InheritableThreadLocal<>();
    public static void main(String[] args) throws InterruptedException {
        threadLocal.set("111");
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(threadLocal.get());
                threadLocal.set("2222");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(threadLocal.get());
            }
        }).start();
        Thread.sleep(1000);
        System.out.println(threadLocal.get());
    }
}
