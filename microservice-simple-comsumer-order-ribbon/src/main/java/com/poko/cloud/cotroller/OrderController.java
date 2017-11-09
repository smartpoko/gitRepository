package com.poko.cloud.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.poko.cloud.entity.User;
import com.poko.config.TestConfiguration;

@RestController
@RibbonClient(name="ms-provider-user", configuration=TestConfiguration.class)
public class OrderController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private LoadBalancerClient LoadBalancerClient;

	@GetMapping("/order/{id}")
	public User findById(@PathVariable Long id) {
		ServiceInstance serviceInstance = this.LoadBalancerClient.choose("ms-provider-user");
		System.out.println(serviceInstance.getHost() + ":" + serviceInstance.getPort());
		return restTemplate.getForObject("http://ms-provider-user/user/" + id, User.class);
	}

	@GetMapping("/test")
	public String test() {
		ServiceInstance serviceInstance = this.LoadBalancerClient.choose("ms-provider-user");
		System.out.println(serviceInstance.getHost() + ":" + serviceInstance.getPort());
		return "1";
	}
}
