package org.lingyv.JDK.thread;

public class Resume implements Runnable {
    public static String[] res = {"名字：凌宇","性别：男","爱好：编程"};

    private static void speack() {
        for (String s : res) {
            System.out.println(s);
        }
    }

    public void run() {
        speack();
    }
}
