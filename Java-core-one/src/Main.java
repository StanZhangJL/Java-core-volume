import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println("当前时间是：" + now);

        LocalDate localDate = LocalDate.of(2024, 06, 30);
        System.out.println(localDate);
        int[] num = {1, 2};

        Point point = new Point(10, 99);
        System.out.println("PO" + point.toString());

        String str = "55";
        int nums = 66;
        //valueOf(int i): 返回一个表示指定 int 值的 Integer 实例。
        Integer integer = Integer.valueOf(nums);

        //valueOf(String s): 返回一个保存指定的字符串值的 Integer 对象。
        Integer integer1 = Integer.valueOf(str);

        //parseInt(String s): 将字符串解析为 int 类型。
        int i = Integer.parseInt(str);

        //toString(): 将 Integer 对象转换为字符串。
        Integer integers = 99;
        String string = integers.toString();
        System.out.println(string);


        //自动装箱
        Integer integer2 = 30;
        //自动拆箱
        int nums1 = integer2;

        System.out.println("List 的使用==================================================");

        // 如果要将一个数组转为list 必须使用包装类,添加后不能对元素修改，否者会报错，
        // int[] ints = {15,16,98,44};
        Integer[] ints = {15,16,98,44};
        List list = Arrays.asList(ints);
        list.stream().forEach(System.out::println);

        // 如果需要进行添加删除使用new ArrayList<>() 让后将Arrays.asList()传入
        List lists = new ArrayList(Arrays.asList(ints));
        lists.stream().forEach(System.out::println);

    }
}