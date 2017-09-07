package chapter4;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhangyue-k on 2017/8/29.
 * User:zhangyue-k
 * Date:2017/8/29
 */
//对于CopyOnWriteArrayList的使用   假设有一个微博的时间线更新   下面的代码表示每个用户时间线视图的持有者类
public class MicroBlogTimeLine {

    private static CopyOnWriteArrayList<Update> updates;
    private static ReentrantLock lock;
    private final String name;
    private Iterator<Update> it;

    public MicroBlogTimeLine(CopyOnWriteArrayList<Update> updates, ReentrantLock lock, String name) {
        this.updates = updates;
        this.lock = lock;
        this.name = name;
    }

    public void addUpdate(Update update){
        updates.add(update);
    }

    public void prep(){
        it = updates.iterator();
    }

    public void printTimeLine(){
        lock.lock();
        try{
            if(it != null){
                System.out.println(name + ": ");
                while(it.hasNext()){
                    Update s = it.next();
                    System.out.println(s + ", ");
                }
                System.out.println();
            }
        }finally {
            lock.unlock();
        }
    }

}
