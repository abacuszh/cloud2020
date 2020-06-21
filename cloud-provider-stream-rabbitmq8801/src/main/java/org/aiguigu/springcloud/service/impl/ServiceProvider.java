package org.aiguigu.springcloud.service.impl;


import java.util.UUID;

import org.aiguigu.springcloud.service.IServiceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Source.class)
public class ServiceProvider implements IServiceProvider {

	@Autowired
	private MessageChannel output;
	
	@Override
	public String send() {
		String uuid = UUID.randomUUID().toString();
		output.send(MessageBuilder.withPayload(uuid).build());
		return null;
	}

}
