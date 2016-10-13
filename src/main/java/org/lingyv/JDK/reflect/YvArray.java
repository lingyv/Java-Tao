package org.lingyv.JDK.reflect;

import java.lang.reflect.Array;
import java.lang.reflect.Type;

/**
 * 反射相关知识
 * <p>
 * Java反射机制通过java.lang.reflect.Array这个类来处理数组。
 * 不要把这个类与Java集合套件（Collections suite）中的java.util.Arrays混淆，
 * java.util.Arrays是一个提供了遍历数组，将数组转化为集合等工具方法的类。
 */
public class YvArray {

    /**
     * 创建一个数组
     *
     * @param c
     * @param length
     * @return
     */
    private Object createArray(Class c, int length) {
        Object obj = Array.newInstance(c, length);
        return obj;
    }

    /**
     * 根据索引获取数组中元素的值
     *
     * @param array
     * @param index
     * @return
     */
    private Object getArryItem(Object array, int index) {
        return Array.get(array, index);
    }

    /**
     * 根据索引设置数组中元素的值
     *
     * @param array
     * @param index
     * @param value
     */
    private void setArrayItem(Object array, int index, Object value) {
        Array.set(array, index, value);
    }

    /**
     * 获取数组成员的类型
     * -->成员类型就是数组存储的数据类型
     *
     * @param c
     * @return
     */
    private Type getArrayItemType(Class c) {
        return c.getComponentType();
    }

    public static void main(String[] args) {
        YvArray yvArray = new YvArray();
        Integer[] array = (Integer[]) yvArray.createArray(Integer.class, 5);
        yvArray.setArrayItem(array, 1, 3);
        System.out.println(yvArray.getArryItem(array, 1));
    }
}
