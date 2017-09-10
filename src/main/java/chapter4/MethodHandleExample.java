package chapter4;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * Created by zhangyue-k on 2017/9/10.
 */
//查找方法句柄
public class MethodHandleExample {

    public MethodHandle getToStringMH(){
        MethodHandle mh;
        MethodType mt = MethodType.methodType(String.class);
        MethodHandles.Lookup lk = MethodHandles.lookup();

        try{
            mh = lk.findVirtual(getClass(),"toString",mt);
        }catch (NoSuchMethodException | IllegalAccessException mhk){
            throw (AssertionError)new AssertionError().initCause(mhk);
        }
        return mh;
    }

    public static void main(String[] args) {
        MethodHandleExample handle = new MethodHandleExample();
        handle.getToStringMH();
    }
}
