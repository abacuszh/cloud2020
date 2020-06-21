package org.aiguigu.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(value = "CLOUD-PAYMENT-SERVICE-HYSTRIX", fallback = FeignPaymentServiceFallbak.class)
public interface FeignPaymentService {

//	@PostMapping(value = "/base/payment/save")
//	public CommonResult save(@RequestBody Payment payment);
//	
//	@GetMapping(value = "/base/payment/get/{id}")
//	public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
		
	@GetMapping(value = "/base/payment/hystrix/ok/{id}")
	public String paymentInfoOK(@PathVariable("id") Long id) ;
	
	@GetMapping(value = "/base/payment/hystrix/timeout/{id}")
	public String paymentInfoTimeout(@PathVariable("id") Long id) ;
}
