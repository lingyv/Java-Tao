package org.lingyv.JDK.string;

/**
 * Created by lingyv on 16/10/10.
 * java.lang.String类学习
 */
public class YvString {
    /**
     * String对象是不可变的。
     * 只要一个string对象在Java Heap中被创建，就无法再修改它。修改它实际会新建一个String对象，而最初的String对象丝毫未变
     */
    private static void noChange() {
        String s = "abc";
        s = "def";
    }

    /**
     * String与常量池
     * <p>
     * 字符串对象创建有两种形式:
     * 一种为字面量形式，如String s= "abc";
     * 另一种就是使用new这种标准的构造对象的方法，如String str = new String("abc");
     * <p>
     * JVM为了减少字符串对象的重复创建，其维护了一个特殊的内存，这段内存被成为字符串常量池或者字符串字面量池
     * 当代码中出现字面量形式创建字符串对象时，JVM首先会对这个字面量进行检查，如果字符串常量池中存在相同内容的字符串对象的引用，则将这个引用返回，否则新的字符串对象被创建，然后将这个引用放入字符串常量池，并返回该引用。
     * 字符串常量池实现的前提条件就是Java中String对象是不可变的，这样可以安全保证多个变量共享同一个对象。如果Java中的String对象可变的话，一个引用操作改变了对象的值，那么其他的变量也会受到影响，显然这样是不合理的。
     * 字符串常量池中存放的时引用还是对象，这个问题是最常见的。字符串常量池存放的是对象引用，不是对象。在Java中，对象都创建在堆内存中。
     * <p>
     * String的intern()方法会查找在常量池中是否存在一份equal相等的字符串,如果有则返回该字符串的引用,如果没有则添加自己的字符串进入常量池。
     * <p>
     * '=='的含义- -> 基本数据类型之间应用双等号，比较的是他们的数值。复合数据类型(类)之间应用双等号，比较的是他们在内存中的存放地址。
     * <p>
     * 参考：http://droidyue.com/blog/2014/12/21/string-literal-pool-in-java/ 、http://www.jianshu.com/p/c7f47de2ee80
     */
    private static void constantPool() {
        String s1 = "abc";
        String s2 = "abc";  //在常量池中查找对象
        System.out.println(s1 == s2);   //true

        String s3 = "abc";
        String s4 = new String("abc");  //直接在堆内存(Java Heap)中创建一个新的对象
        System.out.println(s3 == s4);   //false

        String s5 = "abc";
        String s6 = "def";
        String s7 = s5 + s6;    //对于所有包含new方式新建对象（包括null）的“+”连接表达式，它所产生的新对象都不会被加入字符串池中。
        String s8 = "abcdef";
        String s9 = "abc" + "def";  //只有使用引号包含文本的方式创建的String对象之间使用“+”连接产生的新对象才会被加入字符串池中。
        System.out.println(s7 == s8);   //false
        System.out.println(s8 == s9);   //true

        String ss = new String("abc");
        /*
        这条语句创建了2个对象
        考虑类加载阶段和实际执行时:
        （1）类加载对一个类只会进行一次。"abc"在类加载时就已经创建并驻留了（如果该类被加载之前已经有"abc"字符串被驻留过则不需要重复创建用于驻留的"xyz"实例）。驻留的字符串是放在全局共享的字符串常量池中的。
        （2）在这段代码后续被运行的时候，"abc"字面量对应的String实例已经固定了，不会再被重复创建。所以这段代码将常量池中的对象复制一份放到heap中，并且把heap中的这个对象的引用交给ss持有。
         */

        String ss1 = "abc";
        String ss2 = new String("abc");
        String ss3 = ss2.intern();
        System.out.println(ss1 == ss3);     //true
        System.out.println(ss2 == ss3);     //false
    }

    /**
     * String作为方法参数传递时，实际上传递的是引用的一个拷贝
     * --＞“值传递”，即方法操作的是参数变量只是原型变量的一个拷贝而已，而非变量本身
     * 值传递-->https://www.zhihu.com/question/31203609/answer/50992895
     */
    private static void changeString(String s) {
        s = "def";
    }

    private static void change() {
        String s = "abc";
        changeString(s);
        System.out.println(s);      //输出abc
    }

    public static void main(String[] args) {
        constantPool();
        change();
    }

}
