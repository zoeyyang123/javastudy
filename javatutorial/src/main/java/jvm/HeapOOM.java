package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试堆内存溢出：设置jvm方法：菜单栏Run > Edit Configuration > VM option
 * Created by zhaoyi on 17-11-9.
 */
public class HeapOOM {
    static class OOMObject{

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true){
            list.add(new OOMObject());
        }
    }
}
