package activemq.server;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Topic_MQ_Main {
    public static void main(String[] args) throws JMSException {
        String url = "tcp://39.104.127.63:61616";
        ConnectionFactory factory = new ActiveMQConnectionFactory(url);
        Connection connection = factory.createConnection();
        connection.start();
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic("Topic");
        MessageProducer producer = session.createProducer(topic);
        TextMessage message = session.createTextMessage("Topic Active MQ");
        producer.send(message);
    }
}
