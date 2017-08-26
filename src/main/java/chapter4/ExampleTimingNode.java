package chapter4;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangyue-k on 2017/8/26.
 * User:zhangyue-k
 * Date:2017/8/26
 */
//下面是完全同步类的实例
public class ExampleTimingNode implements SimpleMicroBlogNode {

    //没有公共域
    private final String identifier;
    private final Map<Update,Long> arrivalTime
            = new HashMap<>();

    //所以域在构造方法中初始化
    public ExampleTimingNode(String identifier) {
        this.identifier = identifier;
    }

    //所有方法都是同步的
    public synchronized String getIdentifier(){
        return identifier;
    }

    public synchronized void propagateUpdate(Update update){
        long currentTime = System.currentTimeMillis();
        arrivalTime.put(update,currentTime);

    }

    public synchronized boolean confirmUpdateReceived(Update update){
        Long timeRecvd = arrivalTime.get(update);
        return timeRecvd != null;
    }
}
