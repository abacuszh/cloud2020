package org.aiguigu.springcloud.service;

import org.aiguigu.springcloud.entities.Payment;

/**
 * @author bbb
 *
 */
public interface PaymentService {

	public int save(Payment payment);

	public Payment getPaymentById(Long id);

	public String paymentInfo_OK(Long id);

	public String paymentInfo_Timeout(Long id);
	
	public String paymentCircuitBreaker(Long id);
}
