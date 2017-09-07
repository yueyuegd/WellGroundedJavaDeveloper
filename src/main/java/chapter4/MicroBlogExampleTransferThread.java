package chapter4;

import java.util.concurrent.*;

/**
 * Created by zhangyue-k on 2017/9/7.
 */
/*   用TransferQueue代替BlockingQueue   */
public abstract class MicroBlogExampleTransferThread extends Thread{

    protected final TransferQueue<Update> updates;
    protected String text = "";
    protected final int pauseTime;
    private boolean shutdown = false;

    public MicroBlogExampleTransferThread(TransferQueue<Update> updates, int pauseTime) {
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
        final LinkedTransferQueue<Update> lbq = new LinkedTransferQueue<Update>();
        MicroBlogExampleTransferThread t1 = new MicroBlogExampleTransferThread(lbq,10) {
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

        MicroBlogExampleTransferThread t2 = new MicroBlogExampleTransferThread(lbq,1000) {
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
