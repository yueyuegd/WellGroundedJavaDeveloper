package chapter2;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by zhangyue-k on 2017/8/12.
 * User:zhangyue-k
 * Date:2017/8/12
 */
//下面代码展示了如何使用FilesChannel的寻址能力读取日志文件中最后1000个字符
public class UseSeekableByteChannel {
    public static void main(String[] args) throws IOException {
        Path logFile = Paths.get("D:\\project-git\\WellGroundedJavaDeveloper\\src\\main\\resources\\flexsupt.log");
        ByteBuffer buffer = ByteBuffer.allocate(6259);
        byte[] content = new byte[1000];
        FileChannel channel = FileChannel.open(logFile, StandardOpenOption.READ);
        System.out.println(channel.size());
        channel.read(buffer,channel.size() - 1000);
        buffer.get(content);
        System.out.println(new String(content));
    }
}
