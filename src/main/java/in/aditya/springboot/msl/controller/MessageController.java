package in.aditya.springboot.msl.controller;


import in.aditya.springboot.msl.service.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageProducer producer;

    @PostMapping
    public ResponseEntity<String> send(@RequestBody String msg) {
        producer.sendMessage(msg);
        return ResponseEntity.ok("Message sent to RabbitMQ!");
    }
}