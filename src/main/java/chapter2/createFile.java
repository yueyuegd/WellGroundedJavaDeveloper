package chapter2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

/**
 * Created by zhangyue-k on 2017/8/10.
 * User:zhangyue-k
 * Date:2017/8/10
 */
public class createFile {

    public static void main(String[] args) throws IOException {
        //下面是一个在POSIX文件系统上为属主，属主组内用户和所有用户设置为读/写许可的例子
       /* Path target = Paths.get("D:\\project-git\\WellGroundedJavaDeveloper\\src\\main\\resources\\MyStuff.txt");
        System.out.println(PosixFilePermissions.fromString("rw-rw-rw-"));
        Set<PosixFilePermission> perms = PosixFilePermissions.fromString("rw-rw-rw-");
        FileAttribute<Set<PosixFilePermission>> attr = PosixFilePermissions.asFileAttribute(perms);
        Files.createFile(target,attr);*/

        //删除文件
        Path target = Paths.get("D:\\project-git\\WellGroundedJavaDeveloper\\src\\main\\resources\\MyStuff.txt");
        Files.delete(target);
    }
}
