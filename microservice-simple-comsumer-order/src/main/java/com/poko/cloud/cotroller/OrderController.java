package com.poko.cloud.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.poko.cloud.entity.User;

@RestController
public class OrderController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${user.servicePath}")
	private String userServicePath;
	
	@GetMapping("/order/{id}")
	public User findById(@PathVariable Long id){
		return restTemplate.getForObject(this.userServicePath + id, User.class);
	}
}
