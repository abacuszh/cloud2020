package org.aiguigu.springcloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.RestController;


@RestController
@EnableBinding(Sink.class)
public class MessageReceiverController {
	
	Logger logger = LoggerFactory.getLogger(MessageReceiverController.class);
	
	@Value("${server.port}")
	private String serverPort;
	
	@StreamListener(Sink.INPUT)
	public void receive(Message<String> message) {
		logger.info("consumer 1 {}, message payload is {}", serverPort, message.getPayload());
	}

}
