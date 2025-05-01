package in.aditya.springboot.msl.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {

    @RabbitListener(queues = "${app.rabbitmq.queue}")
    public void receiveMessage(String message) {
        System.out.println("Received message: " + message);
    }
}