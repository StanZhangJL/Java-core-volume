package day5.absclass;

public class Emps extends Person{

    public Emps(String name, Integer age) {
        super(name, age);
    }

    @Override
    public String lastName() {
        return null;
    }

    @Override
    public String toString() {
        return "Emps{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
