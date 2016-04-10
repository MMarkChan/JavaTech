package rabbitmq.publishsubscribe;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeoutException;

/**
 * 把日志输出到文件
 */
public class ReceiveLogsToFile {
    private static final String EXCHANGE_NAME = "logs";
    public static void main(String[] argv)
            throws java.io.IOException,
            InterruptedException, TimeoutException {
        // 创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        // 设置工厂
        factory.setHost("localhost");
        // 创建连接
        Connection connection = factory.newConnection();
        // 创建通道
        Channel channel = connection.createChannel();
        // 创建一个名称为logs的fanout类型的交换区
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
        // 创建一个空临时的队列
        String queueName = channel.queueDeclare().getQueue();
        // 把空的临时队列与名称为logs的交换区进行绑定
        channel.queueBind(queueName, EXCHANGE_NAME, "");

        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
        // 创建临时队列消费者
        QueueingConsumer consumer = new QueueingConsumer(channel);
        channel.basicConsume(queueName, true, consumer);
        while (true) {
            // 轮询临时消息队列
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            saveToFile(message);
        }
    }

    private static void saveToFile(String msg) {
        try {
            String dir = ReceiveLogsToFile.class.getClassLoader().getResource("").getPath();
            String logFileName = new SimpleDateFormat("yyyy-MM-dd")
                    .format(new Date());
            File file = new File(dir, logFileName+".txt");
            FileOutputStream fos = new FileOutputStream(file, true); // 第二个参数为true表示打开文件流的追加模式
            fos.write((msg + "\r\n").getBytes());
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}