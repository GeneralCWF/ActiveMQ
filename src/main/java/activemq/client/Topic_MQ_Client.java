package activemq.client;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Topic_MQ_Client {
    public static void main(String[] args) throws JMSException {
        String url = "tcp://39.104.127.63:61616";
        ConnectionFactory factory = new ActiveMQConnectionFactory(url);
        Connection connection = factory.createConnection();
        connection.start();
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic("Topic");

        MessageConsumer consumer = session.createConsumer(topic);
        consumer.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println(textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
