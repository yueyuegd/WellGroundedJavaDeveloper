package chapter4;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhangyue-k on 2017/8/29.
 * User:zhangyue-k
 * Date:2017/8/29
 */
//下面揭示了写时复制行为
public class UseCopyOnWriteArrayList {

    final static CountDownLatch firstLatch = new CountDownLatch(1);
    final static CountDownLatch secondLatch = new CountDownLatch(1);
    final static Update.Builder ub = new Update.Builder();

    final static List<Update> updates = new CopyOnWriteArrayList<>();

    public UseCopyOnWriteArrayList() {
        updates.add(ub.author(new Author("Ben")).updateText("I Like Pie").build());
        updates.add(ub.author(new Author("Charles")).updateText("I Like ham on rye").build());
    }

    final static ReentrantLock lock = new ReentrantLock();
    final static MicroBlogTimeLine tl1 = new MicroBlogTimeLine((CopyOnWriteArrayList<Update>) updates,lock,"TL1");
    final static MicroBlogTimeLine tl2 = new MicroBlogTimeLine((CopyOnWriteArrayList<Update>) updates,lock,"TL2");



    public static void main(String[] args) {
        updates.add(ub.author(new Author("Ben")).updateText("I Like Pie").build());
        updates.add(ub.author(new Author("Charles")).updateText("I Like ham on rye").build());

        Thread t1 =  new Thread(){
           public void run(){
               updates.add(ub.author(new Author("Jeffrey")).updateText("I Like a Lot of things").build());
               tl1.prep();
               firstLatch.countDown();
               try{
                   secondLatch.await();
               }catch (InterruptedException e){

               }
               tl1.printTimeLine();
           }
        };

        Thread t2 = new Thread(){
             public void run(){
                try{
                    firstLatch.await();
                    updates.add(ub.author(new Author("Gavin")).updateText("I Like otters").build());
                    tl2.prep();
                    secondLatch.countDown();
                }catch (InterruptedException e){

                }
                 tl2.printTimeLine();
             }
        };

        t1.start();
        t2.start();
    }





}
