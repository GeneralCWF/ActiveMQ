package activemq.server;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class ActiveMQ_Main {
    public static void main(String[] args) throws JMSException {
        String url = "tcp://39.104.127.63:61616";
        //创建链接工厂
        ConnectionFactory factory = new ActiveMQConnectionFactory(url);
        //工厂模式创建链接
        Connection connection = factory.createConnection();
        //气动连接
        connection.start();
        //创建回话jms,第一个参数：是否开启事务，第二个参数：自动应答，不开启事务才能使用
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);

        //创建消息队列
        Queue queue = session.createQueue("hello");
        MessageProducer producer = session.createProducer(queue);
        TextMessage textMessage = session.createTextMessage("Hello ActiveMQ");

        producer.send(textMessage);

        producer.close();
        session.close();
        connection.close();


    }
}
