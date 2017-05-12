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
        }else if (animal instanceof Pig){
            ((Pig) animal).f3();
        }
    }
    public static void main(String[] args) {
        /*Animal dog = new Dog();
        dog.say();
        System.out.println("dog 是不是 属于animal："+(dog instanceof Animal));
        dog = new Cat();
        dog.say();*/
        doSomeThing(new Cat("糯米",3));
        doSomeThing(new Dog("nunu"));
        doSomeThing(new Pig());

        System.out.println(new Cat("dudu",2));
        //Animal al = new Animal("");
    }
}
