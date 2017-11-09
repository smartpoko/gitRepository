package com.poko.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroserviceDescoveryEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceDescoveryEurekaApplication.class, args);
	}
}
