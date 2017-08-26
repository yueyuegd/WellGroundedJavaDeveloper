package chapter3;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangyue-k on 2017/8/25.
 * User:zhangyue-k
 * Date:2017/8/25
 */
public class HollywoodServiceGuice {

    private AgentFinder finder = null;

    @Inject
    public HollywoodServiceGuice(AgentFinder finder) {
        this.finder = finder;
    }

    public List<Agent> getFriendlyAgents(){
        List<Agent> agents = finder.findAllAgents();
        List<Agent> friendlyAgents = filterAgents(agents,"Java Developers");
        return friendlyAgents;
    }

    public List<Agent> filterAgents(List<Agent> agents,String AgentType){
        List<Agent> filteredAgents = new ArrayList<Agent>();
        for(Agent agent:agents){
            if(agent.getType().equals(AgentType)){
                filteredAgents.add(agent);
            }
        }
        return filteredAgents;
    }
}
