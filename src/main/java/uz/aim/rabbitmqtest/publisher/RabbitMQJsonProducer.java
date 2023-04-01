package uz.aim.rabbitmqtest.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import uz.aim.rabbitmqtest.dtos.UserDTO;


/**
 * @author : Abbosbek Murodov
 * @since : 01/04/23 / 14:56
 * Project : rabbitmq-test / IntelliJ IDEA
 */

@Service
public class RabbitMQJsonProducer {
    @Value("${rabbitmq.exchange.name}")
    private String exchange;
    @Value("${rabbitmq.routing.json.key}")
    private String routingKey;

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonProducer.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendJsonMessage(UserDTO dto) {
        LOGGER.info(String.format("Json message send -> %s", dto.toString()));
        rabbitTemplate.convertAndSend(exchange, routingKey, dto);
    }

}
