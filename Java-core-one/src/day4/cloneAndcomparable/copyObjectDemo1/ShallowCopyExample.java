package day4.cloneAndcomparable.copyObjectDemo1;

public class ShallowCopyExample {
    public static void main(String[] args) throws CloneNotSupportedException {
        Address address = new Address("New York");
        Person person1 = new Person("John", 25, address);

        // 浅拷贝person1到person2
        Person person2 = person1.clone();

        // 修改person2的address的city
        person2.address.city = "Los Angeles";

        System.out.println("person1's address city: " + person1.address.city); // "Los Angeles"
        System.out.println("person2's address city: " + person2.address.city); // "Los Angeles"
    }

    /**
     * 浅拷贝：
     * 在上面的代码中，person1 和 person2 共享相同的 address 对象，
     * 因此修改 person2 的 address 会影响 person1 的 address。
     */
}
