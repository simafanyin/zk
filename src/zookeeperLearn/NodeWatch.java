package zookeeperLearn;

import java.io.IOException;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class NodeWatch implements Watcher{

    private ZooKeeper zk;
    private Stat stat;
    private String path;
    
    public NodeWatch(ZooKeeper zk, Stat stat, String path) {
        this.zk = zk;
        this.stat = stat;
        this.path = path;
    }
    
    @Override
    public void process(WatchedEvent event) {
        System.out.println("触发了" + event.getType() + "事件！");
        System.out.println("路径" + event.getPath());
        System.out.println("状态" + event.getState());
    }

}
