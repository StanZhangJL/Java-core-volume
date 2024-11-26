package day7.eums;

public enum SendCode {
    SUCCESS("请求成功",200),
    ERRO("请求失败",400),
    FLID("内部错误",500);

    private String desction;
    private int code;

    SendCode(String desction, int code){
        this.desction = desction;
        this.code = code;
    }

    public String getDesction() {
        return desction;
    }

    public int getCode() {
        return code;
    }

    public static void main(String[] args) {
        SendCode success = SendCode.SUCCESS;
        System.out.println(success.getCode());
        System.out.println(success.getDesction());

        //valueOf返回给定类中有指定名字的枚举常量
        SendCode success1 = Enum.valueOf(SendCode.class, "SUCCESS");

        //values()返回包含全部枚举值的数组
        SendCode[] values = SendCode.values();
        for (SendCode value : values) {
            System.out.println(value);

        }


    }
}
