package day8.refiletion;

import day5.absclass.Emps;
import day5.absclass.Student;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Random;

public class ClassRefiletion {
    public static void main(String[] args) {
        Student student = new Student("STAN", 18, "PHP");
        Emps amos = new Emps("AMOS", 18);

        //通过getClass()方法获取对象 对象来确定两个对象是否属于同一个类。
        if (student.getClass() == Student.class){
            System.out.println("student======是一个类=========================");
        }
        if (amos.getClass() == Emps.class){
            System.out.println("amos=========是一个类========================");
        }

        //使用forName来加载类
        try {
            Class<?> aClass = Class.forName("day5.absclass.Student");
            //Object object = aClass.newInstance();
            // newInstance()已经弃用 使用下面这种代替
            Object object = aClass.getDeclaredConstructor().newInstance();

            //获取一个 无参构造器对象 通过构造器类型对象  然后使用newInstance来构造一个对象实例
            Object object1 = aClass.getConstructor().newInstance();
            System.out.println("object1 =======" + object1);

            //getConstructor用法 有参构造器
            Constructor<?> constructor = aClass.getConstructor(String.class, int.class, String.class);
            // 允许访问非公共构造函数
           // constructor.setAccessible(true);
            Object object2 = constructor.newInstance("MIKE", 15, "c++");
            System.out.println("object2 =======" + object2);


            // ReflectiveOperationException它是以下异常的父类：
            // ClassNotFoundException
            // NoSuchMethodException
            // InstantiationException
            // IllegalAccessException
            // InvocationTargetException

            //TODO setAccessible()方法可以用在field,Method,Constructor,来覆盖对象的访问控制
            Emps nancy = new Emps("Nancy", 18);
            Class<? extends Emps> aClass1 = nancy.getClass();
            Field ageField1 = aClass1.getField("name");
            Field ageField2 = aClass1.getField("age");

            //1.通过反射的get方法获取当前字段的值
            Object object3 = ageField1.get(nancy);
            Object object3s = ageField2.get(nancy);
            System.out.println("object3==========name:" + object3 + "  age:"+ object3s);

            //2.通过反射的set方法设置当前字段的值
            Emps nancys = new Emps("Nancy", 22);
            Class<? extends Emps> aClasss = nancys.getClass();
            // 因为属性是私有的 所以需要设置 可访问权限setAccessible
            aClasss.getField("name").setAccessible(true);
            aClasss.getField("name").set(nancys, "Stan");
            Object age1 = aClasss.getField("name").get(nancys);
            System.out.println("stan: " + age1);


            //获取当前类的名, 包名
            //String nameClass = aClass1.getDeclaringClass().getName();
            String packageName = aClass1.getPackageName();
            String className = aClass1.getName();
            System.out.println( " 包名：" + packageName + " 类.名 ：" + className);


            //DOg
            Dog dog = new Dog("花花", 19, 'N');
            Class<? extends Dog> aClass2 = dog.getClass();

            // 以下三个方法将分别返回类的中声明的全部字段丶全部方法丶全部构造方法
            Field[] declaredFields = Dog.class.getDeclaredFields();
            Method[] declaredMethods = Dog.class.getDeclaredMethods();
            Constructor<?>[] declaredConstructors = Dog.class.getDeclaredConstructors();

            // 通过反射的get方法获取当前字段的值
            // 因为属性是私有的 所以需要设置 可访问权限setAccessible
            Field age = aClass2.getDeclaredField("age");
            //age.setAccessible(true);

            //获取一个类中字段的修饰符 字段名 字段类型
            String type = Modifier.toString(age.getModifiers());
            String fieldName = age.getName();
            String fieldTypeName = age.getType().getName();
            System.out.println("字段修饰符: " + type + " 字段名：" +fieldName +" 字段的类型" + fieldTypeName);


            //TODO : JAVA 9中使用这个更加安全
            // trySetAccessible 方法尝试将字段设置为可访问的使用 trySetAccessible 方法可以更安全地尝试访问私有字段
            boolean b = age.trySetAccessible();
            boolean b1 = age.canAccess(dog);

            System.out.println("b1=================" + b1);

            Object object4 = age.get(dog);
            System.out.println("object4=================" + object4);



            //TODO Array 类提供了用于通过反射操作数组的静态方法，
            //包括get和set方法。这些方法允许在不知道具体数组类型的情况下访问和修改数组的元素。
            int[] array = {1, 2, 3, 4, 5};

            //通过给定的索引访问该位置上的value
            int value = (int) Array.get(array, 2);
            System.out.println("Value at index 2: " + value); // 输出: Value at index 2: 3

            //使用反射设置数组中的元素 将一个新的值存储到给定的索引位置上的值
            Array.set(array, 2, 10);
            System.out.println("New value at index 2: " + array[2]); // 输出: New value at index 2: 10

            Class<?> componentType = int.class;

            // // 使用反射创建一个新的数组实例
            int[] ints = (int[]) Array.newInstance(componentType, array.length);
            //// 初始化数组中的元素
            for (int i = 0; i < ints.length; i++) {
                Array.set(ints, i ,i+1);
            }
            // 输出数组中的元素
            System.out.println(Arrays.toString(ints));

            //通过反射获取Method对象 获取getName方法的返回值  通过invoke方法获得value
            Method getName = Emps.class.getMethod("getName");
            String nancy1 = (String)getName.invoke(nancy);
            System.out.println("nancy1 :" + nancy1);

            Method getAge = Emps.class.getMethod("getAge");
            //getModifiers 返回一个整数用不用的0/1位描述所使用的修饰符 如public static
            int modifiers = getAge.getModifiers();
            System.out.println("modifiers:" + modifiers);

            //Modifier isPublic静态方法判断方法或者构造器是public
            boolean aFinal = Modifier.isFinal(getAge.getModifiers());
            boolean aPublic = Modifier.isPublic(getAge.getModifiers());
            boolean aPrivate = Modifier.isPrivate(getAge.getModifiers());
            System.out.println("aFinal: "+ aFinal + " aPublic: " + aPublic + " aPrivate: " + aPrivate);

            //获取方法修饰符 Modifier.toString 打印结果 public
            String string = Modifier.toString(getAge.getModifiers());
            System.out.println("Modifier.toString: " + string);

            //获取方法返回类型
            String name = getAge.getReturnType().getName();
            System.out.println("返回类型 " + name);

            //获取方法参数类型
            Class<?>[] parameterTypes = getAge.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println(parameterType.getName());

            }


            Object invoke = getAge.invoke(nancy);
            System.out.println(invoke);

            Class randomClass = Random.class;
            Constructor cs = randomClass.getConstructor(long.class);
            Object object5 = cs.newInstance(42L);



        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }


    }
}

class Dog{
    private String name;
    private int age;
    private char sex;

    public Dog(String name, int age, char sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}