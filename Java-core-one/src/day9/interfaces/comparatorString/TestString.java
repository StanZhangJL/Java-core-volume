package day9.interfaces.comparatorString;

import java.util.Arrays;

public class TestString {
    public static void main(String[] args) {

        //比较数组字符串
        String[] arrStr = {"PHP", "JAVA", "C++", "GO"};
        Arrays.sort(arrStr, new LengthComparator());
        for (String string : arrStr) {
            System.out.println(string);
        }
    }
}
