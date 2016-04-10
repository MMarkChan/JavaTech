namespace java basic.basic

/**
* 1.数据类型

      基本类型：
          bool：布尔值，true 或 false，对应 Java 的 boolean
          byte：8 位有符号整数，对应 Java 的 byte
          i16：16 位有符号整数，对应 Java 的 short
          i32：32 位有符号整数，对应 Java 的 int
          i64：64 位有符号整数，对应 Java 的 long
          double：64 位浮点数，对应 Java 的 double
          string：utf-8编码的字符串，对应 Java 的 String
      结构体类型：
          struct：定义公共的对象，类似于 C 语言中的结构体定义，在 Java 中是一个 JavaBean
      容器类型：
          list：对应 Java 的 ArrayList
          set：对应 Java 的 HashSet
          map：对应 Java 的 HashMap
      异常类型：
          exception：对应 Java 的 Exception
      服务类型：
          service：对应服务的类

  2.服务端编码基本步骤：

      实现服务处理接口impl
      创建TProcessor
      创建TServerTransport
      创建TProtocol
      创建TServer
      启动Server

  3.客户端编码基本步骤：

      创建Transport
      创建TProtocol
      基于TTransport和TProtocol创建 Client
      调用Client的相应方法

  4.数据传输协议

      TBinaryProtocol : 二进制格式.
      TCompactProtocol : 压缩格式
      TJSONProtocol : JSON格式
      TSimpleJSONProtocol : 提供JSON只写协议, 生成的文件很容易通过脚本语言解析

      客户端和服务端的协议要一致

      编译thrift生成java文件：
      basic-0.8.0.exe -r -gen java ./demoHello.basic
**/
service  HelloWorldService {
  string sayHello(1:string username)
}