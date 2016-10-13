package org.lingyv.JDK.reflect;

import org.lingyv.JDK.annotation.RefAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射的相关知识
 * 注解
 */
public class YvAnnotation {

    /**
     * 访问类注解
     *
     * @param c
     * @return
     */
    private static Annotation[] getAnnotations(Class c) {
        Annotation[] annotations = c.getAnnotations();
        return c.getAnnotations();
    }

    /**
     * 通过注解类的类类型获取注解
     *
     * @param c
     * @param annotation
     * @return
     */
    private static Annotation getAnnotation(Class c, Class annotation) {
        Annotation a = c.getAnnotation(annotation);
        if (a instanceof RefAnnotation) {
            RefAnnotation refAnnotation = (RefAnnotation) a;
            System.out.println("name: " + refAnnotation.name());
            System.out.println("value: " + refAnnotation.value());
        }
        return a;
    }

    /**
     * 获取方法的注解
     *
     * @param method
     * @return
     */
    private static Annotation[] getMethodAnnotations(Method method) {
        return method.getAnnotations();
    }

    /**
     * 通过注解类的类类型获取注解
     *
     * @param method
     * @param annotation
     * @return
     */
    private static Annotation getMethodAnnotation(Method method, Class annotation) {
        return method.getAnnotation(annotation);
    }

    /**
     * 获取方法参数的注解
     * Method.getParameterAnnotations()方法返回一个注解类型的二维数组，每一个方法的参数包含一个注解数组。
     *
     * @param method
     * @return
     */
    private static Annotation[] getParamAnnotations(Method method) {
        return method.getAnnotations();
    }

    /**
     * 通过注解类的类类型获取参数的注解
     *
     * @param method
     * @param annotation
     * @return
     */
    private static Annotation getParamAnnotation(Method method, Class annotation) {
        return method.getAnnotation(annotation);
    }

    /**
     * 获取变量的注解
     *
     * @param field
     * @return
     */
    private static Annotation[] getFieldAnnotations(Field field) {
        return field.getAnnotations();
    }

    /**
     * 通过注解类的类类型获取变量的注解
     *
     * @param field
     * @param annotation
     * @return
     */
    private static Annotation getFieldAnnotation(Field field, Class annotation) {
        return field.getAnnotation(annotation);
    }
}

