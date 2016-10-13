package org.lingyv.JDK.reflect;

import java.lang.reflect.Field;

/**
 * 反射的相关知识
 * <p>
 * 变量
 * -->  利用反射可以在运行期检查一个类的变量信息(成员变量)或者获取或者设置变量的值。
 * 可以用java.lang.reflect.Field类实现以上功能
 */
public class YvField {

    /**
     * 通过Class对象获取Field对象
     * 返回的Field对象数组包含了指定类中声明为公有的(public)的所有变量集合。
     *
     * @param c
     * @return
     */
    private static Field[] yvGetFields(Class c) {
        Field[] fields = c.getFields();
        return fields;
    }

    /**
     * 通过变量名称，获取指定的变量
     *
     * @param c
     * @param name
     * @return
     * @throws NoSuchFieldException
     */
    private static Field yvGetField(Class c, String name) throws NoSuchFieldException {
        Field field = c.getField(name);
        return field;
    }

    /**
     * 获取私有变量
     *
     * @param c
     * @return
     * @throws NoSuchFieldException
     */
    private static Field[] yvGetPrivateFields(Class c) throws NoSuchFieldException {
        Field[] fields = c.getDeclaredFields();
        return fields;
    }

    /*
    注意field.setAccessible(true)这行代码，通过调用setAccessible()方法会关闭指定类Field实例的反射访问检查，
    这行代码执行之后不论是私有的、受保护的以及包访问的作用域，你都可以在任何地方访问，
    即使你不在他的访问权限作用域之内。但是你如果你用一般代码来访问这些不在你权限作用域之内的代码依然是不可以的，
    在编译的时候就会报错。
     */

    /**
     * 获取私有变量
     *
     * @param c
     * @param name
     * @return
     * @throws NoSuchFieldException
     */
    private static Field yvGetPrivateField(Class c, String name) throws NoSuchFieldException {
        Field field = c.getDeclaredField(name);
        field.setAccessible(true);
        return field;
    }

    /**
     * 获取变量名
     *
     * @param field
     * @return
     */
    private static String getFieldName(Field field) {
        return field.getName();
    }

    /**
     * 获取变量类型
     *
     * @param field
     * @return
     */
    private static Object getFieldType(Field field) {
        return field.getType();
    }

    /**
     * 获取变量的值
     *
     * @param field
     * @param obj   -->  拥有该变量的类的实例（如果变量是静态变量的话(public static)那么也可以传入null做为参数(代替类的实例)）
     * @return
     * @throws IllegalAccessException
     */
    private static Object getFieldValue(Field field, Object obj) throws IllegalAccessException {
        return field.get(obj);
    }

    /**
     * 设置变量的值
     *
     * @param field
     * @param obj   -->  拥有该变量的类的实例（如果变量是静态变量的话(public static)那么也可以传入null做为参数(代替类的实例)）
     * @param value
     * @throws IllegalAccessException
     */
    private static void setFieldValue(Field field, Object obj, Object value) throws IllegalAccessException {
        field.set(obj, value);
    }
}
