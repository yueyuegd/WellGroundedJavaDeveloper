package chapter4;

/**
 * Created by zhangyue-k on 2017/9/7.
 */
public class Appointment<T> {

    private final T toBeSeen;

    public T getPatient(){
        return toBeSeen;
    }

    public Appointment(T toBeSeen) {
        this.toBeSeen = toBeSeen;
    }
}
