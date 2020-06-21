package org.aiguigu.springcloud.controller;

import javax.annotation.Resource;

import org.aiguigu.springcloud.entities.CommonResult;
import org.aiguigu.springcloud.entities.Payment;
import org.apache.catalina.connector.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "ConsumerController")
public class ConsumerController {
	
	Logger logger = LoggerFactory.getLogger(ConsumerController.class);
	
	private static final String URL_PAYMENT_BASE = "http://CLOUD-PAYMENT-SERVICE/base";
	private static final String URL_PAYMENT_SAVE = "/payment/save";
	private static final String URL_PAYMENT_GET = "/payment/get/%s";
	
	@Resource
	RestTemplate restTemplate;
	
	@PostMapping("/payment/save")
	@ApiOperation("save")
	public CommonResult<Payment> save(@RequestBody Payment payment) {
		return this.restTemplate.postForObject(URL_PAYMENT_BASE + URL_PAYMENT_SAVE, payment, CommonResult.class);
	}
	
	@GetMapping("/payment/get/{id}")
	@ApiOperation("getPaymentById")
	public CommonResult getPaymentById(@PathVariable("id") Long id) {
		return this.restTemplate.getForObject( String.format(URL_PAYMENT_BASE + URL_PAYMENT_GET, id), CommonResult.class);
	}

	@GetMapping("/payment/getEntity/{id}")
	@ApiOperation("getPaymentEntityById")
	public CommonResult getPaymentEntityById(@PathVariable("id") Long id) {
		ResponseEntity<CommonResult> entity = this.restTemplate.getForEntity(String.format(URL_PAYMENT_BASE + URL_PAYMENT_GET, id), CommonResult.class);
		if ( entity.getStatusCode().is2xxSuccessful() ) {
			return entity.getBody();
		} else {
			return new CommonResult<>(Response.SC_BAD_REQUEST, "No such payment record");
		}
	}
}
