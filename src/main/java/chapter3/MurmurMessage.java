package chapter3;

import javax.inject.Inject;
import javax.inject.Provider;

/**
 * Created by zhangyue-k on 2017/8/23.
 * User:zhangyue-k
 * Date:2017/8/23
 */
//如果你想对注入的对象拥有更多的控制权   可以要求DI框架将Provider<T>接口实现注入到类中
public class MurmurMessage {

    @Inject
    public MurmurMessage(Provider<Message> messageProvider) {
        Message msgl = messageProvider.get();
    }
}
