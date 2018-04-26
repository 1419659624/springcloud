package com.itmuch.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PathVariable;

import com.itmuch.config.Configuration2;

@FeignClient(name="xxxx",url="http://localhost:8761/",configuration=Configuration2.class)
public interface FeignClient2 {
	@GetMapping("/eureka/apps/{serviceName}")
	public  String findEurekaServiceName(@PathVariable("serviceName") String serviceName);


}
