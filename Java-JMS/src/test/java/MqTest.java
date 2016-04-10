import org.junit.Test;

/**
 * Created by Mark on 2016/3/24.
 */
public class MqTest {
    @Test
    public void test(){
        String path = Class.class.getResource("sub/sub.xml").getPath();
        String path2 = this.getClass().getClassLoader().getResource("sub/sub.xml").getPath();

        System.out.println(path);
    }
}
