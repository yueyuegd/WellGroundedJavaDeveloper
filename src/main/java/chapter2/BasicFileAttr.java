package chapter2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by zhangyue-k on 2017/8/12.
 * User:zhangyue-k
 * Date:2017/8/12
 */
//下面的例子用于讲述对于大多数文件系统来说相同的文件属性，比如说文件最后被修改的时间 文件有多大等等
public class BasicFileAttr {

    public static void main(String[] args) {
        try {
            Path txt = Paths.get("D:\\project-git\\WellGroundedJavaDeveloper\\src\\main\\resources\\applicationContext.properties");
            System.out.println(Files.getLastModifiedTime(txt));
            System.out.println(Files.size(txt));
            System.out.println(Files.isSymbolicLink(txt));
            System.out.println(Files.isDirectory(txt));
            System.out.println(Files.readAttributes(txt, "*"));
        }catch(IOException e){
            System.out.println("Exception[" + e.getMessage() + "]");
        }
    }
}
