package day4.cloneAndcomparable.copyObjectDemo1;

public class Person  implements Cloneable{

    String name;
    int age;
    Address address; // 引用类型字段

    public Person(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    // 实现Cloneable接口的clone方法
    public Person clone() throws CloneNotSupportedException {
        return (Person) super.clone();  // 执行浅拷贝
    }

    // TODO  实现深拷贝 但是使用下面这种方式Person和他的子对象Address不需要实现Cloneable
//    public Person deepCopy() {
//        // 创建新的Address对象，进行深拷贝
//        Address newAddress = new Address(this.address.city);
//        return new Person(this.name, this.age, newAddress);
//    }
}


class Address {
    String city;

    public Address(String city) {
        this.city = city;
    }
}



