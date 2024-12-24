package day10.lamada.demo1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DemoLambda {
    /**
     * 1. 想象一下，你有个接口，里面就一个方法，比如 Comparator 用来比较两个东西大小。以前你得创建一个类实现这个接口，
     * 然后重写那个方法，挺麻烦的对吧？
     *
     * 2.现在有了 Lambda，你可以直接写成这样 (a, b) -> a - b ，是不是简洁好多！Java 编译器一看，哦，这是个 Comparator，
     * 它自动帮你创建了一个匿名内部类实现了这个接口。所以说，Lambda 本身不是接口，它是一种表达式，一种更简洁的写法。
     * 这种写法特别适合用在函数式接口上，因为它能让你少写很多代码。 Java 8 引入 Lambda 主要就是为了支持函数式编程，让代码更优雅、更易读。
     * 当然，Lambda 不仅仅能用在只有一个抽象方法的接口上，配合 @FunctionalInterface 注解，可以更好地保证接口是函数式接口，
     * 避免不小心加了其他方法。 不过最常用的场景还是跟函数式接口一起用。
     * 总而言之，Lambda 让实现函数式接口变得超级简单！ 就像一个快捷方式，帮你省去了很多繁琐的代码。
     * 你不用再写一堆匿名内部类了，直接用 Lambda 搞定！
     *
     */

    //todo 代码演示
    public static void main(String[] args) {
        // 1.(a, b)：参数列表。 这部分定义了 Lambda 表达式需要的参数。在这里，它需要两个参数，a 和 b，就像一个普通方法的参数一样。
        // 如果只有一个参数，括号可以省略，例如 a -> a * 2；如果没有参数，就写成空括号 () -> System.out.println("Hello")。
        // 参数的类型可以显式声明，也可以由编译器推断，就像这里的例子，编译器会根据上下文推断出 a 和 b 都是 int 类型。

        //2. ->：箭头。 这个箭头把参数列表和表达式主体分开，可以理解成 "goes to" 或者 "maps to" 的意思，
        // 表示 "把参数传递给" 后面的表达式。

        //3. a + b：表达式主体。 这部分是 Lambda 表达式实际执行的代码。在这里，它 simply 将 a 和 b 相加。
        // 表达式主体的结果会被自动作为 Lambda 表达式的返回值。 如果表达式主体比较复杂，可以用大括号 {} 括起来，
        // 就像一个普通的代码块，例如：
        // 如果使用大括号，需要显式地使用 return 语句返回结果。
//        (a, b) -> {
//            int sum = a + b;
//            System.out.println("Calculating sum: " + sum);
//            return sum;
//        }

        // 4. 所以， (a, b) -> a + b 这个 Lambda 表达式就相当于一个匿名方法，接受两个 int 类型的参数 a 和 b，然后返回它们的和。
        // 它通常被用来实现只有一个抽象方法的接口（函数式接口）有且只有一个抽象方法，例如本例中的MyInterface。
        //简单来说，就像一个简化的、匿名的函数定义。

        MyInterface add = (a, b) -> a + b;
        MyInterface subtract = (a, b) -> a - b;

        // 调用方法
        int sum = add.operate(5, 3);
        int difference = subtract.operate(5, 3);

        System.out.println("Sum: " + sum); // 输出：Sum: 8
        System.out.println("Difference: " + difference); // 输出：Difference: 2


        //另外，Java 内置了很多函数式接口，比如 Runnable，Comparator 等，
        // 你都可以用 Lambda 表达式来实现它们，进一步简化代码。 例如：
        // 使用 Lambda 表达式实现 Runnable (Runnable有且只有一个抽象方法 run())。
        Runnable runnable = () -> System.out.println("Hello from a thread!");
        Thread thread = new Thread(runnable);
        thread.start();


        // 使用 Lambda 表达式实现 Comparator
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        Collections.sort(names, (s1, s2) -> s1.compareToIgnoreCase(s2)); // 忽略大小写排序
        System.out.println(names); // 输出：[Alice, Bob, Charlie]

        // 1. Lambda 表达式的写法，提供了一种简洁的语法来实现函数式接口的抽象方法
        // 2. Lambda 表达式会被编译器转换成一个实现了目标函数式接口的匿名类的实例。
        // 这个匿名类会重写（实现）函数式接口中的抽象方法，而 Lambda 表达式的主体部分就是这个重写方法的具体实现。
        //
        // 总而言之，Lambda 表达式提供了一种简洁的语法糖来实现函数式接口， 它本质上是生成了一个实现了该接口的匿名类的实例.
        // 这个匿名类会重写（实现）函数式接口中的抽象方法，而 Lambda 表达式的主体（a + b：表达式主体）部分就是这个重写方法的具体实现。

        //TODO
        // 1. sort()方法  static void sort(Object[] a) 对数组a中的元素进行排序时，
        // 要求数组中的元素必须属于实现了comparable接口的类，并且元素之间是可比较的.
        // 2. static int compar（int x, int y）;r 如果x < y 返回负数，相等返回0，否则返回正数.

    }


}


//配合 @FunctionalInterface 注解，可以更好地保证接口是函数式接口
@FunctionalInterface
interface MyInterface {
    int operate(int a, int b);
}