package org.aiguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableFeignClients
//@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = CustomRule.class)
public class ConsumerFeignMain18086 {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerFeignMain18086.class);

	}

}
