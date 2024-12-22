package day10.lamada.demo3;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.time.Instant;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class Lamada {
    /**
     * 1.Lambda表达式可以很方便地实现只有一个抽象方法的接口，也就是我们常说的函数式接口。
     *
     * @param args
     */


    public static void main(String[] args) {
        ActionListener actionListener = (e) -> System.out.println(Instant.ofEpochMilli(e.getWhen()));
        Comparator<String> comparator = (fist, send) -> fist.length() - send.length();

        String[] strings = {"java", "c++", "php", "python", "go"};
        System.out.println("Arrays.toString(strings) = " + Arrays.toString(strings));

        //使用的是自然顺序（自然排序），即按字典顺序（或称为词典顺序、字母顺序）对字符串数组进行排序。
        Arrays.sort(strings);
        System.out.println("Arrays.toString(strings) = " + Arrays.toString(strings));

        //lamda 按照字符串长度排序
        Arrays.sort(strings, (first, second) -> first.length() - second.length());
        System.out.println("Arrays.sort by length=" + Arrays.toString(strings));

        Timer timer = new Timer(1000, event -> System.out.println("The time is" + new Date()));
        timer.start();

        //keep program running until user select "ok"
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);



    }
}
