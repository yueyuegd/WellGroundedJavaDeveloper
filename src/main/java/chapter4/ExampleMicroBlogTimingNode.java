package chapter4;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by zhangyue-k on 2017/8/29.
 * User:zhangyue-k
 * Date:2017/8/29
 */
//使用ConcurrentHashMap来代替HashMap实现并发
public class ExampleMicroBlogTimingNode implements SimpleMicroBlogNode {

    private final Map<Update,Long> arrivalTime =
            new ConcurrentHashMap<>();


    public void propagateUpdate(Update update){
        arrivalTime.putIfAbsent(update,System.currentTimeMillis());
    }

    public boolean confirmUpdateReceived(Update update){
        return arrivalTime.get(update) != null;
    }
}
