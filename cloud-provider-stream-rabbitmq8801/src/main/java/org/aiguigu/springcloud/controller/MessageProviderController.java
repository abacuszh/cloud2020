package org.aiguigu.springcloud.controller;

import org.aiguigu.springcloud.service.IServiceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageProviderController {
	
	@Autowired
	private IServiceProvider serviceProvider;
	
	@GetMapping("/send")
	public String sendMessage() {
		return serviceProvider.send();
	}

}
