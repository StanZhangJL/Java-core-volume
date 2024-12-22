package day9.interfaces.interfacesdemo.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//动态代理
public class DynamicProxyHandler implements InvocationHandler {
    private Object target;

    public DynamicProxyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before invoke");
        Object result = method.invoke(target, args);
        System.out.println("after invoke");
        return result;
    }

    public static Object newProxyInstance(Object target) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new DynamicProxyHandler(target));
    }
}
