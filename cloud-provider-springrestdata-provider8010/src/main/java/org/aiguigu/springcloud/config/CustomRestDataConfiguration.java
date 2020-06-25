package org.aiguigu.springcloud.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

@Configuration
public class CustomRestDataConfiguration {

	public RepositoryRestConfigurer repositoryRestConfigurer() {
//		return new RepositoryRestConfigurer() {
//			@Override
//			public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
//				config.setBasePath("/base");
//			}
//		};
		return null;
	}
}
