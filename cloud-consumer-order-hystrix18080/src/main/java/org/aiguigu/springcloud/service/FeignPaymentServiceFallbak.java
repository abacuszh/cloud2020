package org.aiguigu.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class FeignPaymentServiceFallbak implements FeignPaymentService{

//	@Override
//	public CommonResult save(Payment payment) {
//		return this.paymentglobalFallbackMethod();
//	}
//
//	@Override
//	public CommonResult<Payment> getPaymentById(Long id) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public String paymentInfoOK(Long id) {
		return this.paymentglobalFallbackMethod();
	}

	@Override
	public String paymentInfoTimeout(Long id) {
		//return "Current Thread: " + Thread.currentThread().getName() + "TimeoutHandler";
		return this.paymentglobalFallbackMethod();
	}

	public String paymentglobalFallbackMethod() {
		return "Global Fallback method, Current Thread: " + Thread.currentThread().getName() + "TimeoutHandler";
	}
}
