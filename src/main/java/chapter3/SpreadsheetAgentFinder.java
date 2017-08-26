package chapter3;

import java.util.List;

/**
 * Created by zhangyue-k on 2017/8/23.
 * User:zhangyue-k
 * Date:2017/8/23
 */
public class SpreadsheetAgentFinder implements AgentFinder {
    private String type;
    private String path;

    public String getType() {
        return type;
    }

    public String getPath() {
        return path;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public List<Agent> findAllAgents() {
        return null;
    }
}
