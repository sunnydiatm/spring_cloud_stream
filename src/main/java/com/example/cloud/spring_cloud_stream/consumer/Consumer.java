package com.example.cloud.spring_cloud_stream.consumer;

import com.example.cloud.spring_cloud_stream.api.Sensor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.schema.client.EnableSchemaRegistryClient;

@EnableBinding(Sink.class)
@EnableSchemaRegistryClient
public class Consumer {
    private final Log logger = LogFactory.getLog(getClass());

    @StreamListener(Sink.INPUT)
    public void process(Sensor data) {
        System.out.println("Received data !! "+data.toString());
        System.out.println("getId "+data.getId());
        System.out.println("getAcceleration "+data.getAcceleration());
        System.out.println("getExternalTemperature "+data.getExternalTemperature());
        System.out.println("getInternalTemperature "+data.getInternalTemperature());
        System.out.println("getVelocity "+data.getVelocity());
        logger.info(data);
    }

}
