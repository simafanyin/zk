package zkApi;

public class FileDemo {
    
//    private static final String CONNECT_STRING = "127.0.0.1:2181,127.0.0.1:2182,127.0.0.1:2183";
    private static final String CONNECT_SINGLE = "127.0.0.1:2181";
    private static final String ZNODE_PATH = "/servers";

    public static void main(String[] args) {
        String[] exec = new String[] {CONNECT_SINGLE, ZNODE_PATH, "test"};
        try {
            new Executor(CONNECT_SINGLE, ZNODE_PATH, "test", exec).run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
