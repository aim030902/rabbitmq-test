package uz.aim.rabbitmqtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.aim.rabbitmqtest.dtos.UserDTO;
import uz.aim.rabbitmqtest.publisher.RabbitMQJsonProducer;


/**
 * @author : Abbosbek Murodov
 * @since : 01/04/23 / 15:10
 * Project : rabbitmq-test / IntelliJ IDEA
 */

@RestController
@RequestMapping("/api/rabbitmq")
public class MessageJsonController {
    @Autowired
    RabbitMQJsonProducer producer;
    @PostMapping("/publish")
    public ResponseEntity<?> sendMessage(@RequestBody UserDTO dto) {
        producer.sendJsonMessage(dto);
        return ResponseEntity.ok("Json message sent to RabbitMQ");
    }
}
