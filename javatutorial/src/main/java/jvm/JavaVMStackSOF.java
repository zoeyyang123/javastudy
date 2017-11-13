package jvm;

/**
 *  -Xss128k (书上如此写) 但是JDK1.7之后此值最小为228k
 * 虚拟机栈和本地方法栈OOM测试1
 * Created by zhaoyi on 17-11-9.
 */
public class JavaVMStackSOF {
    private int stackLength = 1;
    public void stackLeak(){
        stackLength++;
        stackLeak();
    }
    public static void main(String[] args) throws Throwable{
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try{
            oom.stackLeak();
        }catch(Throwable e){
            System.out.println("stack length:"+oom.stackLength);
            throw e;
        }
    }
}
