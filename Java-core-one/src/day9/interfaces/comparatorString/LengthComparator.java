package day9.interfaces.comparatorString;

import java.util.Comparator;

public class LengthComparator implements Comparator<String>,Comparable,Cloneable {
    @Override
    public int compare(String first, String second) {
        return first.length() - second.length();
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
