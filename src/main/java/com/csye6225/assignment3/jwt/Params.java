package com.csye6225.assignment3.jwt;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("params")
public class Params {
    public String trustStorePath="/home/ubuntu/truststore.jks";
    public String trustStorePassword="123456";
    public String defaultType="JKS";
}
