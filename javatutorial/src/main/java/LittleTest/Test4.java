package LittleTest;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.HashMap;

/**
 * Test4 class
 *
 * @author zhaoyi
 * @date 17-11-23
 */
public class Test4 {
    public static void main(String[] args) {

        HashMap<String,String> map = new HashMap<String, String>();
        map.put("abc","wertyuip");
        int h;
        h = map.get("abc").hashCode();
        System.out.println(h);
        int mmm = (h) ^ (h >>> 16);
        System.out.println(mmm);
    }
}
