package chapter4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhangyue-k on 2017/8/26.
 * User:zhangyue-k
 * Date:2017/8/26
 */
//使用ReentrantLock重写死锁
public class UseReentrantLock {

    private final Lock lock = new ReentrantLock();
    private final String ident;

    public UseReentrantLock(String ident) {
        this.ident = ident;
    }

    public String getIdent() {
        return ident;
    }

    public void propagateUpdate(Update update, UseReentrantLock backup){
        lock.lock();
        try{
            System.out.println(ident + ":recvd:" + update.getUpdateText() + ";backup:" + backup.getIdent());
            backup.confirmUpdate(this,update);

        }finally {
            lock.unlock();
        }
    }

    public void confirmUpdate(UseReentrantLock other,Update update){
        lock.lock();
        try{
            System.out.println(ident + ": recvd confirm:" + update.getUpdateText() + " from " + other.getIdent());
        }finally {
            lock.unlock();
        }
    }
}
