package org.lingyv.JDK.integer;

import java.util.Properties;

/**
 * Created by lingyv on 16/10/10.
 * java.lang.Integer类学习
 */
public class YvInteger {
    /**
     * int 占用4个字节，32比特
     * Integer类中的私有属性-->private final int value;  value就是Integer对象中真正保存int值的
     */
    private static void minOrMax() {
        int i = 0x7fffffff;     //int占用32bit(4bit*8);使用补码存储
        System.out.println(i);       //2147483647
        System.out.println(i + 1); //-2147483648
        Integer a = 10;
        System.out.println(a.MAX_VALUE);     //2147483647
        System.out.println(a.MIN_VALUE);    //-2147483648
    }

    /**
     * Integer与常量池
     */
    private static void constantPool() {
         /*
          赋值是调用Integer.valueOf();
          public static Integer valueOf(int i) {
               if (i >= IntegerCache.low && i <= IntegerCache.high)
               return IntegerCache.cache[i + (-IntegerCache.low)];
               return new Integer(i);
         }
          private static class IntegerCache {
               static final int low = -128;
               static final int high;
               static final Integer cache[];
               ...
          }

         当Integer被加载时，就新建了-128到127的所有数字并存放在Integer数组cache中

         当调用valueOf方法(包括后面会提到的重载的参数类型包含String的valueOf方法)时，
         如果参数的值在-127到128之间，则直接从缓存中返回一个已经存在的对象。
         如果参数的值不在这个范围内，则new一个Integer对象返回。
     */
        Integer a = 6;  //编译时-->Integer a = Integer.valueOf(6);  -->常量池中查找
        Integer b = 6;
        System.out.println(a == b);     //true

        Integer c = 200;
        Integer d = 200;    //常量池中查找，大于127,新建对象
        System.out.println(c == d);     //false

        Integer e = 6;
        Integer f = new Integer(6);     //创建新的对象
        System.out.println(e == f);     //false

        Integer g = new Integer(6);
        g = 5;      //编译时-->g = Integer.valueOf(5);不是改变对象new Integer(6)中的value，而是使g指向另外一个对象
    }

    /**
     * String转Integer
     */
    private static void stringToInteger() {
        String s = "8";
        Integer a = Integer.getInteger(s);
        Integer b = Integer.decode(s);  //decode() --> 将 String 解码为 Integer。接受十进制、十六进制和八进制数字。
        Integer c = Integer.valueOf(s);
        Integer d = Integer.parseInt(s);
        /*
        以上所有将String转成Integer的方法都是基于parseInt方法实现的。简单看一下以上部分方法的调用栈：
        getInteger() --> decode() --> valueOf() --> parseInt()

        parseInt方法返回的是基本类型int
        其他的方法返回的是Integer
        valueOf（String）方法会调用valueOf(int)方法。

        如果只需要返回一个基本类型，而不需要一个对象，可以直接使用Integert.parseInt("123");
        如果需要一个对象，那么建议使用valueOf(),因为该方法可以借助缓存带来的好处。
        如果和进制有关，那么就是用decode方法。
        如果是从系统配置中取值，那么就是用getInteger
         */
    }

    /**
     * getInteger:
     * 确定具有指定名称的系统属性的整数值。 第一个参数被视为系统属性的名称。
     * 通过 System.getProperty(java.lang.String) 方法可以访问系统属性。
     * 然后，将该属性的字符串值解释为一个整数值，并返回表示该值的 Integer 对象。
     * 使用 getProperty 的定义可以找到可能出现的数字格式的详细信息。
     * 其中参数nm应该在System的props中可以找到。
     */
    private static void getInteger() {
        Properties props = System.getProperties();
        props.put("lingyv", "8888");
        Integer i = Integer.getInteger("lingyv");
        System.out.println(i);  //8888
    }


    public static void main(String[] args) {
        getInteger();
    }
}
