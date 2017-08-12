package chapter2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.*;

/**
 * Created by zhangyue-k on 2017/8/12.
 * User:zhangyue-k
 * Date:2017/8/12
 */
//文件的复制和移动
public class copyAndmove {
    public static void main(String[] args) throws IOException {
        Path source = Paths.get("D:\\project-git\\WellGroundedJavaDeveloper\\src\\main\\resources\\MyStuff.txt");
        Path target = Paths.get("D:\\project-git\\WellGroundedJavaDeveloper\\src\\main\\resources\\MyStuffCopy.txt");
        Files.copy(source,target);
        //在复制的时候可以设置某些选项  下面用到了覆盖
        // 如果target所指向的文件存在的话用上述(Files.copy(source,target))
        // 的复制方法会抛出文件已经存在的异常
        //Files.copy(source,target,REPLACE_EXISTING);
    }
}
