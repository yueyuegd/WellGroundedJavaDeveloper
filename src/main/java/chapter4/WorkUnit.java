package chapter4;

/**
 * Created by zhangyue-k on 2017/9/8.
 */
public class WorkUnit<T> {
    private final T work;

    public WorkUnit(T work) {
        this.work = work;
    }

    public T getWork(){
        return work;
    }
}
