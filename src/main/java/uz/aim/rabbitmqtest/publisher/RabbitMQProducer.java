package uz.aim.rabbitmqtest.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


/**
 * @author : Abbosbek Murodov
 * @since : 01/04/23 / 14:56
 * Project : rabbitmq-test / IntelliJ IDEA
 */

@Service
public class RabbitMQProducer {
    @Value("${rabbitmq.exchange.name}")
    private String exchange;
    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQProducer.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(String message) {
        LOGGER.info(String.format("Message send -> %s", message));
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
    }

}
