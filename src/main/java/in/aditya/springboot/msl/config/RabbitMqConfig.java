package in.aditya.springboot.msl.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.springframework.amqp.rabbit.support.micrometer.RabbitTemplateObservation.TemplateLowCardinalityTags.ROUTING_KEY;

@Configuration
public class RabbitMqConfig {

    @Value("${app.rabbitmq.queue}")
    private String queue;
    @Value("${app.rabbitmq.exchange}")
    private String exchange;
    @Value("${app.rabbitmq.routingkey}")
    private String routingKey;

    @Bean
    public Queue getQueue() {
        return new Queue(queue, true);
    }
    @Bean
    public TopicExchange getExchange() {
        return new TopicExchange(exchange);
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with(routingKey);
    }

}
