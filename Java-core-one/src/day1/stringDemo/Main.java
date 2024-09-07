package day1.stringDemo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {

        int num = 12;
        double sss = 23.22;
        String str = "Hello";
        String s = str + num;
        System.out.println(s);

        //可以用于将多个字符串使用指定的分隔符连接起来。
        String join = String.join("——", "S", "M", "L");
        System.out.println("JOIN=" + join);

        List<String> fruit = Arrays.asList("apple", "orange", "banana", "grape");
        String result = String.join(", ", fruit);
        System.out.println(result);

        String s3 = join.replaceAll("——", "=");
        System.out.println(s3);
        //字符串又变回去了
        //System.out.println(join.strip());

        //JDK 11
        String repeat = "JAVA".repeat(3);
        System.out.println(repeat);

        String sg = "greeting";
        String s1 = sg.substring(0, 3) + "p!";
        System.out.println(s1);

        //compareTo
        /**
         * 返回零：当前对象等于比较对象。
         * 返回负整数：当前对象小于比较对象。
         * 返回正整数：当前对象大于比较对象。
         */
        if (s1.compareTo("grep!") == 0) {
            System.out.println("额: 他们相等"+ s1.compareTo("grep!"));
        }else {
            System.out.println("额: 他们不不不相等"+ s1.compareTo("grep!"));
        }

        String zhang = "ZHANG_STAN";
        //在字符串中第一次出现的下标是多少
        int z = zhang.indexOf("A");

        //在字符串中最后一次出现的下标是多少
        int n = zhang.lastIndexOf("N");
        String replace = zhang.replace('Z', 'z');
        System.out.println("zhang:===============" + z + " " + n);
        System.out.println(replace);

        //将一个old字符串 替换成新的字符串
        String ss = replace.replace(replace, "sssS");
        System.out.println(ss);

        //将字符串中所有的s 替换成a
        String s2 = ss.replaceAll("s", "a");
        System.out.println(s2);

        // 截取字符串长度 s2.substring(beginIndex , end);
        System.out.println(s2.substring(1, 3));

        //将字符串中的大写改为小写
        System.out.println(s2.toLowerCase());

        //将字符串中的小写改为大写
        System.out.println(s2.toUpperCase());

        // 去掉左右空格  类似 trim（）
        System.out.println(s2.strip());

        String strs = "apple,orange,banana,grape";
        String[] fruits = strs.split(",");

        for (String fruitt : fruits) {
            System.out.println(fruitt);
        }

        // StringBuilder is JDK5 产生的，introduce 他的前身是StringBuffer

        //StringBuilder：适用于在单线程环境中需要频繁修改字符串的情况。
        //StringBuilder 是非线程安全的，但性能更高。

        //StringBuffer：适用于在多线程环境中需要频繁修改字符串的情况。是线程安全的
        StringBuilder stringBuilder = new StringBuilder();
        String string = stringBuilder.append(s3).toString();

       //读取文件的Demo
        String filePath = "c:\\zhang.txt";
        StringBuilder stringBuilders = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            //读取当前的行存入line变量中
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilders.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 输出构建的字符串
        System.out.println(stringBuilder.toString());


        Scanner in = new Scanner(System.in);  // 创建 Scanner 对象以读取标准输入
        System.out.println("Please enter a line of text:");

        String input = in.nextLine();  // 读取整行输入
        System.out.println("You entered: " + input);

        in.close();  // 关闭 Scanner

        //PrintWriter写入文本 和 Scanner 读取文本内容
        //PrintWriter 定义在try()中
        // 1.自动关闭资源
        // 2.代码简洁性:
        // 3.传统方式 ：传统方式需要手动在 finally 块中关闭资源，代码相对冗长
        try (PrintWriter printWriter = new PrintWriter("c:\\zhang.txt", StandardCharsets.UTF_8)){
            //文本写入
            // 写入文本内容到文件
            printWriter.println("Hello, World!");
            printWriter.println("This is a test.");
            printWriter.println("Writing to a file using PrintWriter.");
            printWriter.printf("You can use format specifiers like %d, %f, and %s.%n", 42, 3.14, "example");

            // 所有写入操作完成后，文件会自动关闭
            System.out.println("Text written to file successfully.");
        } catch (IOException e) {

            throw new RuntimeException(e);
        }finally {
            Scanner scanner = new Scanner(Path.of("c:\\zhang.txt"), StandardCharsets.UTF_8);
            while (scanner.hasNextLine()){
                String sc = scanner.nextLine();
                System.out.println(sc);
            }
        }

        //copy 数组
        String[] arr = {"Stan", "live", "mao"};
        String[] ass = Arrays.copyOf(arr, arr.length);
        for (String ass1 : ass) {
            System.out.println(ass1);
        }
        System.out.println(LocalDate.now());

    }
}