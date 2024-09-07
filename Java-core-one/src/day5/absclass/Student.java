package day5.absclass;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

public  class Student extends Person {
    private String major;

    public Student() {}

    public Student(String name, int age, String major) {
        super(name, age);
        this.major = major;
    }

    public Student(String s) {
        super(s);
    }

    public String lastName(){
        return " my major is " + major;
    }

    @Override
    public String toString() {
        return "Student{" +
                "major='" + major + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        Emps sss = new Emps("sss", 12);
        Student student = new Student("sssss", 18, "java");
        Student studentsss = new Student("sss111s", 18, "php");

        //反射 两个类对象的比较 是否属于同一个类
        if (student.getClass() == studentsss.getClass()) {
            System.out.println("类是属于同一个类。。。。。。。。。。。。。。。。。。");
        }

        if (sss.getClass() == Emps.class) {
            System.out.println("类是属于同一个类sss。。。。。。。。。。。。。。。。。。");
        }

        //用于比较两个对象是否相等 ，处理了 null 的情况，避免了 NullPointerException。
        boolean equals = Objects.equals(sss, student);
        System.out.println(equals);

        //检查对象是否为 null，如果为 null 则抛出 NullPointerException。
        Student student1 = Objects.requireNonNull(student);
        System.out.println("stu1:=======" + student1);

        Student students = null;
//        //检查对象是否为 null，如果为 null 则抛出带有指定消息的 NullPointerException。
        Student student2 = Objects.requireNonNull(student, "对象不存在");
        System.out.println("stu2:=======" + student2);

        var students1 = new ArrayList<>();
        students1.add(student);
        //students1.add(sss);
        students1.forEach(System.out::println);

        //修改现有list中的元素
        students1.set(0,new Student("mike", 33, "pmp"));
        Student student3 = (Student) students1.get(0);

        students1.forEach(System.out::println);

        var students2 = new Student[students1.size()];
        Student[] array = students1.toArray(students2);
        for (Object student4 : array) {
            System.out.println("toArry:==============" + student4);
        }


        ArrayList<Emps> staff = new ArrayList<>(100);
        /**
         *
         * 在Java的集合框架中，ensureCapacity方法用于确保集合能够容纳指定数量的元素，
         * 而无需进行扩容操作。这个方法通常用于提高性能，避免在添加大量元素时多次触发扩容。
         * ArrayList类是常见的使用ensureCapacity方法的类。
         */
        staff.ensureCapacity(100);

        /**
        * trimToSize方法可以在不需要再添加元素时调用，以减少ArrayList的内存占用。
         * 这个方法将存储在list的大学调整为当前实际需要存储元素的所需要空间，垃圾回收
         * 器将回收多余的存储空间。
        */
        staff.trimToSize();

        Student p1 = new Student("Alice", 30,"计算机");
        Student p2 = new Student("Bob", 25, "英语");
        Student p3 = new Student("Charlie", 30, "数学");
        Student p4 = new Student("Charlie", 30, "数学");

        // 创建 Comparator 按年龄排序，如果年龄相同则按名字排序
        Comparator<Person> personComparator = Comparator
                .comparingInt(Person::getAge)
                .thenComparing(Person::getName);

        int comparisonResult1 = personComparator.compare(p1, p2);
        int comparisonResult2 = personComparator.compare(p1, p3);
        int comparisonResult3 = personComparator.compare(p4, p3);

        // 输出比较结果
        System.out.println("Comparison result between Alice and Bob: " + comparisonResult1);
        System.out.println("Comparison result between Alice and Charlie: " + comparisonResult2);
        System.out.println("Comparison result between Alice and p4444: " + comparisonResult3);

    }
}
