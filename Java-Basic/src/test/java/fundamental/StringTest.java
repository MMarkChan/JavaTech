package fundamental;

import org.junit.Test;

/**
 * Created by Mark on 2016/3/21.
 */
public class StringTest {
    @Test
    public void intern(){
        String name = "cdm";// 在调用栈的帧中存储
        // 如果方法区中的常量池中没有"cdm"这个串，则把它添加到常量池
        String name2 = name.intern();
        System.out.print(name2);
    }
}
