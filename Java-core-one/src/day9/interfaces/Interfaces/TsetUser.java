package day9.interfaces.Interfaces;

import java.util.List;

public class TsetUser implements UserA,UserB{
    //当两个接口中有同样 同名的方法时 需要显示调用解决冲突
    @Override
    public String getId() {
        return UserB.super.getId();
    }
}
