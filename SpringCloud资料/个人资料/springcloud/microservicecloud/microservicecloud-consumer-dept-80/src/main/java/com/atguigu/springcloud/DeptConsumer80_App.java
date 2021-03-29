package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.atguigu.myrule.MySelfRule;

@SpringBootApplication
@EnableEurekaClient
//在启动该微服务的时候就能去加载我们的自定义Ribbon配置类，从而使配置生效
@RibbonClient(name="MICROSERVICECLOUD-DEPT",configuration=MySelfRule.class)//自定义负载均衡,如果没有这个注解，就会运行ConfigBean里面的负载均衡算法
public class DeptConsumer80_App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SpringApplication.run(DeptConsumer80_App.class, args);
	}

}
