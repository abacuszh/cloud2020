package org.aiguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerSingleMain10080 {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerSingleMain10080.class);
	}

}
