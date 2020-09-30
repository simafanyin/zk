package zookeeperLearn;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

public class SessionDemo implements Watcher{

    private  static  CountDownLatch latch =  new  CountDownLatch(1);
    
    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        ZooKeeper zk = new ZooKeeper("127.0.0.1:2181", 5000, new SessionDemo());
        System.out.println("state: " + zk.getState());
        latch.await();
        System.out.println(123);
    }
    
    @Override
    public void process(WatchedEvent event) {
        System.out.println("触发了监听事件："+event);
        if(Event.KeeperState.SyncConnected  == event.getState()) {
            latch.countDown();
        }
    }
    
    
}
