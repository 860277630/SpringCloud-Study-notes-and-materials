package org.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("org.example.dao")
@EnableFeignClients
public class SeataDemo1Application
{
    public static void main( String[] args )
    {
        SpringApplication.run(SeataDemo1Application.class,args);
    }
}
