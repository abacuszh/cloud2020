package org.aiguigu.springcloud.service.impl;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.aiguigu.springcloud.dao.PaymentDao;
import org.aiguigu.springcloud.entities.Payment;
import org.aiguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentDao paymentDao;

	@Override
	public int save(Payment payment) {
		return paymentDao.save(payment);
	}

	@Override
	public Payment getPaymentById(Long id) {
		return paymentDao.getPaymentById(id);
	}

	@Override
	@HystrixCommand(fallbackMethod = "paymentInfo_OKHandler", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000") })
	public String paymentInfo_OK(Long id) {
		return "Current Thread: " + Thread.currentThread().getName() + "OK";
	}

	public String paymentInfo_OKHandler(Long id) {
		return "Current Thread: " + Thread.currentThread().getName() + "OKHandler";
	}

	@Override
	@HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000") })
	public String paymentInfo_Timeout(Long id) {
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Current Thread: " + Thread.currentThread().getName() + "Timeout";
	}

	public String paymentInfo_TimeoutHandler(Long id) {
		return "Current Thread: " + Thread.currentThread().getName() + "TimeoutHandler";
	}
	
	// service meltdown method
	@HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback", commandProperties = {
			@HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "20"),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "20000"),
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
	})
	@Override
	public String paymentCircuitBreaker(@PathVariable("id") Long id) {
		if ( id < 0 ) throw new RuntimeException("id should be positive");
		String serialNumber = UUID.randomUUID().toString();
		return Thread.currentThread().getName() + "\t success " + serialNumber; 
	}
	
	public String paymentCircuitBreakerFallback(@PathVariable("id") Long id) {
		return "id cannot be negative";
	}
}
