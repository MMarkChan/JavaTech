package net.urlbase;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import static utils.CommonUtils.*;

/**
 * 当我们得到一个URL对象后，就可以通过它读取指定的WWW资源。这时我们将使用URL的方法openStream()，
 * 其定义为：InputStream openStream();方法openSteam()与指定的URL建立连接并返回InputStream类
 * 的对象以从这一连接中读取数据。
 *
 * 类URL的方法openStream()是通过URLConnection来实现的,等价于openConnection().getInputStream();
 *
 * 基于URL的网络编程在底层其实还是基于Socket接口的。WWW，FTP等标准化的网络服务都是基于TCP协议的，
 * 所以本质上讲URL编程也是基于TCP的一种应用.
 *
 *
 */
public class URLReader {

    public static void main(String[] args) throws Exception {
        URL url = new URL("http://zhidao.baidu.com/daily/view?id=9619");

        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(),"gbk"));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            println(inputLine);
        }

        println(url.getPath());
        in.close();
    }
}