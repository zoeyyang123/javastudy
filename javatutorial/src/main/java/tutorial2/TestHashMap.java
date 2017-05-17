package tutorial2;

import tutorial1.Cat;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by zhaoyi on 17-5-12.
 */
public class TestHashMap {
    public static void main(String[] args) {
        HashMap<String, Cat> hm = new HashMap<String, Cat>();
        hm.put("第一只",new Cat("都督",1));
        hm.put("第二只",new Cat("糯米",2));
        hm.put("第三只",new Cat("年糕",3));

        Cat miao = hm.get("第二只");
        System.out.println(miao);
        Iterator<String> it = hm.keySet().iterator();
        while(it.hasNext()){
            String key = it.next();
            Cat maomi = hm.get(key);
            System.out.println("key="+key+maomi);
        }
    }

}