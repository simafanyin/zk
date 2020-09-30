package zookeeperLearn;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.Watcher.Event;

public class CreateAsyncDemo implements Watcher {

    private  static  CountDownLatch latch =  new  CountDownLatch(1);

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        ZooKeeper zk = new ZooKeeper("127.0.0.1:2181", 5000, new CreateAsyncDemo());
        latch.await();
        zk.create("/testAsyn001",  "testAsyn001".getBytes(),  ZooDefs.Ids.OPEN_ACL_UNSAFE,  CreateMode.EPHEMERAL, new IStringCallback(), "我是上下文");
        zk.create("/testAsyn002",  "testAsyn002".getBytes(),  ZooDefs.Ids.OPEN_ACL_UNSAFE,  CreateMode.EPHEMERAL_SEQUENTIAL, new IStringCallback(), "我是上下文");
        Thread.sleep(10000);
        System.out.println(123);
    }
    @Override
    public void process(WatchedEvent event) {
        System.out.println("触发了监听事件："+ event);
        if(Event.KeeperState.SyncConnected  == event.getState()) {
            latch.countDown();
        }
    }
}

class  IStringCallback  implements  AsyncCallback.StringCallback {
    @Override
    public void processResult(int rc,  String path,  Object ctx,  String name) {
        System.out.println("创建节点完毕的回调函数:[rc:"+rc+",path:"+path+",ctx:"+ctx+",name:"+name+"]");
    }
    
}
