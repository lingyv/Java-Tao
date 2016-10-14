package org.lingyv.JDK.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 * 使用Java反射机制你可以在运行期动态的创建接口的实现。
 * java.lang.reflect.Proxy类就可以实现这一功能。
 * 这个类的名字（Proxy意思为代理）就是为什么把动态接口实现叫做动态代理。
 * 动态的代理的用途十分广泛，比如数据库连接和事物管理（transaction management）
 * 还有单元测试时用到的动态mock对象以及AOP中的方法拦截功能等等都使用到了动态代理。
 */
public class YvProxy {

    /**
     * 创建代理
     * 可以通过使用Proxy.newProxyInstance()方法创建动态代理。newProxyInstance()方法有三个参数：
     * 1、类加载器（ClassLoader）用来加载动态代理类。
     * 2、一个要实现的接口的数组。
     * 3、一个InvocationHandler把所有方法的调用都转到代理上。
     *
     * @param handler
     * @param interfaceClass
     * @return
     */
    private static Object createProxy(InvocationHandler handler, Class interfaceClass) {
        Object proxy = Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, handler);
//        变量proxy包含一个接口的的动态实现。所有对proxy的调用都被转向到实现了InvocationHandler接口的handler上。
        return proxy;
    }

    /*
    动态代理常被应用到以下几种情况中:
        1.数据库连接以及事物管理
        2.单元测试中的动态Mock对象
        3.自定义工厂与依赖注入（DI）容器之间的适配器
        4.类似AOP的方法拦截器
     */

}
