package day11.stream;


import javax.swing.*;
import java.io.IOException;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class StreamDemo {
    public static void main(String[] args) {

        try {
            //Read file into string
            var contents = new String(Files.readAllBytes(Paths.get("D:\\bak\\Ebook.txt")), StandardCharsets.UTF_8);
            //split into words; nonletters are delimiters
            List<String> words = List.of(contents.split("\\PL"));


            //of是一个多参方法，假如有一个数组就可以使用这个方法来入参
            Stream<String> word = Stream.of(contents.split("\\PL"));
            //统计文字中单词长度大于11的
//            long count = words.stream().filter(s -> s.length() > 11).count();
//            System.out.println(count);
            List<String> collect = words.stream()
                    .filter(s -> s.length() > 11)
                    .collect(Collectors.toList());
            collect.forEach(System.out::println);

            System.out.println("collect.size() = " + collect.size());


            //TODO 使用并行流处理数据过滤出所有大于长度11的单词 输出前五个
            List<String> collect1 = words.parallelStream()
                    .filter(s -> s.length() > 11)
                    .limit(5)
                    .collect(Collectors.toList());
            collect1.forEach(System.out::println);

            System.out.println("======================================================================");
            //使用Array.stream()
            String[] array = {"apple", "banana", "cherry", "date"};
            //传入Array.stream(arr[],from,to) from to是指定范围
            Arrays.stream(array,1,2)
                    .filter(a -> a.startsWith("b"))
                    .forEach(System.out::println);



            System.out.println("======================================================================");

            //创建不包含任何元素的流
            Stream<Object> empty = Stream.empty();

            //获取一个无限流
            Stream<String> generate = Stream.generate(() -> "hello");
            generate.limit(5).forEach(System.out::println);

            System.out.println("======================================================================");

            Stream<Double> generate1 = Stream.generate(Math::random);
            generate1.limit(2).forEach(System.out::println);

            //BigInteger.ZERO 是 Java 中 BigInteger 类的一个常量，表示数值为零的 BigInteger 对象。
            BigInteger zero = BigInteger.ZERO;
            System.out.println("zero = " + zero);

            //add方法表示加法运算
            Stream<BigInteger> iterate = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE));


            //生成0-n个数
            BigInteger bigInteger = new BigInteger("10");
            Stream<BigInteger> iterate1 = Stream.iterate(BigInteger.ZERO,
                    n -> n.compareTo(bigInteger) < 0,
                    n -> n.add(BigInteger.ONE));
            iterate1.collect(Collectors.toList()).forEach(System.out::println);

            System.out.println("=====================字符串转出流去重（set）and distinct() 1=====================================");
            //将按照某个正则表达式来分割为一个字符序列对象
            Stream<String> stringStream = Pattern.compile("\\PL")
                    .splitAsStream(contents)//转换成流
                    .filter(s -> s.length() > 13).distinct(); //条件大于长度13

            stringStream.collect(Collectors.toList()).forEach(System.out::println);

            //TODO set 进行去重
//            Set<String> collects = stringStream.collect(Collectors.toSet());
//            collects.forEach(System.out::println);
//
//            System.out.println("=====================字符串转出流去重2=====================================");
//            Stream<String> stringStreams = Pattern.compile("\\PL")
//                    .splitAsStream(contents)//转换成流
//                    .filter(s -> s.length() > 13);
//            //如何需要去重并且-排序
//            TreeSet<String> collect2 = stringStreams.collect(Collectors.toCollection(TreeSet::new));
//            collect2.forEach(System.out::println);

            Stream<Object> objectStream = Stream.ofNullable(new Person(1,"stan"));

            System.out.println("========================将迭代器对象转成流===================================");
            //TODO  当iterable对象不是集合时 可以使用StreamSupport.stream  转换成流的方法
            //stream() 方法有两个参数：一个是 Spliterator是迭代器的一部分，
            // 另一个是 boolean，指示是否创建并行流。
            Stream<BigInteger> stream = StreamSupport.stream(iterate.spliterator(), false);

            //TODO StreamSupport.stream
            // StreamSupport.stream(Spliterators.spliteratorUnknownSize(iterate,  Spliterator.ORDERED), false);
            //spliteratorUnknownSize: 这是一个静态方法，用于创建一个拥有未知大小（size unknown）的Spliterator。
            //它接受两个参数：
            //iterate: 表示要被分割的元素。
            //ORDERED，表示流的顺序应该与源数据的顺序一致。

            // 1.创建一个迭代器，生成一系列字符串
            Iterator<String> iterator = Arrays.asList("apple", "banana", "kiwi", "pear", "grape").iterator();
            // 2.使用StreamSupport和Spliterators将 迭代器 转换 为顺序流
            Stream<String> streamStr = StreamSupport
                    .stream(Spliterators.spliteratorUnknownSize(iterator, Spliterator.ORDERED), false);
            streamStr.filter(s -> s.length() > 3)
                    .map(String::toUpperCase) //将字符串转为大写
                    .forEach(System.out::println);


            System.out.println("=======================map操作数据=====================================");
            //TODO 假设我们有一个包含用户对象的列表，我们想要获取所有用户的用户名并转换为大写(使用map)
            List<Person> users = Arrays.asList(
                    new Person(1,"S1"),
                    new Person(2,"S2"),
                    new Person(3,"S3")
            );

            List<String> usernames = users.stream()
                    .map(Person::getName)  // 提取用户名
                    .map(String::toUpperCase)  // 转换为大写
                    .collect(Collectors.toList());
            usernames.forEach(System.out::println);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
