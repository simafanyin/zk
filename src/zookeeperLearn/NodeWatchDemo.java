package zookeeperLearn;

import java.io.IOException;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class NodeWatchDemo{

    private static ZooKeeper zk = null;
    
    public static void main(String[] args) throws InterruptedException, IOException, KeeperException {
        Stat stat = new Stat();
        ZooKeeper zk = new ZooKeeper("127.0.0.1:2181", 10000, null);
        new NodeWatch(zk, stat, "/hosts");
        Thread.sleep(20000);
    }

}
