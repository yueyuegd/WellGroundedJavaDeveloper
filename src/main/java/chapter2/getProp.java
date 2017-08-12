package chapter2;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by zhangyue-k on 2017/8/10.
 * User:zhangyue-k
 * Date:2017/8/10
 */
public class getProp {
    //在目录中查找文件   用模式匹配过滤出项目中所有的.properties文件

    //只针对单个目录的情况
    public static void main(String[] args) {

        //设定起始路径
        Path dir = Paths.get("D:\\project-git\\WellGroundedJavaDeveloper");
        try(DirectoryStream<Path> stream = Files.newDirectoryStream(dir,"*.properties")){
            for(Path entry:stream){
                System.out.println(entry.getFileName());
            }

        }catch(IOException e){
            System.out.println(e.getMessage());
        }


    }


}
