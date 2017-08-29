package chapter4;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

/**
 * Created by zhangyue-k on 2017/8/27.
 * User:zhangyue-k
 * Date:2017/8/27
 */
//用锁存器辅助初始化
//例子意思：同一进程内的一组更新处理线程至少必须有一半线程正确初始化之后，才能开始接收系统发送给他们中的任何一个线程的更新
public class Processing {
    public static class ProcessingThread extends Thread{
        private final String ident;
        private final CountDownLatch latch;

        public ProcessingThread(String ident, CountDownLatch latch) {
            this.ident = ident;
            this.latch = latch;
        }

        public String getIdent() {
            return ident;
        }

        public CountDownLatch getLatch() {
            return latch;
        }
        //节点初始化
        public void initialize(){
            latch.countDown();
        }
        public void run(){
            initialize();
        }
    }

    public static void main(String[] args) {
        final int MAX_THREAD = 10;
        final int quorum = 1 + (MAX_THREAD / 2);
        final CountDownLatch cdl = new CountDownLatch(quorum);
        final Set<ProcessingThread> nodes = new HashSet<>();
        try {

        for(int i = 0;i < MAX_THREAD;i++){
            ProcessingThread local = new ProcessingThread("localhost:" + (9000 + i),cdl);
            nodes.add(local);
            local.start();
        }

            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {

        }
    }





}
