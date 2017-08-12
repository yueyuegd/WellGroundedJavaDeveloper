package chapter2;

import java.io.File;
import java.nio.file.Path;

/**
 * Created by zhangyue-k on 2017/8/10.
 * User:zhangyue-k
 * Date:2017/8/10
 */
public class PathToFile {

    //java.io.File中增加了toPath()方法可以马上将已有的File转化为新的Path
    //Path类中有一个方法可以将Path转化为File，就是toFile()
    File file = new File("../Listing_2_1.java");
    Path listing = file.toPath();
}
