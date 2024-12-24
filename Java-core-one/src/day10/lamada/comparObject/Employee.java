package day10.lamada.comparObject;

/**
 * 1.不同子类对象比较的规则：
 * 如果两个对象属于不同的子类，那么这些对象之间的比较应该被视为非法。为此，可以通过检查它们的运行时类型来确保合法性。
 * 通过 getClass() 方法检查，如果两个对象的类型不同，就抛出 ClassCastException。
 * 示例检查代码：
 * if (this.getClass() != other.getClass()) {
 *     throw new ClassCastException("Cannot compare objects of different types");
 *  }
 *
 *
 * 2.通用比较算法：
 * 如果需要实现一个通用的比较逻辑（适用于所有子类），可以在超类中定义一个 compareTo 方法，并声明为 final，防止子类覆盖。
 * 对于需要比较的具体属性，可以在超类中定义一个抽象方法（例如 rank），让每个子类提供自己的实现。
 * 示例场景：
 *
 * 假设有一个 Employee 类，以及它的子类 Manager、Secretary 等。如果我们想根据通用的“职级（rank）”来比较这些对象，
 * 可以在 Employee 类中定义 rank 方法，由子类实现其逻辑。
 */



// 超类 Employee，声明为 Comparable
public abstract  class Employee implements  Comparable<Employee> {
    // 提供一个抽象方法 rank，让子类实现
    public abstract int rank();
    @Override
    public final int compareTo(Employee other) {
        // 检查类型是否相同
        if (this.getClass() != other.getClass()) {
            throw new ClassCastException("Cannot compare objects of different types");
        }
        // 按照 rank 值进行比较
        return Integer.compare(this.rank(), other.rank());
    }
}
// 子类 Manager
class Manager extends Employee {
    private int salary;

    public Manager(int salary) {
        this.salary = salary;
    }

    @Override
    public int rank() {
        // 根据工资来计算 rank
        return salary;
    }
}

// 子类 Secretary
class Secretary extends Employee {
    private int yearsOfExperience;

    public Secretary(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public int rank() {
        // 根据工作经验年数来计算 rank
        return yearsOfExperience;
    }
}


