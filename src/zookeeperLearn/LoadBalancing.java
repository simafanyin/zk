package zookeeperLearn;

import java.util.ArrayList;
import java.util.List;

public class LoadBalancing {

    private static List<String> serverList = new ArrayList<>();
    static {
        serverList.add("192.168.1.2");
        serverList.add("192.168.1.3");
        serverList.add("192.168.1.4");
        serverList.add("192.168.1.5");
    }

    public static void main(String[] args) {
        
        for (int i = 1; i < 100; i++) { 
            String ip = "10.1.0." + i;
            System.out.println(ipHash(ip));
        }
    }
       
    /**..;
     * ip hash 路由算法
     */
    public static String ipHash(String ip) {
        // 复制遍历用的集合，防止操作中集合有变更
        List<String> tempList = new ArrayList<>(serverList.size());
        tempList.addAll(serverList);
        // 哈希计算请求的服务器
        int index = ip.hashCode() % serverList.size();
        System.out.println(ip.hashCode());
        return tempList.get(Math.abs(index));
    }



}
