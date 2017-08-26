package chapter3;

import com.google.inject.Guice;
import com.google.inject.Injector;

import java.util.List;

/**
 * Created by zhangyue-k on 2017/8/25.
 * User:zhangyue-k
 * Date:2017/8/25
 */
//用Guice构建对象关系图
public class HollywoodServiceClient {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new AgentFinderModule());
        HollywoodServiceGuice hollywoodServiceGuice =
                injector.getInstance(HollywoodServiceGuice.class);
        List<Agent> agents = hollywoodServiceGuice.getFriendlyAgents();
        
    }
}
