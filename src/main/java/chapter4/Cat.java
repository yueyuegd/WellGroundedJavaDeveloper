package chapter4;

/**
 * Created by zhangyue-k on 2017/9/7.
 */
public class Cat extends Pet {

    public Cat(String name) {
        super(name);
    }

    public void examine() {
        System.out.println("Meow!");
    }
}
