package chapter2;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by zhangyue-k on 2017/8/9.
 * User:zhangyue-k
 * Date:2017/8/9
 */
public class paths {


    public static void mkain(String[] args) {
        Path listing = Paths.get("/user/bin/zip");
        System.out.println(listing);
        Path listing1 = FileSystems.getDefault().getPath("/user/bin/zip");
        System.out.println(listing1.toAbsolutePath());
    }
}
