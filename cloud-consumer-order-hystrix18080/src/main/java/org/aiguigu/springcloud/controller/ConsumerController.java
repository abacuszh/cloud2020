package org.aiguigu.springcloud.controller;

import org.aiguigu.springcloud.entities.CommonResult;
import org.aiguigu.springcloud.entities.Payment;
import org.aiguigu.springcloud.service.FeignPaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(tags = "ConsumerController")
//@DefaultProperties(defaultFallback = "paymentglobalFallbackMethod", commandProperties = {
//		@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500") })
public class ConsumerController {
	
	Logger logger = LoggerFactory.getLogger(ConsumerController.class);
	
	@Autowired
	private FeignPaymentService feignPaymentService;
	
//	@PostMapping("/payment/save")
//	@ApiOperation("save")
//	public CommonResult<Payment> save(@RequestBody Payment payment) {
//		return this.feignPaymentService.save(payment);
//	}
//	
//	@GetMapping("/payment/get/{id}")
//	@ApiOperation("getPaymentById")
//	public CommonResult getPaymentById(@PathVariable("id") Long id) {
//		return this.feignPaymentService.getPaymentById(id);
//	}

//	@GetMapping("/payment/getEntity/{id}")
//	@ApiOperation("getPaymentEntityById")
//	public CommonResult getPaymentEntityById(@PathVariable("id") Long id) {
//		ResponseEntity<CommonResult> entity = this.restTemplate.getForEntity(String.format(URL_PAYMENT_BASE + URL_PAYMENT_GET, id), CommonResult.class);
//		if ( entity.getStatusCode().is2xxSuccessful() ) {
//			return entity.getBody();
//		} else {
//			return new CommonResult<>(Response.SC_BAD_REQUEST, "No such payment record");
//		}
//	}
	
	@GetMapping(value = "/payment/hystrix/ok/{id}")
	@ApiOperation("paymentInfoOk")
	public String paymentInfoOK(@ApiParam(name = "id", value = "id", required = true)  @PathVariable("id") Long id) {
		return this.feignPaymentService.paymentInfoOK(id);
	}
	
	@GetMapping(value = "/payment/hystrix/timeout/{id}")
	@ApiOperation("paymentInfoTimeout")
//	@HystrixCommand
//	@HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler", commandProperties = {
//			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500") })
	public String paymentInfoTimeout(@ApiParam(name = "id", value = "id", required = true)  @PathVariable("id") Long id) {
		return this.feignPaymentService.paymentInfoTimeout(id);
	}
	
	

//	public String paymentInfoTimeoutHandler(Long id) {
//		return "Current Thread: " + Thread.currentThread().getName() + "TimeoutHandler";
//	}
	
}
