package chapter3;

/**
 * Created by zhangyue-k on 2017/8/23.
 * User:zhangyue-k
 * Date:2017/8/23
 */
public class AgentFinderFactory {

    public static AgentFinderFactory getInstance(){
        return new AgentFinderFactory();
    }

    public AgentFinder getAgentFinder(String agentType){
        return null;
    }
}
