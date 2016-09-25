package com.blacarapps.travivel;

import lombok.Data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class KinesisProp {
    @Value("${kinesis.access.key}")
    private String  awsAccessKey;
    @Value("${kinesis.secret.key}")
    private String  awsSecretKey;
    @Value("${kinesis.deliveryStreamName}")
    private String deliveryStreamName;

    // getters and setters here

}