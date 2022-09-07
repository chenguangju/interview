package jvm;

/**
 * @description:
 * @author: 陈广驹
 * @time: 2022/9/4 17:14
 */
public class TestGCRoots03 {
    private static int _10MB = 10 * 1024 * 1024;

    private static final TestGCRoots03 t = new TestGCRoots03(8 * _10MB);

    private byte[] memory;

    public TestGCRoots03(int size) {

        memory = new byte[size];

    }

    public static void main(String[] args) {

        TestGCRoots03 t3 = new TestGCRoots03(4 * _10MB);

        t3 = null;

        System.gc();

    }
}
