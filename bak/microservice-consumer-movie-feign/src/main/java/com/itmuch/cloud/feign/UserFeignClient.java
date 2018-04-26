package com.itmuch.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itmuch.cloud.entity.User;

@FeignClient("microservice-provider-user")
public interface UserFeignClient {
	@GetMapping("/simple/{id}")
	public User findById(@PathVariable("id") Long id);
	
	@PostMapping("/user")
	public User postUser(@RequestBody User user);
	
	@GetMapping("/get-user")
	public User getUser(@RequestBody User user);
}
