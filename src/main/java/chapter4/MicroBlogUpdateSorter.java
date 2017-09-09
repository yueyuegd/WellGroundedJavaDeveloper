package chapter4;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

/**
 * Created by zhangyue-k on 2017/9/9.
 */
//使用RecursiveAction排序：一个简单的分支/合并的例子
    //例子的应用场景：有一个数组，里面存放不同时间到达的微博更新
public class MicroBlogUpdateSorter extends RecursiveAction{
    private static final int SMALL_ENOUGH = 32;
    private final Update[] updates;
    private final int start,end;
    private final Update[] result;

    public MicroBlogUpdateSorter(Update[] updates, int start, int end) {
        this.updates = updates;
        this.start = start;
        this.end = end;
        this.result = new Update[updates.length];
    }

    public MicroBlogUpdateSorter(Update[] updates) {
        this(updates,0,updates.length);
    }

    private void merge(MicroBlogUpdateSorter left,MicroBlogUpdateSorter right){
        int i =0;
        int lCt = 0;
        int rCt = 0;
        while(lCt < left.size() && rCt < right.size()){
            result[i++] = (left.result[lCt].compareTo(right.result[rCt]) < 0)?left.result[lCt]:right.result[rCt];
        }

        while (lCt < left.size()) result[i++] = left.result[lCt++];
        while (rCt < right.size()) result[i++] = right.result[rCt++];
    }

    public int size(){
        return end - start;
    }

    public Update[] getResult(){
        return result;
    }

    @Override
    protected void compute() {

        if(size() < SMALL_ENOUGH){
            System.arraycopy(updates,start,result,0,size());
            Arrays.sort(result,0,size());
        }else{
            int mid = size() / 2;
            MicroBlogUpdateSorter left =
                    new MicroBlogUpdateSorter(updates,
                            start,start + mid);
            MicroBlogUpdateSorter right =
                    new MicroBlogUpdateSorter(updates,
                            start + mid,end);
            invokeAll(left,right);
            merge(left,right);
        }
    }
}
