package chapter4;

/**
 * Created by zhangyue-k on 2017/9/7.
 */
public class Dog extends Pet {
    public Dog(String name) {
        super(name);
    }

    public void examine() {
        System.out.println("Woof!");
    }
}
