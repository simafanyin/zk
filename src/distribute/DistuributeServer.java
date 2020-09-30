package distribute;

import java.io.IOException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

public class DistuributeServer {

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        
        DistuributeServer server = new DistuributeServer();
        
        // 1.获取zk集群链接
        server.getConnect();
        
        // 2.注册节点
        server.regist(args[0]);
        
        // 3.业务逻辑
        server.business();
    }
    
    private String connectString = "127.0.0.1:2181,127.0.0.1:2182";
    private int sessionTimeout = 2000;
    private ZooKeeper zkClient;
    
    public void business() throws InterruptedException {
        Thread.sleep(Long.MAX_VALUE);
    }
    
 public void regist(String hostName) throws KeeperException, InterruptedException {
     
        String path = zkClient.create("/servers/server", hostName.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println(hostName + " is onLine");
    }
    
    public void getConnect() throws IOException {
        zkClient = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            
            @Override
            public void process(WatchedEvent event) {
                System.out.println(event.getState());
                System.out.println(event.getType());
            }
        });
    }
}
