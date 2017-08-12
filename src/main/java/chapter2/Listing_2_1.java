package chapter2;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by zhangyue-k on 2017/8/9.
 * User:zhangyue-k
 * Date:2017/8/9
 */
public class Listing_2_1 {

    public static void main(String[] args) {
        Path listing = Paths.get("/user/bin/zip");
        //System.out.println("File Name[" + listing.getFileName() + "]");
        //System.out.println("Number of Name Elements in the Path[" + listing.getNameCount() + "]");
        //System.out.println("Parent Path[" + listing.getParent() + "]");
        //System.out.println("Root of Path[" + listing.getRoot() + "]");
        //System.out.println("Subpath from Root,2 elements deep[" + listing.subpath(0,2) + "]");

        //Path normalizedPath = Paths.get("./Listing_2_1.java").normalize();
        //System.out.println(normalizedPath);

        //toRealPath()方法融合了toAbsolutePath()和normalize()方法
        try {
            Path realPath = Paths.get("./src/main/chapter2/Listing_2_1.java").toRealPath();
            System.out.println(realPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
