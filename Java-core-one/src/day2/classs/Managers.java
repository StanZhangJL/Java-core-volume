package day2.classs;

public class Managers extends Emp{
    
    public double bonus;

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public Managers(String name, int age, double salary, double bonus) {
        super(name, age, salary);
        this.bonus = bonus;
    }

    /**
     * @wanging  这里调用getSalary()是错误的 只会调用当前自身的getSalary方法，
     *  这样就会无限次数调用中级，最终导致程序崩溃.我们需要调用的是父类的方法
     *  为了解决这个问题我们需要调用父类的方法 使用关键字super
     * @return
     */
//    public double getSalary(){
//        double v = bonus + getSalary(); //错误写个
//        return v;
//    }

    public double getSalary(){
        double v = bonus + super.getSalary();
        return v;
    }

    @Override
    public String toString() {
        return "Managers{" +
                "bonus=" + bonus +
                '}';
    }

    public boolean equals(Object otherObject){
        //如果这两个对象不相等就直接返回 flase ，后面逻辑将不执行
        if (!super.equals(otherObject)) {
            return false;
        }
        Managers other = (Managers) otherObject;
        return  bonus == other.bonus;
    }

    public static void main(String[] args) {
        var boss = new Managers("Stan", 20, 4000, 1300);
        var boss1 = new Managers("Stan", 20, 4000, 1300);
        var emps = new Emp[3];
        emps[0] = boss;
        emps[1] = new Emp("wangnan", 12, 5988);
        emps[2] = new Emp("amos", 11, 897);

        for (Emp emp : emps) {
            System.out.println(emp.toString());
        }

        //flase
        boolean equals = boss.equals(emps[1]);

        //flase
        boolean equals1 = boss.equals(boss1);

        System.out.println(equals);
        System.out.println(equals1);
        Object object = new String("");


    }


}
