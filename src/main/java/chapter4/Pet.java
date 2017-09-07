package chapter4;

/**
 * Created by zhangyue-k on 2017/9/7.
 */
/*  一个BlockingQueue的例子：等着看医生的宠物们，这个例子中有一个等着让医生给做检查的宠物集合*/
public abstract class Pet {

    protected final String name;

    public Pet(String name) {
        this.name = name;
    }

    public abstract void examine();
}
