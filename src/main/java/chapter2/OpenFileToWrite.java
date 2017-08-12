package chapter2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by zhangyue-k on 2017/8/12.
 * User:zhangyue-k
 * Date:2017/8/12
 */
//打开一个文件并写入数据
public class OpenFileToWrite {
    public static void main(String[] args) {
        Path logFile = Paths.get("D:\\project-git\\WellGroundedJavaDeveloper\\src\\main\\resources\\app1.log");
        try(BufferedWriter writer = Files.newBufferedWriter(logFile, StandardCharsets.UTF_8)){

            writer.write("Hello wjk!!!");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
