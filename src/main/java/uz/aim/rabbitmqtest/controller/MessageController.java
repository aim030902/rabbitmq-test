package uz.aim.rabbitmqtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.aim.rabbitmqtest.publisher.RabbitMQProducer;

/**
 * @author : Abbosbek Murodov
 * @since : 01/04/23 / 15:10
 * Project : rabbitmq-test / IntelliJ IDEA
 */

@RestController
@RequestMapping("/api/rabbitmq")
public class MessageController {
    @Autowired
    RabbitMQProducer producer;
    @GetMapping("/publish")
    public ResponseEntity<?> sendMessage(@RequestParam String message) {
        producer.sendMessage(message);
        return ResponseEntity.ok("Message sent to RabbitMQ");
    }
}
