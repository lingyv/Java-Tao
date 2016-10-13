package org.lingyv.JDK.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * 反射相关知识
 * <p>
 * 泛型
 */

/*
运用泛型反射的经验法则
下面是两个典型的使用泛型的场景：
1、声明一个需要被参数化（parameterizable）的类/接口。
2、使用一个参数化类。

当你声明一个类或者接口的时候你可以指明这个类或接口可以被参数化，java.util.List接口就是典型的例子。
你可以运用泛型机制创建一个标明存储的是String类型list，这样比你创建一个Object的list要更好。

当你想在运行期参数化类型本身，比如你想检查java.util.List类的参数化类型，
你是没有办法能知道他具体的参数化类型是什么。这样一来这个类型就可以是一个应用中所有的类型。
但是，当你检查一个使用了被参数化的类型的变量或者方法，你可以获得这个被参数化类型的具体参数。总之：

你不能在运行期获知一个被参数化的类型的具体参数类型是什么，
但是你可以在用到这个被参数化类型的方法以及变量中找到他们，换句话说就是获知他们具体的参数化类型。

-->  http://ifeve.com/java-reflection-9-generics/#theGenericReflectionRuleOfThumb
 */
public class YvThumb {

    /**
     * 泛型方法返回类型
     *
     * @param method
     * @return
     */
    private static Type getMethodType(Method method) {
        return method.getGenericReturnType();
    }

    /**
     * 泛型方法参数类型
     *
     * @param method
     * @return
     */
    private static Type[] getParamType(Method method) {
        return method.getGenericParameterTypes();
    }

    /**
     * 泛型变量类型
     *
     * @param field
     * @return
     */
    private static Type getFieldType(Field field) {
        return field.getGenericType();
    }
}