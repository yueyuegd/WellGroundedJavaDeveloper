package chapter3;

import com.google.inject.AbstractModule;

/**
 * Created by zhangyue-k on 2017/8/25.
 * User:zhangyue-k
 * Date:2017/8/25
 */
//创建一个用于定义绑定关系的AgentFinderModule，扩展了AbstractModule，绑定关系写在configure方法里
    //本例中，当@Inject一个AgentFinder的时候就会绑定到WebServiceAgentFinde类作为注入对象
public class AgentFinderModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(AgentFinder.class).to(WebServiceAgentFinder.class);
    }
}
