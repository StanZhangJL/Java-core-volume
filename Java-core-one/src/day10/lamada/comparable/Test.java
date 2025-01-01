package day10.lamada.comparable;

public class Test {
    public static void main(String[] args) {
        Employee employee = new Employee();

        //使用instanceof 来检查Employee 是否实现了Comparable接口
        if(employee instanceof Comparable){
            System.out.println("employee is Comparable=================");
        }

        Object obj = "Hello, World!";
        if (obj instanceof String) {
            System.out.println("obj is a String");
        }

        //类型安全的向下类型转换,在执行类型转换前检查，确保转换是安全的。
        Object objo = "Java";
        if (obj instanceof String) {
            String str = (String) objo;
            System.out.println("String length: " + str.length());
        }




    }
}
