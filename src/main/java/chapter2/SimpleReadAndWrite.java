package chapter2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by zhangyue-k on 2017/8/12.
 * User:zhangyue-k
 * Date:2017/8/12
 */
//简化读取和写入操作
public class SimpleReadAndWrite {

    public static void main(String[] args) throws IOException {
        Path logFile = Paths.get("D:\\project-git\\WellGroundedJavaDeveloper\\src\\main\\resources\\app.log");
        List<String> lines = Files.readAllLines(logFile, StandardCharsets.UTF_8);
        System.out.println(lines);
        byte[] bytes = Files.readAllBytes(logFile);
        System.out.println(bytes);
    }
}
