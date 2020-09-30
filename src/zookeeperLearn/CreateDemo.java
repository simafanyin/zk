package zookeeperLearn;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import com.test.JSON;

public class CreateDemo implements Watcher{
    
    private  static  CountDownLatch latch =  new  CountDownLatch(1);

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        ZooKeeper zk = new ZooKeeper("127.0.0.1:2181", 5000, new CreateDemo());
        latch.await();
        Map<String, Object> tempMap = new HashMap<>();
        tempMap.put("count", 46);
        tempMap.put("ipConfig", "127.0.0.1:2181");
        String data = tempMap.toString();
        String path1 = zk.create("/servers/_lock_", data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,  CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println("创建有序节点:"+path1);
        String data2 = JSON.from(tempMap).toString();
        String path2 = zk.create("/servers/_lock_",  data2.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,  CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println("创建有序节点:"+path2);
        System.out.println(Integer.valueOf("00000001"));
        Thread.sleep(300000);
    }
    @Override
    public void process(WatchedEvent event) {
        System.out.println("触发了监听事件："+ event);
        if(Event.KeeperState.SyncConnected  == event.getState()) {
            latch.countDown();
        }
    }

}
