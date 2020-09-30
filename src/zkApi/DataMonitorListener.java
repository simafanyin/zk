package zkApi;

public interface DataMonitorListener {

    /*
     * The existence status of the node has changed.
     */
    void exists(byte data[]);

    /*
     * The ZooKeeper session is no longer valid.
     */
    void closing(int rc);
}
