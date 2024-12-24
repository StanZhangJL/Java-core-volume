package day10.lamada.comparObject;

public class Test {
    public static void main(String[] args) {
        Employee manager1 = new Manager(100000);
        Employee manager2 = new Manager(120000);
        Employee secretary = new Secretary(5);

        System.out.println(manager1.compareTo(manager2)); // -1
        System.out.println(manager2.compareTo(manager1)); // 1

        try {
            System.out.println(manager1.compareTo(secretary)); // 抛出 ClassCastException
        } catch (ClassCastException e) {
           e.printStackTrace();
        }
    }
}
