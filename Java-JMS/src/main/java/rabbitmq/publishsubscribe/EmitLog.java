package rabbitmq.publishsubscribe;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.util.concurrent.TimeoutException;

public class EmitLog {
    private static final String EXCHANGE_NAME = "logs";
    public static void main(String[] argv)
            throws java.io.IOException, TimeoutException {
        // 创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        // 配置连接工厂
        factory.setHost("localhost");
        // 创建到MQ的连接
        Connection connection = factory.newConnection();
        // 获取通道
        Channel channel = connection.createChannel();
        // 声明交换区类型
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
        // 取得要发送的内容
        String message = getMessage(argv);
        // 以字节数组的形式把消息发送到交换区
        channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");
        // 释放资源
        channel.close();
        connection.close();
    }
    private static String getMessage(String[] strings) {
        if (strings.length < 1)
            return "Hello World!";
        return joinStrings(strings, " ");
    }

    private static String joinStrings(String[] strings, String delimiter) {
        int length = strings.length;
        if (length == 0)
            return "";
        StringBuilder words = new StringBuilder(strings[0]);
        for (int i = 1; i < length; i++) {
            words.append(delimiter).append(strings[i]);
        }
        return words.toString();
    }
}