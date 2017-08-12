package chapter2;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by zhangyue-k on 2017/8/10.
 * User:zhangyue-k
 * Date:2017/8/10
 */
public class Find {

    //列出子目录下的所有Java源码文件

    public static void main(String[] args) throws IOException{
        //startingDir指定了搜寻的起始目录
        Path startingDir = Paths.get("D:\\project-git\\WellGroundedJavaDeveloper\\src");

        Files.walkFileTree(startingDir,new FindJavaVisitor());

    }

    private static class FindJavaVisitor extends SimpleFileVisitor<Path>{
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs){
            if(file.toString().endsWith(".java")){
                System.out.println(file.getFileName());
            }
            return FileVisitResult.CONTINUE;

        }
    }
}
