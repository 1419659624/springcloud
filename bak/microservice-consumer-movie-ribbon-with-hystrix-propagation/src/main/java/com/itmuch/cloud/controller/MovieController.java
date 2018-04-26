package com.itmuch.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.annotation.SessionScope;

import com.itmuch.cloud.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
public class MovieController {
	@Autowired
	private RestTemplate restTemplate;


	@GetMapping("/movid/{id}")
	@HystrixCommand(fallbackMethod="findByIdFallBack",commandProperties={@HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE")})
	public User findById(@PathVariable Long id){
		return this.restTemplate.getForObject("http://microservice-provider-user/simple/"+id, User.class);
	}
	
	public User findByIdFallBack(Long id){
		User u=new User();
		u.setId(0L);
		return u;
	}
	

}