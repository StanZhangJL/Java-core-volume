package day10.lamada;


import day5.absclass.Student;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaDemo {
    private String name;

    public static void main(String[] args) {
        List<String> list = new ArrayList();
        list.add("stan");
        list.add("amos");
        list.add(null);
        list.add("mike");

        //lambda 从list中删除所有为null的值
        list.removeIf(e -> e == null);
//        list.removeIf(Objects::isNull); => 等价于 list.removeIf(e -> e == null);
        list.forEach(System.out::println);


        Stream<Student> stream = list.stream().map(Student::new);
        //collect将流中的元素收集到一个集合或其他容器中。
        List<Student> collect = stream.collect(Collectors.toList());
        collect.forEach(System.out::println);

        //TODO 方法引用形式 :: 运算符主要用于简化Lambda表达式的书写
        Function<String, Integer> func = Integer::parseInt;
        //TODO Lambda表达式形式
        Function<String, Integer> funcs = (String s) -> Integer.parseInt(s);


        List<String> strings = Arrays.asList("1", "2", "3");
        //TODO Lambda表达式形式
        // 使用方法引用
        strings.stream()
                .map(Integer::parseInt)
                .forEach(System.out::println);

        //TODO 使用Lambda表达式
        strings.stream()
                .map(s -> Integer.parseInt(s))
                .forEach(i -> System.out.println(i));

        List<String> stringArr = Arrays.asList("Apple", "banana", "Orange", "apple", "Banana", "orange");

        //TODO 使用Lambda表达式
        stringArr.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
        System.out.println("使用Lambda表达式排序后的列表: " + stringArr);

        stringArr.sort((s1, s2) -> s1.compareTo(s2));
        System.out.println("使用Lambda表达式排序后的列表compareTo: " + stringArr);

        //TODO 使用方法引用
        stringArr.sort(String::compareToIgnoreCase);
        System.out.println("使用方法引用排序后的列表: " + stringArr);

        //reduce方法将流中的元素聚合成一个结果。
        String reduce = stringArr.stream().
                reduce("", (s1, s2) -> s1.isEmpty() ? s2 : s1.concat(",").concat(s2));
        System.out.println("连接后的字符串: = " + reduce);

        //sorted对流中的元素进行排序。
//        List<User> sortedUsers = users.stream()
//                .sorted(Comparator.comparing(User::getName))
//                .collect(Collectors.toList());
        System.out.println("stream().map将字符串转成大小映射到map中");
        stringArr.stream().map(String::toUpperCase).forEach(System.out::println);
        //过滤出A开头的字母
        stringArr.stream().map(String::toUpperCase).filter(s -> s.startsWith("A")).forEach(System.out::println);
        //过滤出包含A的
        stringArr.stream().map(String::toUpperCase).filter(s -> s.contains("A")).forEach(System.out::println);

        //TODO String::concat
        List<String> sss = Arrays.asList("Hello", " ", "World", "!");
        //TODO 使用Stream API和方法引用连接字符串
        String result = sss.stream()
                .reduce("", String::concat);
        System.out.println(result);

        //TODO 构造方法引用  将一个字符串列表转换成student对象
        Stream<Student> studentStream = stringArr.stream().map(Student::new);
        List<Student> collect1 = studentStream.collect(Collectors.toList());
        collect1.forEach(System.out::println);

        //TODO 使用流进行过滤和映射操作
        List<String> resultList = stringArr.stream()
                .filter(s -> s.length() > 3)  // 过滤长度大于3的字符串
                .map(String::toUpperCase)     // 将字符串转换为大写
                .collect(Collectors.toList()); // 收集到新的列表中
        resultList.forEach(System.out::println);

        //TODO 使用 stream.toArray(Student[]::new) 返回要给的对象数组
//        Student[] array = stream.toArray(Student[]::new);
//        System.out.println(Arrays.toString(array));

        LambdaDemo.repeMessage("hello....",1000);


        System.out.println("Optional==========================用法");
        //TODO java.util.Optional 类的方法
        //ifPresent(Consumer<? super T> action)
        // 描述: 如果值存在，执行操作。
       // optionalUser.ifPresent(user -> System.out.println(user.getName()));
        //查找第一个判断是否存在
        List<Integer> integerList = Arrays.asList(1, 3, 6, 9, 12, 66);
        Optional<Integer> first = integerList.stream().filter(n -> n % 2 == 0).findFirst();
        first.ifPresent(System.out::println);

        // TODO Predicate 接口通常用于条件判断，接受一个参数并返回 boolean 值。
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        //传统写法 获取一个A开头的条件
        Predicate<String> startsWith = new Predicate<>() {
            @Override
            public boolean test(String s) {
                return s.startsWith("A");
            }
        };

        //Lambda的写法 获取一个A开头的条件
        Predicate<String> startsWiths = s -> s.startsWith("A");
        names.stream().filter(startsWiths).forEach(System.out::println);


    }

    //TODO 变量作用域
    public static void repeMessage(String text, int delay){
        ActionListener listener = e -> {
            System.out.println(text);
            Toolkit.getDefaultToolkit().beep();
        };
        new Timer(delay,listener).start();
        JOptionPane.showMessageDialog(null, "Quit exit???");
    }
}
