package org.lingyv.JDK.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class YvInvocationHandler implements InvocationHandler {

    /**
     * 传入invoke()方法中的proxy参数是实现要代理接口的动态代理对象。通常你是不需要他的。
     * <p>
     * invoke()方法中的Method对象参数代表了被动态代理的接口中要调用的方法，
     * 从这个method对象中你可以获取到这个方法名字，方法的参数，参数类型等等信息。
     * 关于这部分内容可以查阅之前有关Method的文章。
     * <p>
     * Object数组参数包含了被动态代理的方法需要的方法参数。
     * 注意：原生数据类型（如int，long等等）方法参数传入等价的包装对象（如Integer， Long等等）。
     * 注意：原生数据类型（如int，long等等）方法参数传入等价的包装对象（如Integer， Long等等）。
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
