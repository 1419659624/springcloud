package com.itmuch.cloud.feign;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.itmuch.cloud.entity.User;

@FeignClient(name="microservice-provider-user", fallback=HystrixClientFallback.class)
public interface UserFeignClient {
	@GetMapping("/simple/{id}")
	public User findById(@PathVariable("id") Long id);
	
	 @GetMapping("getAll")
	 public List getAll();
}

@Component
class HystrixClientFallback  implements UserFeignClient {

	@Override
	public User findById(Long id) {
		// TODO Auto-generated method stub
		User u=new User();
		u.setId(0L);
		return u;

	}

	@Override
	public List getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	}
