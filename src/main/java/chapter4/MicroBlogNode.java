package chapter4;

/**
 * Created by zhangyue-k on 2017/8/26.
 * User:zhangyue-k
 * Date:2017/8/26
 */
//并发的另一个经典问题就是死锁   下面是一个死锁的例子
public class MicroBlogNode implements SimpleMicroBlogNode{
    private final String ident;

    public MicroBlogNode(String ident) {
        this.ident = ident;
    }

    public String getIdent() {
        return ident;
    }

    public synchronized void propagateUpdate(Update update,MicroBlogNode backup){
        System.out.println(ident + ":recvd:" + update.getUpdateText() + ";backup:" + backup.getIdent());
        backup.confirmUpdate(this,update);

    }

    public synchronized void confirmUpdate(MicroBlogNode other,Update update){
        System.out.println(ident + ":recvd confirm:" + update.getUpdateText() + " from " + other.getIdent());

    }

    final MicroBlogNode local =
            new MicroBlogNode("localhost:8888");
    final MicroBlogNode other =
            new MicroBlogNode("localhost:8988");
    final Update first = getUpdate("1");
    final Update second = getUpdate("2");






    public Update getUpdate(String updateText){
        //Update update = new Update();
        //update.setUpdateText(updateText);
        return null;
    }

}
