package wade.wei.example.publishobject;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Administrator
 * 对象逸出
 *
 *  在构造对象时发生，它会使类的this引用发生逸出，从而使线程看到一个构造不完整的对象。
 *  上面的内部类的实例包含了对封装实例隐含的引用，这样在对象没有被正确构造之前，就会被发布，有可能会有不安全因素。
 */
@Slf4j
public class Escape {
    private int thisCanBeEscape = 0;

    public Escape () {
        new InnerClass();
    }

    private class InnerClass {

        public InnerClass() {
            //这里可以在Escape对象完成构造前提前引用到Escape的private变量
            log.info("{}", Escape.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }

}
