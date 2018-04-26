package com.itmuch.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.itmuch.cloud.ExcludeFromComponentScan;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
@ExcludeFromComponentScan
public class TestConfiguration {
/*	@Autowired
	IClientConfig config;*/

	@Bean
	public IRule ribbonRule() {
		System.out.println("1111111111111111111111");
		return new RandomRule();
	}
}

