package day6.IntegerClass;

import java.math.BigDecimal;

/**
 * Integer Long Float Double Short Byte Character Boolean 他们共有的父类是Number。
 */

public class Numbers {
    public static void main(String[] args) {
        //自动装箱
        Integer integer2 = 30;
        //自动拆箱
        int nums1 = integer2;

        //valueOf(int i): 返回一个表示指定 int 值的 Integer 实例。
        int nums = 66;
        Integer integer = Integer.valueOf(nums);

        //valueOf(String s): 返回一个保存指定的字符串值的 Integer 对象。
        String str = "55";

        //注意这里的indexof返回的是字符串 str中下标0的字符串转成int
        int i4 = str.indexOf(0);

        //将字符串转成int类型在自动装箱
        Integer integer1 = Integer.valueOf(str);

        //将Int类型转成字符串
        String s = String.valueOf(88);


        //parseInt(String s): 将字符串解析为 int 类型。
        int i = Integer.parseInt(str);

        //toString(): 将 Integer 对象转换为字符串。
        Integer integers = 99;
        String string = integers.toString();
        System.out.println(string);

        Integer i1 = 1000;
        Integer i2 = 1000;
        if (i1 == i2) {
            System.out.println("i1 = i2 = true=============");

        }else {
            System.out.println("i1 != i2 = flase=============");

        }

        //比较两个包装器类型时 使用equals方法
        if (i1.equals(i2)) {
            System.out.println("i1 = i2 = true=============eq");
        }

        //注意事项：包装类引用类型可以为null 所以自动装箱会抛出一个空指针异常
        Integer n = null;
       // System.out.println(n * 2); //结果报空指针
        // int i3 = n.intValue();

        //避免空指针
        Integer num = null;
        int numInt = (num != null) ? num : 0; // 设置默认值

        // 1.在一个表达式中 如果混用了Integer和double类型，
        // Integer值会拆箱，提升为double在装箱为Double
        int a = 10;
        double b = 3.5;
        double result = a + b; // a 被提升为 10.0
        System.out.println(result); // 输出 13.5

        // 2.TODO 可能导致的问题
        //  double是浮点类型，存储的是近似值，可能会带来精度损失。
        int a1 = 1;
        double b1 = 0.1;
        double result1 = a - b;
        System.out.println(result1); // 输出 0.9，但可能显示为 0.8999999999999999

        // 3.TODO 意外的结果类型 如果期望结果是整数，但参与计算的操作数中有double，结果仍然是double。
        int a2 = 5;
        double b2 = 2.0;
        double result2 = a / b; // a 被提升为 5.0
        System.out.println(result2); // 输出 2.5

        // TODO 解决方法： 强制类型转换为整数：
        int finalResult = (int) (a2 / b2); // 强制将结果转换为 int
        System.out.println(finalResult); // 输出 2

        // 4.自动装箱和拆箱的性能问题 当使用包装类型Integer和基本类型double混用时，会发生 自动装箱（Autoboxing） 和 拆箱（Unboxing）。
        Integer a3 = 10;
        double b3 = 3.5;
        double result3 = a + b; // a 自动拆箱为 int，再提升为 double
        //自动装箱/拆箱在性能敏感的场景中可能会产生额外的开销。

        // 5.比较运算的问题 进行比较时，int会提升为double，这可能导致逻辑问题。
        int a4 = 1;
        double b4 = 1.0;
        System.out.println(a4 == b4); // 输出 true
        // 尽管结果为true，但实际比较的是1.0 == 1.0，在逻辑上可能不符合预期。

       // 6. 实际开发中的建议 (1) 明确类型，避免隐式提升 避免混用int和double，必要时进行显式转换。
        int a5 = 10;
        double b5 = 3.5;
        int result5 = (int) (a5 + b5); // 强制将结果转换为 int
        System.out.println(result5); // 输出 13

        // 7.优先使用 BigDecimal 处理精度问题 如果涉及到精度敏感的计算（如货币），建议使用BigDecimal
        BigDecimal a6 = new BigDecimal("1");
        BigDecimal b6 = new BigDecimal("0.1");
        BigDecimal result6 = a6.subtract(b6);
        System.out.println(result6); // 输出 0.9（精确）





        //拆箱和装箱是编译器要做的工作 而不是虚拟机要做的



//        public static void sums(Integer nums){
//            nums = 2 * nums;
//
//        }
    }
}
