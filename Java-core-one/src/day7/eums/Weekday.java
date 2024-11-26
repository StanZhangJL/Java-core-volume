package day7.eums;

public enum Weekday {
    MONDAY, // 枚举常量MONDAY
    TUESDAY, // 枚举常量TUESDAY
    WEDNESDAY, // 枚举常量WEDNESDAY
    THURSDAY, // 枚举常量THURSDAY
    FRIDAY, // 枚举常量FRIDAY
    SATURDAY, // 枚举常量SATURDAY
    SUNDAY; // 枚举常量SUNDAY

    // 可以在枚举类型中定义方法
    public String getFullName() {
        switch (this) {
            case MONDAY: return "Monday";
            case TUESDAY: return "Tuesday";
            case WEDNESDAY: return "Wednesday";
            case THURSDAY: return "Thursday";
            case FRIDAY: return "Friday";
            case SATURDAY: return "Saturday";
            case SUNDAY: return "Sunday";
            default: throw new IllegalStateException("Unexpected value: " + this);
        }
    }

    public static void main(String[] args) {
        Weekday monday = WEDNESDAY.MONDAY;

        System.out.println(monday);
        System.out.println(monday.getFullName());

        // 返回给定类中，有指定名字的枚举常量
        Weekday monday1 = Enum.valueOf(Weekday.class, "MONDAY");
        System.out.println(monday1);

        System.out.println(" Weekday.values返回的是一个数组=======================");
        Weekday[] values = Weekday.values();
        for (Weekday value : values) {
            System.out.println(value);
        }

        // 返回枚举常量在enum声明中的位置,从0开始计算位置
        int ordinal = Weekday.MONDAY.ordinal();
        System.out.println(ordinal);

        // 如果位置相等返回0
        int i = Weekday.MONDAY.compareTo(Weekday.values()[ordinal]);
        System.out.println(i);

        // 如果Weekday.MONDAY出现在 Weekday.THURSDAY 前面返回一个负数(-3)，否则返回正数
        // 次序按照枚举中定义的，枚举常量的出现次序在enum声明中给出
        int t = Weekday.MONDAY.compareTo(Weekday.THURSDAY);
        System.out.println(t);

        // 否则返回正数(3)
        int m = Weekday.THURSDAY.compareTo(Weekday.MONDAY);
        System.out.println(m);



    }
}
