package day8.refiletion;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestMethod {
    public static void main(String[] args) {
        Class<?> methodDemoClass = MethodDemo.class;

        // 获取名为 "staticMethod" 的静态方法，参数类型为 String
        try {
            Method staticMethod = methodDemoClass.getMethod("staticMethod", String.class);
            // 通过反射调用静态方法，传递 null 作为对象实例参数，传递实际参数
            Object invoke = staticMethod.invoke(null, "Hello, reflection!");
            System.out.println(invoke);

        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            // 捕获所有异常，并打印异常信息
            e.printStackTrace();
            throw new RuntimeException(e);
        }


    }
}
