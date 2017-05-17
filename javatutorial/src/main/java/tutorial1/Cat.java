package tutorial1;

/**
 * Created by zhaoyi on 17-5-12.
 */
public class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void say() {
        System.out.println("我是一个嘟嘟！");
    }

    public void f1(){
        System.out.println("喵喵喵。。。");
    }
}
