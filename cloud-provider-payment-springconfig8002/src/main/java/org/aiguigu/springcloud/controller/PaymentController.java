package org.aiguigu.springcloud.controller;

import java.util.List;

import org.aiguigu.springcloud.entities.CommonResult;
import org.aiguigu.springcloud.entities.Payment;
import org.aiguigu.springcloud.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


/**
 * @author bbb
 *
 */
@RestController
@Api(tags = "PaymentController", description = "Payment Rest API")
@RefreshScope
public class PaymentController {

	Logger log = LoggerFactory.getLogger(PaymentController.class);
	
	private static final String SERVICE_NAME="CLOUD-PAYMENT-SERVICE";
	
	@Autowired
	private PaymentService paymentService;
	
	@Value("${server.port}")
	private String serverPort;
	
	@Value("${config.info}")
	private String configInfo;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@PostMapping(value = "/payment/save")
	@ApiOperation("save")
	public CommonResult save(@RequestBody Payment payment) {
		int result = paymentService.save(payment);
		log.info("insert success, result is {}", result);
		
		if ( result > 0 ) {
			return new CommonResult(200, "success" + serverPort, result);
		} else {
			return new CommonResult(400, "failed", null);
		}
	}
	
	@GetMapping(value = "/payment/get/{id}")
	@ApiOperation("getPaymentById")
	public CommonResult<Payment> getPaymentById(@ApiParam(name = "id", value = "id", required = true)  @PathVariable("id") Long id) {
		Payment payment = paymentService.getPaymentById(id);
		log.info ("get payment {} ", payment);
		
		if ( payment != null ) {
			return new CommonResult<Payment> (200, "success" + serverPort, payment);
		} else {
			return new CommonResult<Payment> (400, "failed", null);
		}
	}
	
	@GetMapping(value = "/payment/discovery")
	public Object getServices() {
		discoveryClient.getServices().stream().forEach(n -> {
			log.info("Service Name {}", n);
		});
		
		discoveryClient.getInstances(SERVICE_NAME).stream().forEach( i -> {
			log.info("Instance info {} {} {} {}", i.getHost(), i.getPort(), i.getInstanceId(), i.getUri());
		});
		
		return discoveryClient;
	}
	
	@GetMapping("/configInfo")
	@ApiOperation("getConfigInfo")
	public String getConfigInfo() {
		return configInfo;
	}
}
