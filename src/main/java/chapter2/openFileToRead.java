package chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by zhangyue-k on 2017/8/12.
 * User:zhangyue-k
 * Date:2017/8/12
 */
//下面演示了Java7如何使用Files.newBufferedReader方法来打开文件并按行读取文件中的内容
public class openFileToRead {
    public static void main(String[] args) {
        Path logFile = Paths.get("D:\\project-git\\WellGroundedJavaDeveloper\\src\\main\\resources\\app.log");
        try(BufferedReader reader = Files.newBufferedReader(logFile, StandardCharsets.UTF_8)){

            String line;
            while((line=reader.readLine())!= null){
                System.out.println(line);
            }
        }catch(IOException e){

            e.printStackTrace();
        }
    }
}
