package wade.wei.test;

/**
 * @author Administrator
 * 测试函数式编程
 */
public class Test {
    static int a = 10;
    static int b = 20;

    static int add(Addable addable) {
        return addable.add(a, b);
    }

    static int add2(Addable addable, int a1, int a2) {
        return addable.add(a1, a2);
    }

    static void print(Printable printable,String msg) {
        printable.print(msg);
    }

    public static void main(String[] args) {
        print(a->System.out.println(a),"随便写点信息");

        int result = add((a, b) -> a + b);
        System.out.println(result);

        int result2 = add2((a, b) -> a + b, 30, 40);
        System.out.println(result2);


    }

}

interface Printable {
    /**
     * 打印
     * @param msg
     */
    void print(String msg);
}

interface Addable {
    /**
     * 加法
     *
     * @param a
     * @param b
     * @return
     */
    int add(int a, int b);
}
