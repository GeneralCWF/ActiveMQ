package activemq.client;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class ActiveMQ_Client {
    public static void main(String[] args) throws JMSException {
        String url = "tcp://39.104.127.63:61616";
        ConnectionFactory factory = new ActiveMQConnectionFactory(url);

        Connection connection = factory.createConnection();

        connection.start();


        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);

        Queue queue = session.createQueue("hello");
        MessageConsumer consumer = session.createConsumer(queue);
        TextMessage textMessage = (TextMessage) consumer.receive();
        System.out.println(textMessage.getText());
        consumer.close();
        session.close();
        connection.close();
    }
}
