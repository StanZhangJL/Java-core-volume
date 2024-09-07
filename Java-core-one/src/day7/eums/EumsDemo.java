package day7.eums;

public enum EumsDemo {
    SPRING("Spring is warm"),
    SUMMER("Summer is hot"),
    AUTUMN("Autumn is cool"),
    WINTER("Winter is cold");
    private final String des;
    EumsDemo(String des){
        this.des = des;
    }

    public String getDes() {
        return des;
    }

    public static void main(String[] args) {
        EumsDemo spring = EumsDemo.SPRING;
        System.out.println(spring + " " + spring.getDes());

    }


}
