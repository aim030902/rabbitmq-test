package uz.aim.rabbitmqtest.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import uz.aim.rabbitmqtest.dtos.UserDTO;

/**
 * @author : Abbosbek Murodov
 * @since : 01/04/23 / 15:24
 * Project : rabbitmq-test / IntelliJ IDEA
 */

@Service
public class RabbitMQJsonConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonConsumer.class);

    @RabbitListener(queues = {"${rabbitmq.queue.json.name}"})
    public void consume(UserDTO dto) {
        LOGGER.info(String.format("Json received message -> %s", dto.toString()));
    }
}
