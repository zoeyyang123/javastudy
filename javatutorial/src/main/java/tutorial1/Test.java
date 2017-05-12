package tutorial1;

/**
 * Created by zhaoyi on 17-5-12.
 */
public class Test {
    public static void doSomeThing(Animal animal){

        animal.say();
        if(animal instanceof Dog){
            ((Dog) animal).f2();
        }else if(animal instanceof Cat){
            ((Cat) animal).f1();
        }else {
            System.out.println("啥也不是");
        }
    }
    public static void main(String[] args) {
        /*Animal dog = new Dog();
        dog.say();
        System.out.println("dog 是不是 属于animal："+(dog instanceof Animal));
        dog = new Cat();
        dog.say();*/
        doSomeThing(new Cat());
        doSomeThing(new Dog());
    }
}
