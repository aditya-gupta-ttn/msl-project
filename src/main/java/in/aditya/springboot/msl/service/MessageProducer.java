package in.aditya.springboot.msl.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Value("${app.rabbitmq.exchange}")
    private String exchange;

    @Value("${app.rabbitmq.routingkey}")
    private String routingKey;

    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
        System.out.println("Sent message: " + message);
    }
}
