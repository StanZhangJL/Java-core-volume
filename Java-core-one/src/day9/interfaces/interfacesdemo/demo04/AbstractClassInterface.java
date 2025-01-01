package day9.interfaces.interfacesdemo.demo04;

//TODO 存在冲突的情况：
/**
 * 如果两个接口的方法签名相同，但它们都提供了默认实现（default），类必须显式解决冲突。
 * 解决方法：
 * 重写冲突方法：类必须显式地实现该方法，提供自己的逻辑。
 * 声明为抽象类：如果类不想立即提供实现，可以将类声明为抽象类，让子类来解决这个问题
 */

public abstract class AbstractClassInterface implements InterfaceA, InterfaceB {

    //1.重写冲突方法：类必须显式地实现该方法，提供自己的逻辑。
    //    @Override
//    public void method() {
//        InterfaceA.super.method();
//    }


    //2.声明为抽象类：如果类不想立即提供实现，可以将类声明为抽象类，让子类来解决这个问题
    // 必须解决冲突，否则无法编译
    public abstract void method(); // 声明为抽象方法
}


interface InterfaceA {
    default void method() {
        System.out.println("InterfaceA method");
    }
}

interface InterfaceB {
    default void method() {
        System.out.println("InterfaceB method");
    }
}