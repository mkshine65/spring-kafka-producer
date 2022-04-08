package com.example.springkakfa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class KafkaController {

    @Autowired
    KafkaTemplate<String,String> kafkaTemplate;

    @Autowired
    KafkaTemplate<String,Employee> kafkaTemplateEmployee;

    private final String TOPIC="NewTopic";

    /**
     * This Method publishes the message to the kafka server. It produces the message <String,String>
     * @param message
     * @return
     */
    @GetMapping("/publish/{message}")
    public String publishMessage(@PathVariable String message)
    {
        kafkaTemplate.send(TOPIC,message);
        return "Published Succesfully";
    }


    @PostMapping("/update")
    public String publishEmployeeMessage(@RequestBody Employee e)
    {
        kafkaTemplateEmployee.send(TOPIC,e);
        return "Successfully sent";
    }
}
