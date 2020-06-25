package org.aiguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
public class SpringRestDataMain8010 {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestDataMain8010.class, args);

	}

}
