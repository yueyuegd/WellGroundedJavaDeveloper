package chapter3;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

/**
 * Created by zhangyue-k on 2017/8/26.
 * User:zhangyue-k
 * Date:2017/8/26
 */
public class AgentFinderModuleWithName extends AbstractModule {
    @Override
    protected void configure() {
        bind(AgentFinder.class).annotatedWith(Names.named("primary"))
                .to(WebServiceAgentFinder.class);
    }
}
