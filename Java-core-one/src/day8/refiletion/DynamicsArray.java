package day8.refiletion;

import java.lang.reflect.Array;
import java.util.Arrays;

public class DynamicsArray {

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

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        a = (int[]) goodCopyOf(a, 10);
        System.out.println("Arrays.toString=====" + Arrays.toString(a));


        for (int i : a) {
            System.out.println(i);
        }
        System.out.println("a length========" + a.length);


    }

}

