import org.apache.zookeeper.KeeperException;
import org.testng.annotations.Test;

import java.io.IOException;

public class ZookeeperTest {
    @Test
    public void test() throws InterruptedException, IOException, KeeperException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Barrier barrier = null;
                try {
                    barrier = new Barrier("192.168.1.117","cdm666",2);
                    barrier.enter();
                    barrier.leave();
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Barrier barrier = null;
                try {
                    barrier = new Barrier("192.168.1.117","cdm666",2);
                    barrier.enter();
                    barrier.leave();
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();

    }
}
