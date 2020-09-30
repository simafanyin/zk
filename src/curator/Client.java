//package curator;
//
//import java.util.List;
//
//import org.apache.curator.framework.CuratorFramework;
//import org.apache.curator.framework.CuratorFrameworkFactory;
//import org.apache.curator.framework.recipes.cache.NodeCache;
//import org.apache.curator.retry.ExponentialBackoffRetry;
//
//public class Client {
//
//    public static CuratorFramework getClient() {
//        return CuratorFrameworkFactory.builder()
//                // 服务器地址
//                .connectString("127.0.0.1:2181,127.0.0.1:2182,127.0.0.1:2183")
//                .retryPolicy(new ExponentialBackoffRetry(1000, 3))
//                // 连接超时时间，默认15秒
//                .connectionTimeoutMs(15 * 1000)
//                // 会话超时时间，默认60秒 
//                .sessionTimeoutMs(60 * 1000)
//                // 设置命名空间
//                .namespace("arch")
//                .build();
//                
//    }
//    
//    
//    
//    @SuppressWarnings("deprecation")
//    public static void main(String[] args) throws Exception {
//        CuratorFramework client = getClient();
//        Thread.sleep(1000);
//        System.out.println(client.getState());
//        client.start();
//        Thread.sleep(1000);
//        System.out.println(client.getState());
//        @SuppressWarnings("deprecation")
//        NodeCache nodeCache = new NodeCache(client, "/");
//        nodeCache.start(true);
//
//        nodeCache.getListenable().addListener(() -> System.out.println("node data change, new data is " + new String(nodeCache.getCurrentData().getData())));
//        Thread.sleep(Integer.MAX_VALUE);
//    }
//}
