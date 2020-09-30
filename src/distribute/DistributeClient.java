package distribute;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

public class DistributeClient {

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        
        DistributeClient client = new DistributeClient();
        
        // 1.获取zk集群链接
        client.getConnect();
        
        // 2.注册监听
        client.getChildren();
        
        // 3.业务逻辑
        client.business();
    }
    
    private String connectString = "127.0.0.1:2181,127.0.0.1:2182";
    private int sessionTimeout = 2000;
    private ZooKeeper zkClient;
    
    public void business() throws InterruptedException {
        Thread.sleep(Long.MAX_VALUE);
    }
    
    public void getChildren() throws KeeperException, InterruptedException {
        
        List<String> children = zkClient.getChildren("/servers", true);
        List<String> hosts = new ArrayList<>();
        for (String child : children) {
            byte[] data = zkClient.getData("/servers/" + child, false, null);
            hosts.add(new String(data));
        }
        System.out.println(hosts);
    }
    
    public void getConnect() throws IOException {
        zkClient = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            
            @Override
            public void process(WatchedEvent event) {
                try {
                    getChildren();
                } catch (KeeperException | InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
    }
    
}
