package day4.cloneAndcomparable.shallowCopy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Person implements Cloneable,Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = "sss";
        this.age = age;
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    //通过实现 Comparable 接口并重写 compareTo() 方法，可以定义对象的自然排序顺序。
    @Override
    public int compareTo(Person person) {
        return Integer.compare(this.age, person.age);
    }

    public static void main(String[] args) {

        //浅克隆示例
        try {


            Person original  = new Person("stan", 12);
            System.out.println(original.name);
            //使用重写clone方法 创建对象副本，因为是调用父类的clone方法返回的是obj类型
            // 所以这里需要将对象类型强转成Person
            Person cloned = (Person) original.clone();

            System.out.println("Original: " + original);
            System.out.println("Cloned: " + cloned);

            cloned.setName("Jane");
            cloned.setAge(25);

            System.out.println("After modification:=========================");
            System.out.println("Original: " + original);
            System.out.println("Cloned: " + cloned);
            List<Person> people = new ArrayList<>();
            people.add(original);
            people.add(cloned);
            //Collections.sort(people);

            //使用lambda进行对象比较排序 排序进行 打印
            people.sort((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()));
            people.sort(Comparator.comparingInt(Person::getAge));

            //打印
            people.forEach(System.out::println);

            int i = original.compareTo(cloned);

        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

    }


}
