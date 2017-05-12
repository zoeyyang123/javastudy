package tutorial1;

/**
 * Created by zhaoyi on 17-5-12.
 */
public class Dog extends Animal {
    Dog(String name) {
        super(name);
    }

    @Override
    public void say() {
        System.out.println("我是一个狗子！");
    }

    public void f2(){
        System.out.println("汪汪汪。。。");
    }

}
