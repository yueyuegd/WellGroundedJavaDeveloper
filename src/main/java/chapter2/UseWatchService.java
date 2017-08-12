package chapter2;

import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.*;

/**
 * Created by zhangyue-k on 2017/8/12.
 * User:zhangyue-k
 * Date:2017/8/12
 */
//使用WatchService来检测文件的改变
public class UseWatchService {
    public static void main(String[] args) {

        try{

            WatchService watchService = FileSystems.getDefault().newWatchService();
            Path dir = FileSystems.getDefault().getPath("D:\\project-git\\WellGroundedJavaDeveloper\\src\\main\\resources\\app.log");
            WatchKey key = dir.register(watchService,ENTRY_MODIFY);
            boolean shutdown = false;
            while(!shutdown){
               key = watchService.take();
                for(WatchEvent<?> event:key.pollEvents()){
                    if(event.kind() == ENTRY_MODIFY){
                        System.out.println("Home Dir changed!");
                    }
                }
                key.reset();
            }
        }catch (IOException | InterruptedException e){
            System.out.println(e.getMessage());
        }

    }
}
