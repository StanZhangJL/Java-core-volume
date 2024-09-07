package day4.clone.deepCopy;

public class Person implements Cloneable {
    private String name;
    private int age;
    private Address address;


    public Person(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age + '\'' +
                ", address"+
                '}';
    };

    //实现Cloneable 接口 重新clone 方法()进行深拷贝对象副本
    public Person clone() throws CloneNotSupportedException {
        Person cloned  = (Person) super.clone();
        cloned.address = (Address) address.clone();
        return cloned;
    };

    public static void main(String[] args) throws CloneNotSupportedException {
        Address addr = new Address("西安", "雁塔区丈八东路");
        Person stan = new Person("stan", 15, addr);
        stan.setAge(18);

        Person clone = (Person) stan.clone();
        String name1 = clone.name;

        System.out.println(clone.name);

        System.out.println("Original: " + stan);
        System.out.println("Cloned: " + clone);

        //clone 是深拷贝 set修改对象的值 不会影响原来的对象
        clone.setName("Jane");
        clone.setAge(25);
        clone.getAddress().setCity("Los Angeles");
        clone.getAddress().setStreet("Sunset Blvd");

        System.out.println("After modification 修改之后的:");
        System.out.println("Original: " + stan);
        System.out.println("Cloned: " + clone);

    }

}


