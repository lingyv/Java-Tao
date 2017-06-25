package org.lingyv.JDK.function;

import org.lingyv.JDK.io.YvReader;

import java.util.function.*;

/**
 * Created by lingyv on 25/06/2017.
 * 重要的函数接口
 */
public class YvFunctionApi {
    /**
     * 断言
     * 参数 T
     * 返回 boolean
     */
    private void predicate() {
        Predicate<Integer> predicate = x -> x > 5;
    }

    /**
     * 二元运算
     * 参数 T, T
     * 返回 T
     */
    private void binaryOperator() {
        BinaryOperator<Integer> add = (x, y) -> x + y;
        BinaryOperator<Integer> subtract = (x, y) -> x - y;
        BinaryOperator<Integer> multiply = (x, y) -> x * y;
        BinaryOperator<Integer> division = (x, y) -> x / y;
    }

    /**
     * 函数
     * 参数: T
     * 返回: R
     */
    private void function() {
        Function<Integer, Integer> plusOne = x -> x + 1;
    }

    /**
     *
     * 参数: T
     * 返回: void
     */
    private void consumer() {
        Consumer<String> print = System.out::println;
    }

    /**
     *
     * 参数: None
     * 返回: T
     */
    private void supplier() {
        Supplier<YvReader> readerSupplier = YvReader::new;
    }

    /**
     * 一元运算
     * 参数: T
     * 返回: T
     */
    private void unaryOperator() {
        UnaryOperator<Boolean> not = b -> !b;
    }

}
