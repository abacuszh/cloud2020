package org.aiguigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
		RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

		routes.route("baidu_news", r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();

		return routes.build();
	}
}
