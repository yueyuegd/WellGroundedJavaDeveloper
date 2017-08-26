package chapter3;

import java.util.List;

/**
 * Created by zhangyue-k on 2017/8/23.
 * User:zhangyue-k
 * Date:2017/8/23
 */
//由工厂负责提供AgentFinder
public class HollywoodServiceWithFactory {

    public List<Agent> getFriendlyAgents(String agentFinderType){
        AgentFinderFactory factory = AgentFinderFactory.getInstance();
        AgentFinder finder = factory.getAgentFinder(agentFinderType);
        List<Agent> agents = finder.findAllAgents();
        List<Agent> friendlyAgents = filterAgents(agents,"Java Developers");
        return friendlyAgents;
    }

    public static List<Agent> filterAgents(List<Agent> agents,String agentType){
        return null;
    }
}
