package org.aiguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author bbb
 *
 */
@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
@EnableDiscoveryClient
public class PaymentConfigMain8002 {

	public static void main(String[] args) {
		SpringApplication.run(PaymentConfigMain8002.class, args);
	}

}
