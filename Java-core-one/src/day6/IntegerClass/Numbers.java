package day6.IntegerClass;

/**
 * Integer Long Float Double Short Byte Character Boolean 他们共有的父类是Number。
 */

public class Numbers {
    public static void main(String[] args) {
        //自动装箱
        Integer integer2 = 30;
        //自动拆箱
        int nums1 = integer2;

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
        System.out.println(n * 2);

        int i3 = n.intValue();

        //在一个表达式中 如果混用了Integer和double类型，
        // Integer值会拆箱，提升为double在装箱为Double


        //拆箱和装箱是编译器要做的工作 而不是虚拟机要做的



//        public static void sums(Integer nums){
//            nums = 2 * nums;
//
//        }
    }
}
