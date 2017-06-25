package org.lingyv.JDK.thread;

/**
 * 并发与多线程
 * <p>
 * 创建并运行线程
 */
public class CreateThread {

    /**
     * 使用lambda
     */
    private static void lambdaThread() {
        Thread thread = new Thread(() -> {
            for (String s : Resume.res) {
                System.out.println(s);
            }
        });
        thread.start();
    }

    /**
     * 创建Runnable接口的实现类
     */
    private static void impRunnable() {
        Thread thread = new Thread(new Resume());
/*
          设置线程名：
          Thread thread = new Thread(new Resume(), "线程名");
           得到线程名：
           Thread.currentThread().getName();  [得到当前线程的引用 -->  Thread.currentThread()]
       */
        thread.start();
    }

    /**
     * 创建Thread子类的一个实例并重写run方法
     */
    private static void extThread() {
        Hobby hobby = new Hobby();
        /*
        得到线程名：
        1、hobby.getName();
        2、Thread.currentThread().getName();
         */
        hobby.start();
    }

    /**
     * 首先输出当前线程名字。(这里是执行main()方法线程名字。这个线程JVM分配的)
     * 然后开启10个线程，命名为1~10。每个线程输出自己的名字后就退出。
     *
     * 注意:尽管启动线程的顺序是有序的，但是执行的顺序并非是有序的。
     *      也就是说，1号线程并不一定是第一个将自己名字输出到控制台的线程。
     *      这是因为线程是并行执行而非顺序的。Jvm和操作系统一起决定了线程的执行顺序，
     *      他和线程的启动顺序并非一定是一致的。
     */
    private static void threadName(){
        System.out.println("当前线程名："+Thread.currentThread().getName());
        for(int i=0; i<10; i++){
            new Thread("" + i){
                public void run(){
                    System.out.println("Thread: " + getName() + "running");
                }
            }.start();
        }
    }

    public static void main(String[] args) {
        impRunnable();
        extThread();
        System.out.println("自我介绍：");
        threadName();
    }

    /*
    创建并运行一个线程所犯的常见错误是调用线程的run()方法而非start()方法.
    事实上,run()方法并非是由刚创建的新线程所执行的，而是被创建新线程的当前线程所执行了。
    想要让创建的新线程执行run()方法，必须调用新线程的start方法。
     */

    /*
    创建子类和实现Runnable接口如何选择？
    对于这两种方式哪种好并没有一个确定的答案，它们都能满足要求。
    就我个人意见，我更倾向于实现Runnable接口这种方法。
    因为线程池可以有效的管理实现了Runnable接口的线程，
    如果线程池满了，新的线程就会排队等候执行，直到线程池空闲出来为止。
    而如果线程是通过实现Thread子类实现的，这将会复杂一些。

    有时我们要同时融合实现Runnable接口和Thread子类两种方式。
    例如，实现了Thread子类的实例可以执行多个实现了Runnable接口的线程。一个典型的应用就是线程池。
     */
}
