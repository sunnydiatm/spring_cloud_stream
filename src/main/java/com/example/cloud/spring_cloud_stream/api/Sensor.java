package com.example.cloud.spring_cloud_stream.api;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Sensor {
    private String id;
    private float acceleration;
    private  float velocity;
    private  float internalTemperature;
    private ArrayList<Long> accelerometer;
    private ArrayList<Long> magneticField;

    @Override
    public String toString() {
        return "Sensor{" +
                "id='" + id + '\'' +
                ", acceleration=" + acceleration +
                ", velocity=" + velocity +
                ", internalTemperature=" + internalTemperature +
                ", externalTemperature=" + externalTemperature +
                '}';
    }

    private  float externalTemperature;

    public float getAcceleration() {
        return acceleration;
    }

    public float getVelocity() {
        return velocity;
    }

    public float getInternalTemperature() {
        return internalTemperature;
    }

    public float getExternalTemperature() {
        return externalTemperature;
    }

    public void setExternalTemperature(float externalTemperature) { this.externalTemperature = externalTemperature; }

    public void setId(String id) {
        this.id = id;
    }

    public void setAcceleration(float acceleration) {
        this.acceleration = acceleration;
    }

    public void setVelocity(float velocity) {
        velocity = velocity;
    }

    public void setInternalTemperature(float internalTemperature) {
        this.internalTemperature = internalTemperature;
    }

    public String getId() {
        return id;
    }
}
