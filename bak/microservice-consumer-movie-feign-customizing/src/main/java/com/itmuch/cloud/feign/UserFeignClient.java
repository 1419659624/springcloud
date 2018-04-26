package com.itmuch.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itmuch.cloud.entity.User;
import com.itmuch.config.Configuration1;

import feign.Param;
import feign.RequestLine;

@FeignClient(name="microservice-provider-user",configuration=Configuration1.class)
public interface UserFeignClient {
	@RequestLine("GET /simple/{id}")
	public User findById(@Param("id") Long id);

}
