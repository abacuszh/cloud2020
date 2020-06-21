package org.aiguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringConfigClient4200 {

	public static void main(String[] args) {
		SpringApplication.run(SpringConfigClient4200.class);

	}

}
