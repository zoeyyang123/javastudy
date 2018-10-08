package classLoad;

/**
 * ClassLoaderTest class
 * 类加载过程
 * @author zhaoyi
 * @date 18-9-13
 */
class Singleton {
    /**
     * 准备：
     *  singleton==>null
     *  count1==>0
     *  count2==>0
     * 初始化：
     *  singleton==> new Singleton(); count1==>1 count2==>1
     *  count1没有初始化的值 所以不变 仍为1
     *  count2初始化为0
     */
    private static Singleton singleton = new Singleton();
    public static int count1;
    public static int count2=0;
    /**
     * 这一行放在这里就不一样了
     */
    //private static Singleton singleton = new Singleton();
    private Singleton(){
        count1++;
        count2++;
    }
    public static Singleton getInstance(){
        return singleton;
    }
}
public class ClassLoaderTest{
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton.count1);
        System.out.println(singleton.count2);
    }
}
