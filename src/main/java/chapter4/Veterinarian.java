package chapter4;

import java.util.concurrent.BlockingQueue;

/**
 * Created by zhangyue-k on 2017/9/7.
 */
/*   对兽医建模   */
public class Veterinarian extends Thread {

    protected final BlockingQueue<Appointment<Pet>> appts;

    protected String text = "";
    protected final int restTime;
    private boolean shutdown = false;

    public Veterinarian(BlockingQueue<Appointment<Pet>> appts, int restTime) {
        this.appts = appts;
        this.restTime = restTime;
    }

    public synchronized void shutdown(){
        shutdown = true;
    }
    public void run(){
        while(!shutdown){
            seePatient();
            try{
                Thread.sleep(restTime);
            }catch(InterruptedException e){
                shutdown = true;
            }
        }
    }

    public void seePatient(){
        try{
            Appointment<Pet> ap = appts.take();
            Pet patient = ap.getPatient();
            patient.examine();
        }catch (InterruptedException e){
            shutdown = true;
        }
    }
}
