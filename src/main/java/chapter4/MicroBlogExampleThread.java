package chapter4;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhangyue-k on 2017/9/7.
 */
/*   除了简单的take()和offer()方法，BlockingQueue还提供了一种与队列交互的方式
*    它允许线程在遇到问题的时候可以从与队列的交互中退出来，转而做其他事*/
public abstract class MicroBlogExampleThread extends Thread{

    protected final BlockingQueue<Update> updates;
    protected String text = "";
    protected final int pauseTime;
    private boolean shutdown = false;

    public MicroBlogExampleThread(BlockingQueue<Update> updates, int pauseTime) {
        this.updates = updates;
        this.pauseTime = pauseTime;
    }

    public synchronized void shutdown(){
        shutdown = true;
    }

    public void run(){
        while(!shutdown){
            doAction();
            try{
                Thread.sleep(pauseTime);
            }catch (InterruptedException e){
                shutdown = true;
            }
        }
    }
    public abstract void doAction();

    public static void main(String[] args) {

        final Update.Builder ub = new Update.Builder();
        final BlockingQueue<Update> lbq = new LinkedBlockingQueue<>(100);
        MicroBlogExampleThread t1 = new MicroBlogExampleThread(lbq,10) {
            @Override
            public void doAction() {
                text = text + "X";
                Update u = ub.author(new Author("Tallilah")).updateText(text).build();
                boolean handed = false;
                try{
                    handed = updates.offer(u,100, TimeUnit.MILLISECONDS);
                }catch (InterruptedException e){

                }
                if(!handed) System.out.println("Unable to hand off Update to Queue due to timeout");
            }
        };

        MicroBlogExampleThread t2 = new MicroBlogExampleThread(lbq,1000) {
            @Override
            public void doAction() {
                Update u = null;
                try{
                    u = updates.take();
                }catch (InterruptedException e){
                    return;
                }
            }
        };

        t1.start();
        t2.start();
    }
}


