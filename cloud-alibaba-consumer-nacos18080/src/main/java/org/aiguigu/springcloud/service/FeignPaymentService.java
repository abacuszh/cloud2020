package org.aiguigu.springcloud.service;

import org.aiguigu.springcloud.entities.CommonResult;
import org.aiguigu.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@FeignClient(value = "nacos-provider-service")
public interface FeignPaymentService {

	@PostMapping(value = "/base/payment/save")
	public CommonResult save(@RequestBody Payment payment);
	
	@GetMapping(value = "/base/payment/get/{id}")
	public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
		
}
