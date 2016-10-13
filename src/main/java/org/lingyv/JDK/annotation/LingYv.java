package org.lingyv.JDK.annotation;

/**
 * 在开发Java程序，尤其是Java EE应用的时候，总是免不了与各种配置文件打交道。
 * 以Java EE中典型的S(pring)S(truts)H(ibernate)架构来说，
 * Spring、Struts和Hibernate这三个框架都有自己的XML格式的配置文件。
 * 这些配置文件需要与Java源代码保存同步，否则的话就可能出现错误。
 * 而且这些错误有可能到了运行时刻才被发现。把同一份信息保存在两个地方，总是个坏的主意。
 * 理想的情况是在一个地方维护这些信息就好了。其它部分所需的信息则通过自动的方式来生成。J
 * DK 5中引入了源代码中的注解（annotation）这一机制。注解使得Java源代码中不但可以包含功能性的实现代码，
 * 还可以添加元数据。注解的功能类似于代码中的注释，所不同的是注解不是提供代码功能的说明，
 * 而是实现程序功能的重要组成部分。Java注解已经在很多框架中得到了广泛的使用，用来简化程序中的配置。
 *(-->  http://www.infoq.com/cn/articles/cf-java-annotation)
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
@interface用来声明一个注解
其中的每一个方法实际上是声明了一个配置参数。方法的名称就是参数的名称，返回值类型就是参数的类型。
可以通过default来声明参数的默认值。
@Retention和@Target这样的元注解，用来声明注解本身的行为。
@Retention用来声明注解的保留策略，有CLASS、RUNTIME和SOURCE这三种，
        分别表示注解保存在类文件、JVM运行时刻和源代码中。只有当声明为RUNTIME的时候，
        才能够在运行时刻通过反射API来获取到注解的信息。
@Target用来声明注解可以被添加在哪些类型的元素上，如类型、方法和域等。
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface LingYv {
    String name();
}
