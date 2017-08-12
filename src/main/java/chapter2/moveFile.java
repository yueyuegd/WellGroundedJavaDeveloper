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
public class moveFile {
    //下面的例子在移动源文件的时候要保留其属性并且覆盖目标文件(如果文件存在的话)
    public static void main(String[] args) throws IOException {
        Path source = Paths.get("D:\\project-git\\WellGroundedJavaDeveloper\\src\\main\\resources\\MyStuff.txt");
        Path target = Paths.get("D:\\project-git\\WellGroundedJavaDeveloper\\src\\main\\resources\\MyStuffCopy.txt");
        Files.move(source,target,REPLACE_EXISTING,ATOMIC_MOVE);

        //在上述方法中如果没有加上ATOMIC_MOVE的移动选项的话
        // 并且在使用该方法移动文件的时候发生异常的话原文件也会被删除
    }
}
