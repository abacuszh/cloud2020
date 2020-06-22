package org.aiguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author bbb
 *
 */
@SpringBootApplication
@EnableSwagger2
@EnableDiscoveryClient
public class NacosProviderMain20002 {

	public static void main(String[] args) {
		SpringApplication.run(NacosProviderMain20002.class, args);
	}

}
