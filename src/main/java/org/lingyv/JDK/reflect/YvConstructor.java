package org.lingyv.JDK.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 反射的相关知识
 * 构造器
 * -->  利用Java的反射机制你可以检查一个类的构造方法，并且可以在运行期创建一个对象。
 * 这些功能是通过java.lang.reflect.Constructor这个类实现的
 */
public class YvConstructor {

    //获取构造器

    /**
     * 通过Class对象来获取Constructor类的实例,返回的Constructor数组包含每一个声明为公有的（Public）构造方法。
     *
     * @param c
     * @return
     */
    public static Constructor[] getYvConstructors(Class c) {
        Constructor[] constructors = c.getConstructors();
        return constructors;
    }

    /**
     * 通过构造方法的方法参数类型，获取指定的构造方法
     *
     * @param c
     * @return
     * @throws NoSuchMethodException
     */
    public static Constructor getYvConstructor(Class c) throws NoSuchMethodException {
        Constructor constructor = c.getConstructor(String.class);
        return constructor;
    }

    /**
     * 获取构造方法参数
     *
     * @param constructor
     * @return
     */
    public static Class[] getParamTypes(Constructor constructor) {
        Class[] paramTypes = constructor.getParameterTypes();
        return paramTypes;
    }

    /**
     * 利用Constructor对象实例化一个类
     * <p>
     * constructor.newInstance()方法的方法参数是一个可变参数列表，
     * 但是当你调用构造方法的时候你必须提供精确的参数，即形参与实参必须一一对应
     *
     * @param constructor
     * @return
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     */
    public static Object newInstanceByConstructor(Constructor constructor) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Object obj = constructor.newInstance("旺财");
        return obj;
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        //获取Dog类的String类型参数构造器
        Constructor constructor = getYvConstructor(Dog.class);
        //利用Constructor对象实例化一个类
        Dog dog = (Dog) newInstanceByConstructor(constructor);
        System.out.println(dog.getName());      //旺财
        dog.bark();     //汪~汪~汪~
    }

}
