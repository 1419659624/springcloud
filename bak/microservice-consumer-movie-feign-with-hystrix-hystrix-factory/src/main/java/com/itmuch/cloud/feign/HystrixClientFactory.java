package com.itmuch.cloud.feign;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.itmuch.cloud.entity.User;

import feign.hystrix.FallbackFactory;

@Component
public class HystrixClientFactory implements FallbackFactory<UserFeignClient>{
	private static final Logger logger=LoggerFactory.getLogger(HystrixClientFactory.class);
	@Override
	public UserFeignClient create(Throwable cause) {
		HystrixClientFactory.logger.info("fallback; reason was: " + cause.getMessage());
		// TODO Auto-generated method stub
		return new UserFeignClientWithFactory() {

			@Override
			public List getAll() {
				return null;
			}

			@Override
			public User findById(Long id) {
				User u=new User();
				u.setId(-1L);
				return u;
			}
		};
	}

}
