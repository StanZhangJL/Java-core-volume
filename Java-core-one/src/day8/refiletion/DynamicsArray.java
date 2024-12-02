package day8.refiletion;

import java.lang.reflect.Array;
import java.util.Arrays;

public class DynamicsArray {

    //使用反射编写泛型数组
    // 这个方法可以用来扩展任意类型的数组 而不仅仅是对象数组
    public static Object  goodCopyOf(Object obj, int newLength){
        Class cl = obj.getClass();
        if (!cl.isArray()) {
            return null;
        }
        Class componentType = cl.getComponentType();
        int length = Array.getLength(obj);
        Object newArray = Array.newInstance(componentType, length);
        System.arraycopy(obj, 0, newArray, 0, Math.min(length, newLength));
        return  newArray;
    }


    // 使用反射创建泛型数组的通用方法
    // 假设我们有一个泛型方法，它可以创建任何类型的数组：
    // 泛型方法，创建指定类型和大小的数组
    public static <T> T[] createArray(Class<T> clazz, int length) {
        // 使用反射创建一个指定类型的数组
        return (T[]) Array.newInstance(clazz, length);
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        a = (int[]) goodCopyOf(a, 10);
        System.out.println("Arrays.toString=====" + Arrays.toString(a) + "arr length=" + a.length);

        for (int i : a) {
            System.out.println(i);
        }
        System.out.println("a length========" + a.length);

        System.out.println("动态创建数组=============================================");
        // 创建一个 Integer 类型的数组
        Integer[] intArray = createArray(Integer.class, 10);
        intArray[0] = 1;
        intArray[1] = 2;

        // 创建一个 String 类型的数组
        String[] strArray = createArray(String.class, 5);
        strArray[0] = "Hello";
        strArray[1] = "World";

        /**
         * 总结
         * 使用反射来创建泛型数组，可以在运行时根据需求动态地创建数组，
         * 并且避免了类型擦除的问题。在框架设计、反序列化、动态数据结构等场景中非常有用。
         * 尽管反射提供了灵活性，但也带来了性能上的开销和类型安全的挑战，因此在使用时需要谨慎。
         */


    }

}

