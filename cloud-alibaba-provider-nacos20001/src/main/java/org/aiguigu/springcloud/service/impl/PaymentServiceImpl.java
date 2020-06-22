package org.aiguigu.springcloud.service.impl;

import org.aiguigu.springcloud.dao.PaymentDao;
import org.aiguigu.springcloud.entities.Payment;
import org.aiguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
