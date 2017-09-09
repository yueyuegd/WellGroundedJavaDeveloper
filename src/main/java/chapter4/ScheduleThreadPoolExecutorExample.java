package chapter4;

import java.util.concurrent.*;

/**
 * Created by zhangyue-k on 2017/9/8.
 */
/*   STPE定期读取的例子   */
public class ScheduleThreadPoolExecutorExample {

    private ScheduledExecutorService stpe;
    private ScheduledFuture<?> hndl;

    private BlockingQueue<WorkUnit<String>> lbq = new LinkedBlockingQueue<>();

    private void run(){
        stpe = Executors.newScheduledThreadPool(2);
        final Runnable msgReader = new Runnable() {
            @Override
            public void run() {
                String nextMsg = lbq.poll().getWork();
                if(nextMsg != null){
                    System.out.println("Msg recvd:" + nextMsg);
                }
            }
        };
        hndl = stpe.scheduleAtFixedRate(msgReader,10,10,TimeUnit.MILLISECONDS);

    }

    public void cancel(){
        final ScheduledFuture<?> myHndl = hndl;
        stpe.schedule(new Runnable() {
            @Override
            public void run() {
              myHndl.cancel(true);
            }
        },10,TimeUnit.MILLISECONDS);
    }

    public static void main(String[] args) {


    }
}
