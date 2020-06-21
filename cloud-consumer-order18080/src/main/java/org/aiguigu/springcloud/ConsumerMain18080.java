package org.aiguigu.springcloud;

import org.aiguigu.customlbrules.CustomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = CustomRule.class)
public class ConsumerMain18080 {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerMain18080.class);

	}

}
