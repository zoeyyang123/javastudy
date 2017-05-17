package tutorial1;

/**
 * Created by zhaoyi on 17-5-12.
 */
public class Animal {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }



    Animal(String name) {
            this.name=name;
        }
    Animal() {
        super();
    }
    public Animal(String name,int age) {
            this.name=name;
            this.age=age;
        }
    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }

    public void say(){
        System.out.println("我是一个动物！");
    }
}
