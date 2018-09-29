package activemq.server;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class My_MQ_Main {
    public static void main(String[] args) throws JMSException {
        String url = "tcp://39.104.127.63:61616";

        //创建连接工厂
        ConnectionFactory factory = new ActiveMQConnectionFactory(url);
        //创建链接
        Connection connection = factory.createConnection();
        connection.start();
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);

        Queue queue = session.createQueue("HelloWorld");
        MessageProducer producer = session.createProducer(queue);
        TextMessage message = session.createTextMessage("Hello My ActiveMQ");
        producer.send(message);

        producer.close();
        session.close();
        connection.close();
    }
}
