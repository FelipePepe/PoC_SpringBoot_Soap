package com.soap;

import com.soap.client.SoapClient;
import com.soap.wsdl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootSoapApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootSoapApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSoapApplication.class, args);
    }

    @Bean
    CommandLineRunner init(SoapClient soapClient) {

        int numberA = 200;
        int numberB = 15;

        try {
            AddResponse addResponse = soapClient.getAddResponse(numberA, numberB);
            LOGGER.info("El resultado de {} + {} = {}", numberA, numberB, addResponse.getAddResult());

            SubtractResponse subtractResponse = soapClient.getSubtractResponse(numberA, numberB);
            LOGGER.info("El resultado de {} - {} = {}", numberA, numberB, subtractResponse.getSubtractResult());

            MultiplyResponse multiplyResponse = soapClient.getMultiplyResponse(numberA, numberB);
            LOGGER.info("El resultado de {} x {} = {}", numberA, numberB, multiplyResponse.getMultiplyResult());

            DivideResponse divideResponse = soapClient.getDivideResponse(numberA, numberB);
            LOGGER.info("El resultado de {} / {} = {}", numberA, numberB, divideResponse.getDivideResult());

        } catch (Exception ex) {
            LOGGER.error(ex.toString());
        }

        return null;
    }

}
