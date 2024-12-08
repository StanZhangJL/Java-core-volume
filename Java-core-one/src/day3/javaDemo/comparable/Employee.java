package day3.javaDemo.comparable;

import java.time.LocalDate;
import java.util.Objects;

public class Employee implements Cloneable{
    private String name;
    private double say;
    private LocalDate localDate;

    public Employee(String name, double say, LocalDate localDate) {

        //如果requireNonNullElse为null就使用默认值unkown
        //如果requireNonNull为null,使用requireNonNullElse方法的默认值,这样程序不会包空指针而导致终止.

        name = Objects.requireNonNullElse(name , "unkown");

        //java 9中 严格型拒绝null参数
        name = Objects.requireNonNull(name , "The name cannot be null");
        this.name = name;
        this.say = say;
        this.localDate = localDate;
    }

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSay() {
        return say;
    }

    public void setSay(double say) {
        this.say = say;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", say=" + say +
                ", localDate=" + localDate +
                '}';
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Employee employee = new Employee(null, 11, LocalDate.now());
        //在对象中传入null
        employee.setName(null);
        employee.setSay(12.25);
        employee.setLocalDate(LocalDate.now());
        System.out.println(employee);
        employee.clone();

        String name = null;
        if (employee.getName() == null) {
            name = employee.getName();
            name = "unknown";
            System.out.println("name======" + name);
        }else {
            name = employee.getName();
            System.out.println("name======" + name);
        }

        if (employee.getName() == null) {
            name = employee.getName();
            name = "unknown";
        }else {
            name = employee.getName();
        }
    }
}
