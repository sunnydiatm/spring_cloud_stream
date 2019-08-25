package com.example.cloud.spring_cloud_stream.producer;

import com.example.cloud.spring_cloud_stream.api.Sensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.cloud.stream.schema.client.EnableSchemaRegistryClient;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.UUID;

@EnableSchemaRegistryClient
@EnableBinding(Source.class)
@RestController
public class Producer {

    @Autowired
    private Source source;

    private Random random = new Random();

    @RequestMapping(value = "/messages", method = RequestMethod.POST)
    public String sendMessage() {
        source.output().send(MessageBuilder.withPayload(randomSensor()).build());
        return "ok, have fun with v2 payload!";
    }
    private Sensor randomSensor() {
        Sensor sensor = new Sensor();
        sensor.setId(UUID.randomUUID().toString() + "-v2");
        sensor.setAcceleration(random.nextFloat() * 10);
        sensor.setVelocity(random.nextFloat() * 100);
        sensor.setInternalTemperature(random.nextFloat() * 50);
        sensor.setExternalTemperature(random.nextFloat() * 60);
        return sensor;
    }
}
