package chapter2;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by zhangyue-k on 2017/8/12.
 * User:zhangyue-k
 * Date:2017/8/12
 */
//将来式的异步IO
public class AsynchronousIOFeature {
    public static void main(String[] args) {
        try{
            Path file = Paths.get("D:\\project-git\\WellGroundedJavaDeveloper\\src\\main\\resources\\foobar.txt");

            AsynchronousFileChannel channel = AsynchronousFileChannel.open(file);
            ByteBuffer buffer = ByteBuffer.allocate(100_100);
            Future<Integer> result = channel.read(buffer,0);
            while(!result.isDone()){
                System.out.println("do other thing");
            }
            Integer byteRead = result.get();
            System.out.println("Bytes read[" + byteRead + "]");
        }catch (IOException | ExecutionException | InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
}
