package net.urlbase;

import java.io.DataInputStream;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLConnection;
import static utils.CommonUtils.*;

/**
 * 通过URL的方法openStream()，我们只能从网络上读取数据，如果我们同时还想输出数据，
 * 例如向服务器端的CGI程序发送一些数据，我们必须先与URL建立连接，然后才能对其进行读写，
 * 这时就要用到类URLConnection了。CGI是公共网关接口（Common Gateway Interface）的简称，
 * 它是用户浏览器和服务器端的应用程序进行连接的接口
 */
public class URLConnectionReaderWriter {
    public static void main(String[] args) throws Exception {
        //创建URL对象
        URL url=new URL("http://www.javasoft.com/cgi-bin/backwards");
        //由URL对象获取URLConnection对象
        URLConnection conn=url.openConnection();
        conn.setDoOutput(true);
        //由URLConnection获取输入流，并构造DataInputStream对象
        DataInputStream dis=new DataInputStream(conn.getInputStream());
        String line=dis.readLine();
        println(line);
        //由URLConnection获取输出流，并构造PrintStream对象
        PrintStream ps=new PrintStream(conn.getOutputStream());

        ps.println("client…"); //向服务器写出字符串 "client…"
    }
}
