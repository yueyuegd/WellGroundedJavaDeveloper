package chapter3;

import sun.net.www.MessageHeader;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by zhangyue-k on 2017/8/25.
 * User:zhangyue-k
 * Date:2017/8/25
 */
public class SingletonEx {

    //显式声明一个实例为单例模式
    @Inject
    @Singleton
    MessageHeader defaultHeader;
}
