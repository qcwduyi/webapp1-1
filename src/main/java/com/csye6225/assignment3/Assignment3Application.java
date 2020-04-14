package com.csye6225.assignment3;

import com.csye6225.assignment3.controller.FileController;
import com.csye6225.assignment3.jwt.Params;
import com.csye6225.assignment3.mbg.AutoGenerator;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

@SpringBootApplication
@EnableScheduling
public class Assignment3Application {

    @Autowired
    Params params;
    private final static Logger logger = LoggerFactory.getLogger(Assignment3Application.class);

    public static void main(String[] args) {

        System.setProperty("javax.net.ssl.trustStore", tsp);
        System.setProperty("javax.net.ssl.trustStorePassword", params.trustStorePassword);
        System.setProperty("javax.net.ssl.keyStoreType", params.defaultType);
        AutoGenerator auto =  new AutoGenerator();
        auto.createDatabaseTable();
        //auto.createDatabaseTableConnection();
        //auto.createDir();
        SpringApplication.run(Assignment3Application.class, args);
    }

    @PostConstruct
    void postConstruct(){
        File trustStoreFilePath = new File(params.trustStorePath);
        String tsp = trustStoreFilePath.getAbsolutePath();
        System.setProperty("javax.net.ssl.trustStore", tsp);
        System.setProperty("javax.net.ssl.trustStorePassword", params.trustStorePassword);
        System.setProperty("javax.net.ssl.keyStoreType", params.defaultType);
        logger.info("setup trust ssl for database");
    }

}
