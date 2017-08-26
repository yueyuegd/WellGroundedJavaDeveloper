package chapter3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangyue-k on 2017/8/23.
 * User:zhangyue-k
 * Date:2017/8/23
 */
//通过依赖注入的方式：纯手工注入AgentFinder
public class HollywoodServiceWithDIByHand {

    public static List<Agent> getFriendlyAgents(AgentFinder finder){
        List<Agent> agents = finder.findAllAgents();
        List<Agent> friendlyAgents = filterAgents(agents,"Java Developers");
        return friendlyAgents;
    }

    public static List<Agent> filterAgents(List<Agent> agents,String agentType){
        List<Agent> filteredAgents = new ArrayList<>();
        for(Agent agent:agents){
            if(agent.getType().equals(agentType)){
                filteredAgents.add(agent);
            }
        }
        return filteredAgents;
    }
}
