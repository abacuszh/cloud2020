package org.aiguigu.springcloud.filter;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class CustomLogGatewayFilter implements GlobalFilter, Ordered {
	
	Logger logger = LoggerFactory.getLogger(CustomLogGatewayFilter.class);

	@Override
	public int getOrder() {
		// TODO Auto-generated method stub
		return 100;
	}

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		logger.info("Custom Global Filter: {}", UUID.randomUUID().toString());
		String uname = exchange.getRequest().getQueryParams().getFirst("uname");
		if ( uname == null ) {
			logger.info("Invalid user name ");
			exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
			return exchange.getResponse().setComplete();
		}
		return chain.filter(exchange);
	}

}
