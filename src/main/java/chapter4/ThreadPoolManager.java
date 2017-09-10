package chapter4;


import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.*;

/**
 * Created by zhangyue-k on 2017/9/10.
 */
//反射，代理和方法句柄的使用
public class ThreadPoolManager {
    private final ScheduledExecutorService stpe =
            Executors.newScheduledThreadPool(2);
    private final BlockingQueue<WorkUnit<String>> lbq;

    public ThreadPoolManager() {
        this.lbq = null;
    }

    public ThreadPoolManager(BlockingQueue<WorkUnit<String>> lbq) {
        this.lbq = lbq;
    }

    public ScheduledFuture<?> run(QueueReaderTask msgReader){

        msgReader.setQueue(lbq);
        return stpe.scheduleAtFixedRate(msgReader,10,10, TimeUnit.MILLISECONDS);
    }

    private void cancel(final ScheduledFuture<?> hndl){
        stpe.schedule(new Runnable() {
            @Override
            public void run() {
                hndl.cancel(true);
            }
        },10,TimeUnit.MILLISECONDS);

    }

    public Method makeReflective(){
        Method meth = null;
        try{
            Class<?>[] argTypes = new Class[]{ScheduledFuture.class};
            meth = ThreadPoolManager.class.getDeclaredMethod("cancel",argTypes);
            meth.setAccessible(true);
        }catch (IllegalArgumentException | NoSuchMethodException | SecurityException e){
            e.printStackTrace();
        }
        return meth;
    }

    public static class CancelProxy{
        private CancelProxy(){

        }
        public void invoke(ThreadPoolManager manager, ScheduledFuture<?> hndl){
            manager.cancel(hndl);
        }
    }

    public CancelProxy makeProxy(){
        return new CancelProxy();
    }

    public MethodHandle makeMh(){
        MethodHandle mh;
        MethodType desc = MethodType.methodType(void.class,ScheduledFuture.class);
        try{
            mh = MethodHandles.lookup().findVirtual(com.sun.corba.se.spi.orbutil.threadpool.ThreadPoolManager.class,"cancel",desc);
        }catch (NoSuchMethodException | IllegalAccessException e){
            throw (AssertionError)new AssertionError().initCause(e);
        }
        return mh;
    }

    private void cancelUsingReflection(ScheduledFuture<?> hndl){
        ThreadPoolManager manager = new ThreadPoolManager();
        Method meth = manager.makeReflective();

        try{
            System.out.println("With Reflection");
            meth.invoke(hndl);
        }catch (InvocationTargetException | IllegalArgumentException | IllegalAccessException e){
            e.printStackTrace();
        }
    }

    private void cancelUsingProxy(ScheduledFuture<?> hndl){
        ThreadPoolManager manager = new ThreadPoolManager();
        CancelProxy proxy = manager.makeProxy();
        System.out.println("With Proxy");
        proxy.invoke(manager,hndl);

    }

    private void cancelUsingMH(ScheduledFuture<?> hndl){
        ThreadPoolManager manager = new ThreadPoolManager();
        MethodHandle mh = manager.makeMh();
        try{
            System.out.println("With Method Handle");
            mh.invokeExact(manager,hndl);
        }catch (Throwable throwable){
            throwable.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BlockingQueue<WorkUnit<String>> lbq =
                new LinkedBlockingQueue<>();
        ThreadPoolManager manager = new ThreadPoolManager(lbq);
        final QueueReaderTask msgReader = new QueueReaderTask(100) {
            @Override
            public void doAction(String msg) {
                if(msg != null){
                    System.out.println("Msg recvd:" + msg);
                }
            }
        };
        ScheduledFuture<?> hndl = manager.run(msgReader);
    }

}
