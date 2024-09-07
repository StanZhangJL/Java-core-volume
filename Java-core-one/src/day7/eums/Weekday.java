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
    }
}
