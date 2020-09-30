//package zookeeperLearn;
//
//import java.io.IOException;
//
//import org.apache.curator.framework.listen.Listenable;
//import org.apache.zookeeper.CreateMode;
//import org.apache.zookeeper.KeeperException;
//import org.apache.zookeeper.WatchedEvent;
//import org.apache.zookeeper.Watcher;
//import org.apache.zookeeper.ZooDefs;
//import org.apache.zookeeper.ZooKeeper;
//import org.apache.zookeeper.data.Stat;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//public class ZookeeperDemo {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(ZookeeperDemo.class);
//
//    private static final int SESSION_TIME_OUT = 10000;
//    // ZooKeeper服务的地址，如为集群，多个地址用逗号分隔
//    private static final String CONNECT_STRING = "127.0.0.1:2181,127.0.0.1:2182,127.0.0.1:2183";
//    private static final String ZNODE_PATH = "/test";
//
//    private static ZooKeeper zk = null;
//
//    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
//        Stat stat = new Stat();
//        zk = new ZooKeeper(CONNECT_STRING, SESSION_TIME_OUT, new Watcher() {
//            @Override
//            public void process(WatchedEvent event) {
//                System.out.println("已经触发了" + event.getType() + "事件！");
//                System.out.println("路径" + event.getPath());
//                System.out.println("状态" + event.getState());
//                System.out.println(zk.getSessionId());
//                try {
//                    if (zk.exists("/hosts", false) != null) {
//                        System.out.println("state: " + zk.getState());
//                        zk.getData("/hosts", true, stat);
//                    }
//                } catch (KeeperException | InterruptedException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//                // 重新添加watch， 监测值变化
//            }
//        });
////        System.out.println(zk.getChildren("/", false));
////        zk.create(ZNODE_PATH, "123".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
////        byte[] data1 = zk.getData(ZNODE_PATH, false, null);
////        zk.getData("/hosts", new Watcher() {
////            @Override
////            public void process(WatchedEvent event2) {
////                System.out.println("2已经触发了" + event2.getType() + "事件！");
////                System.out.println("2路径" + event2.getPath());
////                System.out.println("2状态" + event2.getState());
////            }
////        }, stat);
////        zk.getChildren("/hosts", new Watcher() {
////            
////            @Override
////            public void process(WatchedEvent event3) {
////                System.out.println("3已经触发了" + event3.getType() + "事件！");
////                System.out.println("3路径" + event3.getPath());
////                System.out.println("3状态" + event3.getState());
////            }
////        });
////        System.out.println(new String(data1));
////        Thread.sleep(300000);
//    }
//
//}
