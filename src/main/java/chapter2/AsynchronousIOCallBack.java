package chapter2;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by zhangyue-k on 2017/8/21.
 * User:zhangyue-k
 * Date:2017/8/21
 */
//回调式的异步IO操作
public class AsynchronousIOCallBack {

    public static void main(String[] args) {
        try{

            Path file = Paths.get("D:\\project-git\\WellGroundedJavaDeveloper\\src\\main\\resources\\foobar.txt");
            AsynchronousFileChannel channel = AsynchronousFileChannel.open(file);
            ByteBuffer buffer = ByteBuffer.allocate(100_100);
            channel.read(buffer, 0,buffer, new CompletionHandler<Integer,ByteBuffer>() {

                @Override
                public void completed(Integer result, ByteBuffer attachment) {
                    System.out.println("Bytes read [" + result + "]");
                }

                @Override
                public void failed(Throwable exc, ByteBuffer attachment) {
                    System.out.println(exc.getMessage());

                }
            });

        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
