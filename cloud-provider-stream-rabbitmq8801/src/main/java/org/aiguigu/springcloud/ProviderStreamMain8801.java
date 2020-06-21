package org.aiguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProviderStreamMain8801 {

	public static void main(String[] args) {
		SpringApplication.run(ProviderStreamMain8801.class);

	}

}
