/**
 * 基于URL的高层次Java网络编程
 *
 * URL(Uniform Resource Locator)是一致资源定位器的简称，它表示Internet上某一资源的地址。
 * 通过URL我们可以访问Internet上的各种网络资源，比如最常见的WWW，FTP站点。浏览器通过解析给定的URL
 * 可以在网络上查找相应的文件或其他资源。
 *
 *URL的组成
 protocol://resourceName
 　　协议名（protocol）指明获取资源所使用的传输协议，如http、ftp、gopher、file等，
    资源名（resourceName）则应该是资源的完整地址，包括主机名、端口号、文件名或文件内部的一个引用。
 例如：
    http://www.sun.com/ 协议名://主机名
    http://home.netscape.com/home/welcome.html 协议名://机器名＋文件名
    http://www.gamelan.com:80/Gamelan/network.html#BOTTOM 协议名://机器名＋端口号＋文件名＋内部引用

 创建URL
 为了表示URL， java.net中实现了类URL。我们可以通过下面的构造方法来初始化一个URL对象：
 　　（1） public URL (String spec);
 　　　　　通过一个表示URL地址的字符串可以构造一个URL对象。
 　　　　　URL urlBase=new URL("http://www. 263.net/")
 　　（2） public URL(URL context, String spec);
 　　　　　通过基URL和相对URL构造一个URL对象。
 　　　　　URL net263=new URL ("http://www.263.net/");
 　　　　　URL index263=new URL(net263, "index.html")
 　　（3） public URL(String protocol, String host, String file);
 　　　　　new URL("http", "www.gamelan.com", "/pages/Gamelan.net. html");
 　　（4） public URL(String protocol, String host, int port, String file);
 　　　　　URL gamelan=new URL("http", "www.gamelan.com", 80, "Pages/Gamelan.network.html");

 解析URL
 一个URL对象生成后，其属性是不能被改变的，但是我们可以通过类URL所提供的方法来获取这些属性：
 　　　public String getProtocol() 获取该URL的协议名。
 　　　public String getHost() 获取该URL的主机名。
 　　　public int getPort() 获取该URL的端口号，如果没有设置端口，返回-1。
 　　　public String getFile() 获取该URL的文件名。
 　　　public String getRef() 获取该URL在文件中的相对位置。
 　　　public String getQuery() 获取该URL的查询信息。
 　　　public String getPath() 获取该URL的路径
 　　  public String getAuthority() 获取该URL的权限信息
 　　　public String getUserInfo() 获得使用者的信息
 　　　public String getRef() 获得该URL的锚
 */
package net.urlbase;