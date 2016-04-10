import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.proto.WatcherEvent;

import java.io.IOException;

/**
 * Created by Mark on 2016/1/11.
 */
public class SyncPrimitive implements Watcher {
    static ZooKeeper zk = null;
    static final Object mutex = new Object();

    String root="/";

    SyncPrimitive(String address)
            throws KeeperException, IOException {
        if(zk == null){
            System.out.println("Starting ZK:");
            zk = new ZooKeeper(address, 3000, this);

            System.out.println("Finished starting ZK: " + zk);
        }
    }

    public void process(WatcherEvent event) {
        synchronized (mutex) {
            mutex.notify();
        }
    }

    @Override
    public void process(WatchedEvent event) {

    }
}
