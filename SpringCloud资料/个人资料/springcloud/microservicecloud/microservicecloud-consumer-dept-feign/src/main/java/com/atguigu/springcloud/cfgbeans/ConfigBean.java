package com.atguigu.springcloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
public class ConfigBean {// boot-->spring applicationContext.xml---@Configuration代替配置

	/*
	 * 用注解的方式代替配置文件，其中有很多对应关系
	 * 
	 * @Bean public UserService getUserService(){
	 * 
	 * return new UserServiceImpl
	 * 
	 * }
	 * 
	 * applicationContext.xml==configbean（@Configuration） <bean id = "userService"
	 * class = "com.atguigu.tmall.userserviceImpl">
	 */
	@Bean
	@LoadBalanced // 负责负载均衡的注解，默认用的是轮询算法,
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	// 负载均衡的方法，使用的是随机的概念，覆盖默认的轮询算法，使用的是声明的随机算法
	@Bean
	public IRule myRule() {
		return new RandomRule();//达到的目的，用我们重新选择的随机算法替代默认的轮询，改成其他规则只需将RandomRule换成其他名字即可
/*		return new AvailabilityFilteringRule();
		return new ZoneAvoidanceRule();
		return new BestAvailableRule();
		return new RetryRule();
		return new WeightedResponseTimeRule();
		return new AvailabilityFilteringRule();*/
	}
}
