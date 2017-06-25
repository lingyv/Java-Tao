package org.lingyv.JDK.function;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by lingyv on 25/06/2017.
 */
public class YvStream {

    /**
     * 计算是否是素数
     *
     * @param number
     * @return
     */
    private static boolean isPrime(final int number) {
        //for (int i = 2; i < number; i++) {
        //    if (number % i == 0) return false;
        //}
        //return number > 1;

        return number > 1 &&
                IntStream.range(2, number)
                        .noneMatch(index -> number % index == 0);
    }

    /**
     * 计算集合中偶数的个数
     * filter
     *
     * @param numbers
     */
    private static long evenCount(List<Integer> numbers) {
        long count = 0;
        //使用foreach循环
        //for (Integer i : numbers) {
        //    if (i % 2 == 0) count ++;
        //}
        //
        //使用迭代器
        //Iterator<Integer> iterator = numbers.iterator();
        //while (iterator.hasNext()) {
        //    Integer i = iterator.next();
        //    if (i % 2 == 0) count ++;
        //}

        //return count;


        return numbers.stream()
                .filter(x -> x % 2 == 0)
                .count();
    }

    /**
     * 将List中的字符串变成大写
     *
     * @param strings
     * @return
     */
    private static List<String> toUpperCase(List<String> strings) {
        return strings.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    /**
     * 生成集合
     *
     * @param t
     * @param <T>
     * @return
     */
    @SafeVarargs
    private static <T> List<T> toList(T... t) {
        //Stream 的 of 方 法 使 用 一 组 初 始 值 生 成 新 的 Stream。
        return Stream.of(t)
                .collect(Collectors.toList());
    }

    /**
     * 合并列表
     *
     * @param t
     * @param <T>
     * @return
     */
    @SafeVarargs
    private static <T> List<T> mergeList(List<T>... t) {
        return Stream.of(t)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    /**
     * 取出列表中最大的元素
     * @param ts --> 列表
     * @param compare --> 比较方法
     * @param <T>
     * @return
     */
    private static <T> T max(List<T> ts, Comparator<? super T> compare) {
        return ts.stream()
                .max(compare)
                .get();
    }

    /**
     * 取出列表中最小的元素
     * @param ts --> 列表
     * @param compare --> 比较方法
     * @param <T>
     * @return
     */
    private static <T> T min(List<T> ts, Comparator<? super T> compare) {
        return ts.stream()
                .min(compare)
                .get();
    }

    /**
     * 使用reduce实现对一组值进行连续二元操作
     * @param identity --> 初始值
     * @param accumulator --> 二元操作
     * @param t --> 原始值
     * @param <T>
     * @return
     */
    public static <T> T reduce(T identity, BinaryOperator<T> accumulator, T ... t) {
        return Stream.of(t)
                .reduce(identity, accumulator);
    }

    /**
     * 使用reduce实现累加器
     * @param i
     * @return
     */
    private static Integer add(Integer ... i) {
        return reduce(0, (x, y) -> x + y, i);
    }


    /**
     * 使用reduce实现累乘器
     * @param i
     * @return
     */
    private static Integer multiply(Integer ... i) {
        return reduce(1, (x, y) -> x * y, i);
    }

    public static void main(String[] args) {
        List<String> strings1 = toList("Hello ");
        List<String> strings2 = toList("World.");
        List<String> strings3 = mergeList(strings1, strings2);
        strings3.forEach(System.out::println);

        List<String> strings4 = toList("h", "123", "hello", "world", "love");
        String s1 = max(strings4, Comparator.comparing(String::length));
        String s2 = min(strings4, Comparator.comparing(String::length));
        System.out.println(s1);
        System.out.println(s2);

        System.out.println(add(1, 2, 3, 4, 5));
        System.out.println(multiply(1, 2, 3, 4, 5));
    }
}
