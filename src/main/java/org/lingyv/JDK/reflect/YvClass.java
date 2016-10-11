package org.lingyv.JDK.reflect;

/**
 * 反射的相关知识
 * <p>
 * Java反射机制可以让我们在编译期(Compile Time)之外的运行期(Runtime)检查类，接口，变量以及方法的信息。
 * 还可以让我们在运行期实例化对象，调用方法，通过调用get/set方法获取变量的值。
 * <p>
 * 类类型  --->
 * 万事万物皆对象。我们定义的类，是java.lang.Class类的对象。这个Class类的对象就叫做(我们定义的)类的类类型。
 * 通过获取类的类类型可以获取以下相关的内容：Class 对象、类名、修饰符、包信息、父类、实现的接口、构造器、方法、变量、注解等
 */
public class YvClass {

    /**
     * 通过对象获取类的类类型
     *
     * @param obj
     * @return
     */
    public static Class getClassByObject(Object obj) {
        return obj.getClass();
    }

    /**
     * 通过类的全名(包名.类名)获取类的类类型
     *
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    public static Class getClassByFullName(String name) throws ClassNotFoundException {
        return Class.forName(name);
    }

    /**
     * 通过已知类名获取类的类类型
     *
     * @return
     */
    public static Class getClassByName() {
        return Dog.class;
    }

    /**
     * 通过Class 对象获取类信息
     *
     * @param c
     */
    public static void getClassInfo(Class c) {
        //获取类的全限定类名
        System.out.println("类的全限定类名" + c.getName());
        //获取类的简短类名(不包括包名)
        System.out.println("类的简短类名" + c.getSimpleName());
        //获取类的规范类名
//        System.out.println(c.getCanonicalName());

        /*
        获取类的修饰符， 即public,private,static 等等的关键字。
        修饰符都被包装成一个int类型的数字，这样每个修饰符都是一个位标识(flag bit)
        这个位标识可以设置和清除修饰符的类型
        可以使用 java.lang.reflect.Modifier 类中的方法来检查修饰符的类型
         */
        int modifiers = c.getModifiers();
        System.out.println("类的修饰符:" + modifiers);

        //获取类的包信息
        System.out.println("类的包:" + c.getPackage());

        //获取父类的类类型
//        Class supperClass = c.getSuperclass();

        //获取类所实现的接口集合
        Class[] interfaces = c.getInterfaces();
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Dog blackDog = new Dog();
        blackDog.bark();

        Class c1 = getClassByName();
        Class c2 = getClassByObject(blackDog);
        Class c3 = getClassByFullName("org.lingyv.JDK.reflect.Dog");
        System.out.println(c1 == c2);       //true
        System.out.println(c1 == c3);       //true

        getClassInfo(c1);
    }
}
