package chapter3;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by zhangyue-k on 2017/8/26.
 * User:zhangyue-k
 * Date:2017/8/26
 */
//Guice的绑定方式-注解绑定
public class HollywoodServiceWithName {
    private AgentFinder finder = null;

    @Inject
    public HollywoodServiceWithName(@Named("primary") AgentFinder finder) {
        this.finder = finder;
    }

    public HollywoodServiceWithName() {
    }

    public static void main(String[] args) {
        HollywoodServiceWithName hollywoodServiceWithName = new HollywoodServiceWithName();
        System.out.println(hollywoodServiceWithName.finder);
    }
}
