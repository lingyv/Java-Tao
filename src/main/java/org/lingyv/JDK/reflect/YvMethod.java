package org.lingyv.JDK.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射相关知识
 * <p>
 * 方法:
 * -->使用反射可以在运行期检查一个方法的信息以及在运行期调用这个方法
 * 通过调用用java.lang.reflect.Method类实现上面的功能
 */
public class YvMethod {

    /**
     * 通过Class对象获取Method对象
     * 返回的Method对象数组包含了指定类中声明为公有的(public)的所有变量集合
     *
     * @param c
     * @return
     */
    private static Method[] yvGetMethods(Class c) {
        return c.getMethods();
    }

    /**
     * 根据给定的方法名称以及参数类型获取相应的方法
     * <p>
     * 如果你想要获取的方法没有参数，那么在调用getMethod()方法时第二个参数传入null即可
     *
     * @param c
     * @param methodName
     * @param paramTypes
     * @return
     * @throws NoSuchMethodException
     */
    private static Method yvGetMethod(Class c, String methodName, Class[] paramTypes) throws NoSuchMethodException {
//        return c.getMethod("bark", new Class[]{String.class});
        return c.getMethod(methodName, paramTypes);
    }

    /**
     * 获取方法的参数类型
     *
     * @param method
     * @return
     */
    private static Class[] yvGetMethodParmType(Method method) {
        return method.getParameterTypes();
    }

    /**
     * 获取方法的返回类型
     *
     * @param method
     * @return
     */
    private static Class yvGetMethodRetType(Method method) {
        return method.getReturnType();
    }

    /**
     * 通过Method对象调用方法
     *
     * @param method
     * @param obj
     * @param args
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    private static void yvInvokeMethod(Method method, Object obj, Object[] args) throws InvocationTargetException, IllegalAccessException {
        /*
        第一个参数是要调用方法的对象、如果是一个静态方法调用的话则可以用null代替指定对象。
        第二个参数是一个可变参数列表，但是你必须要传入与你要调用方法的形参一一对应的实参。
         */
        method.invoke(obj, args);
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = yvGetMethod(Dog.class, "bark", null);
        yvInvokeMethod(method, new Dog(), null);

    }
}
