package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaoyi on 17-11-13.
 * VM Args： -XX:PermSize=10M -XX:MaxPermSize=10M
 * java8取消上述两种参数改为 MetaspaceSize
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        // 使用 List 保持着常量池引用，避免 Full GC 回收常量池行为
        List<String> list = new ArrayList<String>();
        // 10MB 的 PermSize 在 integer 范围内足够产生 OOM 了
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }

        /*String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);*/
    }
}