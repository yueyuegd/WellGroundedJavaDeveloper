package chapter3;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

/**
 * Created by zhangyue-k on 2017/8/26.
 * User:zhangyue-k
 * Date:2017/8/26
 */
public class AgentFinderModuleWithProvide extends AbstractModule {
    @Override
    protected void configure() {

    }

    @Provides
    AgentFinder provideAgentFinder(){
        SpreadsheetAgentFinder finder =
                new SpreadsheetAgentFinder();
        finder.setType("Excel 97");
        finder.setPath("c:/temp/agents.xls");
        return finder;
    }
}
