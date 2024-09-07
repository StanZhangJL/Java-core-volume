package day11.stream;

import java.math.BigInteger;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * 生成一个对象流
 */
public class ObjectStream {
    public static void main(String[] args) {
        Stream<Person> generate = Stream.generate(new Supplier<Person>() {
            private int id = 1;

            @Override
            public Person get() {
                return new Person(id++, "stanPerson" + id);
            }
        });

        //输出对象流
        generate.limit(3)
                .forEach(System.out::println);



    }

}

class Person {
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{id=" + id + ", name='" + name + "'}";
    }
}