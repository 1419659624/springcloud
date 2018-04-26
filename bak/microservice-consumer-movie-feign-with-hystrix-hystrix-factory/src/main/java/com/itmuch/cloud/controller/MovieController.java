package com.itmuch.cloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.itmuch.cloud.entity.User;
import com.itmuch.cloud.feign.UserFeignClient;

@RestController
public class MovieController {
	
	@Autowired
	UserFeignClient userFeignClient;

	@GetMapping("/movid/{id}")
	public User findById(@PathVariable Long id){
		return userFeignClient.findById(id);
	}
	
	 @GetMapping("get-All")
	 public List getAll(){
		 return userFeignClient.getAll();
	 }
	
}